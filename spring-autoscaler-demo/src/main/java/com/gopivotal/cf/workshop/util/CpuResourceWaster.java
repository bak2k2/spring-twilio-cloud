package com.gopivotal.cf.workshop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class conspires to waste CPU resources.  Its use should cause auto-scaling to occur.
 */
public class CpuResourceWaster {
	
	private ExecutorService executorService;

	@Autowired
	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public List<Long> findPrimes(long quantity) {

		List<Long> primeList = new ArrayList<Long>();
		List<Future<Long>> futureList = new ArrayList<Future<Long>>();
		if (quantity<1) return primeList;
		
		//	Launch threads to find prime numbers:
		long l = 0;
		while ( l++ < quantity) {
			futureList.add(
				executorService.submit(
					new NextPrimeNumberFinder(
						BulkRandomNumberMaker.generateRandom()
					)
				)
			);
		}
		
		// Gather results:
		try {
			for(Future<Long> future : futureList) {
				primeList.add( future.get(20,TimeUnit.SECONDS) );
			}
		} catch (Exception e) {
		    System.err.println("CpuResourceWaster threw exception: " + e.getCause());
		}
		
		return primeList;
		
	}
	

	/**
	 * Set many threads to work creating huge numbers of random 
	 * numbers, all in the name of squandering CPU.
	 */
	public List<Long> makeRandoms(long quantity) {

		List<Long> randomList = new ArrayList<Long>();
		List<Future<List<Long>>> futureList = new ArrayList<Future<List<Long>>>();
		if (quantity<1) return randomList;
		quantity = quantity;
		
		//	Launch threads to find random numbers:
		long l = 0;
		while ( l++ < quantity) {
			futureList.add(
				executorService.submit(
					new BulkRandomNumberMaker(quantity * 1000)
				)
			);
		}
		
		// Gather results:
		try {
			for(Future<List<Long>> future : futureList) {
				randomList.addAll( future.get(20,TimeUnit.SECONDS) );
			}
		} catch (Exception e) {
		    System.err.println("CpuResourceWaster threw exception: " + e.getCause());
		}
		
		return randomList;
		
	}
	
	
}

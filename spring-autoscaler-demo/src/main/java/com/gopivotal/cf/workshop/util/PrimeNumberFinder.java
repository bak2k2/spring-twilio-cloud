package com.gopivotal.cf.workshop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

public class PrimeNumberFinder {
	
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
						generateRandom()
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
		    System.err.println("PrimeNumberFinder threw exception: " + e.getCause());
		}
		
		return primeList;
		
	}
	
	private long generateRandom() {
		double random = Math.random() * 10000000;
		return (long)Math.round(random);
	}
}

package com.gopivotal.cf.workshop.util;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.Executors;

import org.junit.Test;

public class PrimeNumberFinderTest {

	CpuResourceWaster finder = new CpuResourceWaster();


	@Test
	public void test() {
		finder.setExecutorService(Executors.newCachedThreadPool());
		
		long numberToFind = 100000;
		
		List<Long> list = finder.findPrimes(numberToFind);
		assertTrue(list.size() == numberToFind);
		
		for (Long l : list) {
			System.out.println(l);
		}
	}

}

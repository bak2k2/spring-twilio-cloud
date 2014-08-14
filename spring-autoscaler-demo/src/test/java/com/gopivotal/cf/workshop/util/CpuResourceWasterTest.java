package com.gopivotal.cf.workshop.util;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CpuResourceWasterTest {

	CpuResourceWaster finder = new CpuResourceWaster();


	@Test
	public void testPrimes() {
		finder.setExecutorService(Executors.newCachedThreadPool());
		
		long numberToFind = 100000;
		
		List<Long> list = finder.findPrimes(numberToFind);
		assertTrue(list.size() == numberToFind);
		
	}

	@Test
	public void testRandoms() {
		finder.setExecutorService(Executors.newCachedThreadPool());
		
		long numberToFind = 100;
		
		List<Long> list = finder.makeRandoms(numberToFind);
		assertEquals(numberToFind * 100000,list.size());
		
	}

}

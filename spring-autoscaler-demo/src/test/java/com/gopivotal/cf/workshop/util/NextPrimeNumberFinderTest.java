package com.gopivotal.cf.workshop.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextPrimeNumberFinderTest {

	@Test
	public void test() throws Exception {
		assertEquals(2, findNextPrime(1) );
		assertEquals(3, findNextPrime(2) );
		assertEquals(5, findNextPrime(3) );
		assertEquals(5, findNextPrime(4) );
		assertEquals(7, findNextPrime(5) );
		assertEquals(1009, findNextPrime(1000) );
		assertEquals(10007, findNextPrime(10000) );
		assertEquals(100003, findNextPrime(100000) );
	}

	private long findNextPrime(long l) throws Exception {
		return (long) (new NextPrimeNumberFinder(l)).call();
	}
}

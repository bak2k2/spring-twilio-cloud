package com.pivotal.joker;

import org.junit.Assert;
import org.junit.Test;

public class JokeFetcherTests {
	final private JokeFetcher jokeFetcher = new JokeFetcher();

	@Test
	public void fetchJoke() {
		String jokeText = jokeFetcher.getRandomJoke().trim();
		Assert.assertTrue(jokeText.length() > 0);
		Assert.assertNotEquals(JokeFetcher.FETCH_ERROR, jokeText);
	}
}

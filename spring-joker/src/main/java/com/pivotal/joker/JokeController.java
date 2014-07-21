package com.pivotal.joker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JokeController {

	protected final JokeFetcher jokeService;

	@Autowired
	public JokeController(JokeFetcher jokeService) {
		this.jokeService = jokeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String getRandomJoke() {
		return jokeService.getRandomJoke();
	}

	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public @ResponseBody String getRandomJoke2() {
		return getRandomJoke();
	}
}

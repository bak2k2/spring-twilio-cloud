package com.pivotal.joker;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Service
public class JokeFetcher {
	public static final String FETCH_ERROR = "Unable to fetch data - and that's no joke!";

	public static final String JOKE_URL = "http://www.ajokeaday.com/ChisteAlAzar.asp";

	public String getRandomJoke() {
		try {
			// Fetch the random-joke page from www.ajokeaday.com using HtmlUnit
			final WebClient webClient = new WebClient();

			// Ignore JavaScript and/or any script errors
			WebClientOptions options = webClient.getOptions();
			options.setJavaScriptEnabled(false);
			options.setThrowExceptionOnScriptError(false);

			final HtmlPage page = webClient.getPage(JOKE_URL);

			// Extract web-page content as a String
			final String pageAsXml = page.asXml();
			webClient.closeAllWindows();

			// Use XPath to find the element: <div class="chiste"> which
			// contains the joke
			final XPathFactory xPathfactory = XPathFactory.newInstance();
			final XPath xpath = xPathfactory.newXPath();
			final XPathExpression expr = xpath
					.compile("//div[@class = 'chiste']");

			String joke = expr.evaluate(new InputSource(new StringReader(
					pageAsXml)));
			return joke;
		} catch (Exception e) {
			return FETCH_ERROR;
		}
	}
}

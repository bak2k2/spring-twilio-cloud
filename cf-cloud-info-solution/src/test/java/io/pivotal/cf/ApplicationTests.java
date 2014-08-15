package io.pivotal.cf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Simple test to check Application Context loads successfully.
 * <p>
 * Note that <tt>@SpringApplicationConfiguration</tt> is the Spring Boot
 * equivalent to the more familiar <tt>ContextConfiguration</tt>. Spring runs a
 * JUnit test, loads the specified @Configuration class (or XML if you prefer)
 * but using the Spring Boot context loader.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Test
	public void contextLoads() {
		// Nothing to do here, but test will fail if the application context
		// can't load.
	}

}

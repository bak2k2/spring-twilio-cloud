package io.pivotal.cf;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Run the application as a servlet application using Spring Boot. Will run in
 * any Servlet 3 compatible container as a WAR. If running locally, the root URL
 * will be <tt>http://localhost:8080/cf-session-demo</tt>.
 */
public class WebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(Config.class);
	}

}

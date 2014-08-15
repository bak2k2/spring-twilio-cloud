package io.pivotal.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Run the application as a Java application using Spring Boot. Will use an
 * embedded Tomcat container. If running locally, the root URL will be
 * <tt>http://localhost:8080</tt>.
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}
}

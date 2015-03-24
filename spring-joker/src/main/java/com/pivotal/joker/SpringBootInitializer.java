package com.pivotal.joker;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootInitializer extends SpringBootServletInitializer {

	/**
	 * Allows this application to run as a JEE servlet application as a WAR
	 * inside a container.
	 * 
	 * @param application
	 *            The Spring-Boot application, provided by the framework.
	 */
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		showBeans(application.context());
		return application.sources(SpringBootInitializer.class);
	}

	/**
	 * Run this application is a Java application and Spring Boot will run up an
	 * embedded servlet engine (Tomcat).
	 * 
	 * @param args
	 *            Command-line arguments (unused)
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootInitializer.class, args);
		showBeans(ctx);
	}

	/**
	 * Log the <tt>joker<tt> beans in the application context.
	 * 
	 * @param ctx
	 *            Spring application context if available - may be null.
	 */
	protected static void showBeans(ApplicationContext ctx) {
		if (ctx != null) {
			Logger logger = Logger.getGlobal();
			logger.info("Let's check our beans were found by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for (String beanName : beanNames) {
				if (beanName.indexOf("oke") != -1)
					logger.info(beanName);
			}
		}
		else {
			Logger.getGlobal().info("Application starting.");
		}
	}

}
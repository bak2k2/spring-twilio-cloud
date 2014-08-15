package io.pivotal.cf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Doesn't load any beans for itself (although it could if we needed to), but
 * initializes Spring Boot and tells Spring to look for @Component classes in
 * the current package (and any sub-packages - such as the @Controller classes
 * in <tt>org.demo.web</tt>).
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Config {

}

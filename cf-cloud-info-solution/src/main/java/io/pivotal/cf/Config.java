package io.pivotal.cf;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Doesn't load any beans for itself (although it could if we needed to), but
 * initializes Spring Boot and tells Spring to look for @Component classes in
 * the current package (and any sub-packages - such as the @Controller classes
 * in <tt>org.demo.web</tt>).
 */
@SpringBootApplication
public class Config {

}

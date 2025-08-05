package com.springsource.SpringOne;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springsource.SpringOne")
@PropertySource("classpath:datafile.properties")
public class AppConfig {
}

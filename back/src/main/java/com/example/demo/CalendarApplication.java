package com.example.demo;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SecurityConfig.class)
public class CalendarApplication {
	public static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = SpringApplication.run(CalendarApplication.class, args);
		
	}
	public static ConfigurableApplicationContext getCtx() {
		return ctx;
	}

}

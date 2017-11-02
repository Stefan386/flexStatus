package com.flex.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


//http://www.torsten-horn.de/techdocs/Spring-Boot.html#SpringBoot-MVC-REST

@SpringBootApplication
public class StatusApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(StatusApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String name:beanNames){
			System.out.println(name);
		}
	}
}

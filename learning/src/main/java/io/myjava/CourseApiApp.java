package io.myjava;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.myjava.springbootstarter.dependencyinjection.DependencyInjection;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(CourseApiApp.class,args);
		
		DependencyInjection dependency = context.getBean(DependencyInjection.class);
//		DependencyInjection dependency = new DependencyInjection();

		dependency.call();
		
	}

}

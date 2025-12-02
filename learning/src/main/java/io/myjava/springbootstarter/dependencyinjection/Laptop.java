package io.myjava.springbootstarter.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Laptop  implements Computer{

	@Override
	public void build() {
		System.out.println("Building Laptop....");
	}
	
	

}

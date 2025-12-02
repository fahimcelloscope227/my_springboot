package io.myjava.springbootstarter.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

	@Override
	public void build() {
		System.out.println("Building Desktop...");
	}

}

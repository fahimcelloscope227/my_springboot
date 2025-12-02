package io.myjava.springbootstarter.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjection {
	
	@Autowired
	@Qualifier("desktop")
	private Computer computerA;
	

	@Autowired
	@Qualifier("laptop")
	private Computer computerB;
	
	
	public void call() {
		computerA.build();
		computerB.build();
	}
	

}

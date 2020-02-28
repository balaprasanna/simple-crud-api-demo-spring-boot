package com.bala.crudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleCrudApiDemoApplication {

	public static void main(String[] args) {
		
			
		ConfigurableApplicationContext ctx = SpringApplication.run(SimpleCrudApiDemoApplication.class, args);
//		Alien a1 = ctx.getBean(Alien.class);
//		
//		System.out.println(a1.hashCode());
		
		AliensFriend af = ctx.getBean(AliensFriend.class);
		af.show();
		
	}

}

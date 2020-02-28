package com.bala.crudapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliensFriend {

	@Autowired
	private Alien alien;
	
	public void show() {
		System.out.println(alien.getName() + alien.hashCode());
	}
}

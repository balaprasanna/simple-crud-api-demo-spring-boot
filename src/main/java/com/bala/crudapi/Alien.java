package com.bala.crudapi;

import org.springframework.stereotype.Component;

@Component
public class Alien {

	private String name;
	
	public Alien() {
		super();
	}
	
	public Alien(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

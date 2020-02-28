package com.bala.crudapi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "mycourse")
public class Course {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	private String description;
	private Integer duration;
	
//	@OneToMany()
//	private List<Student> student;
//	
//	public List<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}

	public Course(Integer id, String name, String description, Integer duration) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
	}

	public Course() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	
}

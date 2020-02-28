package com.bala.crudapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(path = "/course", method = RequestMethod.GET)
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@RequestMapping(path = "/course/{id}", method = RequestMethod.GET)
	public Course getAllCourses(  @PathVariable Integer id){
		return courseService.getCourseById(id);
	}
	
	@RequestMapping(path = "/course", method = RequestMethod.POST , consumes = "application/json" )
	public Course createCourse(@RequestBody Course c) {
		return courseService.saveCourse(c);
	}
	
	@RequestMapping(path = "/course/{id}", 
			method = RequestMethod.PUT , 
			consumes = "application/json" )
	public Course updateCourse(@RequestBody Course c, @PathVariable Integer id) {
		return courseService.updateCourse(c, id);
	}
	
	@RequestMapping(path = "/course/{id}", method = RequestMethod.DELETE)
	public Course deleteCourse( @PathVariable Integer id) {
		return courseService.deleteCourse(id);
	}
}

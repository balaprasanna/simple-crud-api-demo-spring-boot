package com.bala.crudapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/v1")
public class CourseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	
	
	@CrossOrigin(origins = "http://localhost:5000")
	@RequestMapping(path = "/course", method = RequestMethod.GET)
	public List<Course> getAllCourses(){
		LOG.debug("DEBUG Route: /course");
		LOG.info("INFO Route: /course");
		LOG.error("ERROR Route: /course");
		return courseService.getAllCourses();
	}
	
	@RequestMapping(path = "/course/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCourseDetail(  @PathVariable Integer id){
		Course c = courseService.getCourseById(id);
		
		if (c == null) {
			return new ResponseEntity<ErrorResponse>( new ErrorResponse("Course id not found"), HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Course>(c, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(path = "/course", method = RequestMethod.POST , consumes = "application/json" )
	public Course createCourse(@RequestBody Course c) {
		return courseService.saveCourse(c);
	}
	
	@RequestMapping(path = "/course/{id}", 
			method = RequestMethod.PUT , 
			consumes = "application/json" )
	public ResponseEntity<?> updateCourse(@RequestBody Course c, @PathVariable Integer id) {
		Course c1 = courseService.updateCourse(c, id);
		if (c1 == null) {
			return new ResponseEntity<ErrorResponse>( new ErrorResponse("Course id not found"), HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Course>(c1, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path = "/course/{id}", method = RequestMethod.DELETE)
	public Course deleteCourse( @PathVariable Integer id) {
		return courseService.deleteCourse(id);
	}
}

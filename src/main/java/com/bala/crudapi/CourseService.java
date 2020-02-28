package com.bala.crudapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	// Get all Courses
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// Get a single Course by id
	public Course getCourseById(Integer id){
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		}else {
			return null;
		}
	}
	
	// Add new course
	public Course saveCourse(Course c){
		return courseRepository.save(c);
	}
		
	// Update an existing course, :id, new_object
	public Course updateCourse(Course c, Integer id) {
		
		Optional<Course> objToUpdate = courseRepository.findById(id);
		if (objToUpdate.isPresent()){
			// Update & persist the new object
			Course objFromDatabase = objToUpdate.get();
			objFromDatabase.setName(c.getName());
			objFromDatabase.setDescription(c.getDescription());
			objFromDatabase.setDuration(c.getDuration());
			//
			return courseRepository.saveAndFlush(objFromDatabase);
			
		} else {
			return null;	
		}
	
		
	}
	
	// Delete a course :id
	public Course deleteCourse(Integer id) {
		
		Optional<Course> objToDelete = courseRepository.findById(id);
		if (objToDelete.isPresent()) {
			Course obj = objToDelete.get();
			courseRepository.delete(obj);
			return obj;
		} else {
			return null;	
		}
		
		
	}
	
}

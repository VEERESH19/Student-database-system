package com.veer.studentdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veer.studentdb.Interface.CourseService;
import com.veer.studentdb.entity.Course;


@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value= "/Course/all", method= RequestMethod.GET)
	public List<Course> getCourses() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Courses CourseService is invoked.");
		return courseService.getCourses();
	}

	@RequestMapping(value= "/Course/{cId}", method= RequestMethod.GET)
	public Course getCourseById(@PathVariable int cId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Course details by id is invoked.");

		Optional<Course> cour =  courseService.getCourseById(cId);
		if(!cour.isPresent())
			throw new Exception("Could not find Course with id- " + cId);

		return cour.get();
	}

	@RequestMapping(value= "/Course/add", method= RequestMethod.POST)
	public Course createCourse(@RequestBody Course newcour) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Course method is invoked.");
		return courseService.addNewCourse(newcour);
	}

	@RequestMapping(value= "/Course/update/{id}", method= RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course updcour, @PathVariable int cId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Course details by id is invoked.");

		Optional<Course> cour =  courseService.getCourseById(cId);
		if (!cour.isPresent())
			throw new Exception("Could not find Course with id- " + cId);

			
		if(updcour.getCName() == null || updcour.getCName().isEmpty())
			updcour.setCName(cour.get().getCName());
		
		if(updcour.getCDuration() == 0)
			updcour.setCDuration(cour.get().getCDuration());

		updcour.setCId(cId);
		return courseService.updateCourse(updcour);
	}

	@RequestMapping(value= "/Course/delete/{id}", method= RequestMethod.DELETE)
	public void deleteCourseById(@PathVariable int cId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Course by id is invoked.");

		Optional<Course> cour =  courseService.getCourseById(cId);
		if(!cour.isPresent())
			throw new Exception("Could not find Course with id- " + cId);

		courseService.deleteCourseById(cId);
	}

	@RequestMapping(value= "/Course/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Courses is invoked.");
		courseService.deleteAllCourses();
	}

}

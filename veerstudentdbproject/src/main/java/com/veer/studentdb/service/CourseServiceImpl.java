package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.Interface.CourseService;
import com.veer.studentdb.entity.Course;
import com.veer.studentdb.repository.CourseRepository;
import com.veer.studentdb.request.CourseRequest;



@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course addCourse(CourseRequest courseRequest) {

		Course course = new Course();
		System.out.println(course.toString());
		course.setCName(courseRequest.getCName());
		course.setCDuration(courseRequest.getCDuration());
		

		return courseRepository.save(course);
	}

	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}
	@Override
	public Optional<Course> getCourseById(int courid) {
		return courseRepository.findById(courid);
	}
	@Override
	public Course addNewCourse(Course cour) {
		return courseRepository.save(cour);
	}
	@Override
	public Course updateCourse(Course cour) {
		return courseRepository.save(cour);
	}
	@Override
	public void deleteCourseById(int courid) {
		courseRepository.deleteById(courid);
	}
	@Override
	public void deleteAllCourses() {
		courseRepository.deleteAll();
	}

}

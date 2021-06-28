package com.veer.studentdb.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veer.studentdb.Interface.StudentService;
import com.veer.studentdb.entity.Student;


@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value= "/Student/all", method= RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public List<Student> getStudents() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Students studentService is invoked.");
		return studentService.getStudents();
	}

	@RequestMapping(value= "/Student/{sId}", method= RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public Student getStudentById(@PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Student details by id is invoked.");

		Optional<Student> stu =  studentService.getStudentById(sId);
		if(!stu.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

		return stu.get();
	}

	@RequestMapping(value= "/Student/add", method= RequestMethod.POST)
	@PreAuthorize("hasRole('Admin')")
	public Student createStudent(@RequestBody Student newstu) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Student method is invoked.");
		return studentService.addNewStudent(newstu);
	}

	@RequestMapping(value= "/Student/update/{sId}", method= RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student updstu, @PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Student details by id is invoked.");

		Optional<Student> stu =  studentService.getStudentById(sId);
		if (!stu.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

			
		if(updstu.getSName() == null || updstu.getSName().isEmpty())
			updstu.setSName(stu.get().getSName());
		if(updstu.getSDepartment() == null || updstu.getSDepartment().isEmpty())
			updstu.setSDepartment(stu.get().getSDepartment());
		if(updstu.getSAge() == 0)
			updstu.setSAge(stu.get().getSAge());

		updstu.setSId(sId);
		return studentService.updateStudent(updstu);
	}

	@RequestMapping(value= "/Student/delete/{sId}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteStudentById(@PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Student by id is invoked.");

		Optional<Student> stu =  studentService.getStudentById(sId);
		if(!stu.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

		studentService.deleteStudentById(sId);
	}

	@RequestMapping(value= "/Student/deleteall", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Students is invoked.");
		studentService.deleteAllStudents();
	}
}

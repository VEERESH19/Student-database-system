package com.veer.studentdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.veer.studentdb.Interface.TeacherService;
import com.veer.studentdb.entity.Teacher;

@RestController
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@RequestMapping(value = "/Teacher/all", method = RequestMethod.GET)
	public List<Teacher> getTeachers() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Teachers teacherService is invoked.");
		return teacherService.getTeachers();
	}

	@RequestMapping(value = "/Teacher/{tId}", method = RequestMethod.GET)
	public Teacher getTeacherById(@PathVariable int tId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Teacher details by id is invoked.");

		Optional<Teacher> teach = teacherService.getTeacherById(tId);
		if (!teach.isPresent())
			throw new Exception("Could not find Teacher with id- " + tId);

		return teach.get();
	}

	@RequestMapping(value = "/Teacher/add", method = RequestMethod.POST)
	public Teacher createTeacher(@RequestBody Teacher newteach) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Teacher method is invoked.");
		return teacherService.addNewTeacher(newteach);
	}

	@RequestMapping(value = "/Teacher/update/{tId}", method = RequestMethod.PUT)
	public Teacher updateTeacher(@RequestBody Teacher updteach, @PathVariable int tId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Teacher details by id is invoked.");

		Optional<Teacher> teach = teacherService.getTeacherById(tId);
		if (!teach.isPresent())
			throw new Exception("Could not find Teacher with id- " + tId);

		if (updteach.getTName() == null || updteach.getTName().isEmpty())
			updteach.setTName(teach.get().getTName());
		if (updteach.getTAge() == 0)
			updteach.setTAge(teach.get().getTAge());

		updteach.setTId(tId);
		return teacherService.updateTeacher(updteach);
	}

	@RequestMapping(value = "/Teacher/delete/{tId}", method = RequestMethod.DELETE)
	public void deleteTeacherById(@PathVariable int tId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Teacher by id is invoked.");

		Optional<Teacher> teach = teacherService.getTeacherById(tId);
		if (!teach.isPresent())
			throw new Exception("Could not find Teacher with id- " + tId);

		teacherService.deleteTeacherById(tId);
	}

	@RequestMapping(value = "/Teacher/deleteall", method = RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Teachers is invoked.");
		teacherService.deleteAllTeachers();
	}

}

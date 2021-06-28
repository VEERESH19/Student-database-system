package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veer.studentdb.Interface.TeacherService;
import com.veer.studentdb.entity.Teacher;
import com.veer.studentdb.repository.TeacherRepository;
import com.veer.studentdb.request.TeacherRequest;

@Service
public class Teacherserviceimpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	public Teacher addTeacher(TeacherRequest teacherRequest) {

		Teacher teacher = new Teacher();
		System.out.println(teacher.toString());
		teacher.setTName(teacherRequest.getTName());
		teacher.setTAge(teacherRequest.getTAge());

		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Optional<Teacher> getTeacherById(int stuid) {
		return teacherRepository.findById(stuid);
	}

	@Override
	public Teacher addNewTeacher(Teacher stu) {
		return teacherRepository.save(stu);
	}

	@Override
	public Teacher updateTeacher(Teacher stu) {
		return teacherRepository.save(stu);
	}

	@Override
	public void deleteTeacherById(int stuid) {
		teacherRepository.deleteById(stuid);
	}

	@Override
	public void deleteAllTeachers() {
		teacherRepository.deleteAll();
	}

}

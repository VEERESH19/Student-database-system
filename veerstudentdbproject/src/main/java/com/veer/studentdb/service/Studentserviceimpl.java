package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veer.studentdb.Interface.StudentService;
import com.veer.studentdb.entity.Student;
import com.veer.studentdb.repository.StudentRepository;
import com.veer.studentdb.request.StudentRequest;

@Service
public class Studentserviceimpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(StudentRequest StudentRequest) {

		Student student = new Student();
		System.out.println(student.toString());
		student.setSName(StudentRequest.getSName());
		student.setSDepartment(StudentRequest.getSDepartment());
		student.setSAge(StudentRequest.getSAge());

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	@Override
	public Optional<Student> getStudentById(int stuid) {
		return studentRepository.findById(stuid);
	}
	@Override
	public Student addNewStudent(Student stu) {
		return studentRepository.save(stu);
	}
	@Override
	public Student updateStudent(Student stu) {
		return studentRepository.save(stu);
	}
	@Override
	public void deleteStudentById(int stuid) {
		studentRepository.deleteById(stuid);
	}
	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}
}
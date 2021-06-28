package com.veer.studentdb.Interface;

import java.util.List;
import java.util.Optional;

import com.veer.studentdb.entity.Student;


public interface StudentService {

	public List<Student> getStudents();
	public Optional<Student> getStudentById(int stuid);
	public Student addNewStudent(Student stu);
	public Student updateStudent(Student stu);
	public void deleteStudentById(int stuid);
	public void deleteAllStudents();

}
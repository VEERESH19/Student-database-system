package com.veer.studentdb.Interface;

import java.util.List;
import java.util.Optional;

import com.veer.studentdb.entity.Teacher;

public interface TeacherService {

	public List<Teacher> getTeachers();

	public Optional<Teacher> getTeacherById(int teachid);

	public Teacher addNewTeacher(Teacher teach);

	public Teacher updateTeacher(Teacher teach);

	public void deleteTeacherById(int teachid);

	public void deleteAllTeachers();

}

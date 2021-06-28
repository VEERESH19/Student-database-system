package com.veer.studentdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veer.studentdb.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

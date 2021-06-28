package com.veer.studentdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veer.studentdb.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {

}

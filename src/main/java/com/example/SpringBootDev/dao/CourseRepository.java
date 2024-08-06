package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>, CustomCourseRepository {
}

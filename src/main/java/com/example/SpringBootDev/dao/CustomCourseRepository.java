package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;

public interface CustomCourseRepository {
    Course findCourseAndStudentsByCourseId(int id);
}

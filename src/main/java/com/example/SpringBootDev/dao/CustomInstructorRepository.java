package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;

import java.util.List;

public interface CustomInstructorRepository {
    List<Course> findCoursesByInstructorId(int id);
}

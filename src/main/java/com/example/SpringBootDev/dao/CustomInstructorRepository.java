package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import com.example.SpringBootDev.entity.Instructor;

import java.util.List;

public interface CustomInstructorRepository {
    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void deleteInstructorById(int id);
}

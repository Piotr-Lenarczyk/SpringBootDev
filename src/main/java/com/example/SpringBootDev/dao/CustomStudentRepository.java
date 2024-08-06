package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;

public interface CustomStudentRepository {
    Student findStudentAndCoursesByStudentId(int id);
}

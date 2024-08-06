package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;

public interface CustomStudentRepository {
    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
}

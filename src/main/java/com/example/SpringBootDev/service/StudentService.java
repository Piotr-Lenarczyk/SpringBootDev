package com.example.SpringBootDev.service;

import com.example.SpringBootDev.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    void delete(Integer id);

    int deleteAll();
}

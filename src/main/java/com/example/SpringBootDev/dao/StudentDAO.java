package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}

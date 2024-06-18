package com.example.SpringBootDev.service;

import com.example.SpringBootDev.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAll();

    Instructor findById(int id);

    Instructor save(Instructor instructor);

    void deleteById(int id);
}

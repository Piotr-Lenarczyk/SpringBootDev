package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

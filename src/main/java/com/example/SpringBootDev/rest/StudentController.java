package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final EntityManager entityManager;

    public StudentController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.entityManager.createQuery("FROM Student", Student.class).getResultList();
    }
}

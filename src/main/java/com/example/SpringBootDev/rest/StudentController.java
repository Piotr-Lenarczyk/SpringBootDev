package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.entity.Student;
import com.example.SpringBootDev.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService entityManager) {
        this.studentService = entityManager;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = this.studentService.findById(studentId);
        if (student == null) {
            throw new NotFoundException(String.format("Student ID %d not found", studentId));
        }
        return student;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        student.setId(0);
        return this.studentService.save(student);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        if (this.studentService.findById(studentId) == null) {
            throw new NotFoundException(String.format("Student ID %d not found", studentId));
        }
        student.setId(studentId);
        return this.studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void removeStudent(@PathVariable int studentId) {
        if (this.studentService.findById(studentId) == null) {
            throw new NotFoundException(String.format("Student ID %d not found", studentId));
        }
        this.studentService.delete(studentId);
    }

    @DeleteMapping("/students")
    public String removeAllStudents() {
        return String.format("%d row(s) affected", this.studentService.deleteAll());
    }
}

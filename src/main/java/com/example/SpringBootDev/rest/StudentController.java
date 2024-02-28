package com.example.SpringBootDev.rest;

import com.example.SpringBootDev.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = this.entityManager.find(Student.class, studentId);
        if (student == null) {
            throw new NotFoundException(String.format("Student ID %d not found", studentId));
        }
        return student;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // Handle NotFoundException
        if (exception instanceof NotFoundException) {
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        // Handle generic exceptions
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

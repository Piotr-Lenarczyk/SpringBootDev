package com.example.SpringBootDev.service;

import com.example.SpringBootDev.dao.StudentRepository;
import com.example.SpringBootDev.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> result = this.studentRepository.findById(id);
        Student student = null;
        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Could not find Student ID " + id);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public int deleteAll() {
        int size = this.studentRepository.findAll().size();
        this.studentRepository.deleteAll();
        return size;
    }
}

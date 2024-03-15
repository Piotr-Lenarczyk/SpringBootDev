package com.example.SpringBootDev.service;

import com.example.SpringBootDev.dao.StudentDAO;
import com.example.SpringBootDev.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return this.studentDAO.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return this.studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return this.studentDAO.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        this.studentDAO.delete(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return this.studentDAO.deleteAll();
    }
}

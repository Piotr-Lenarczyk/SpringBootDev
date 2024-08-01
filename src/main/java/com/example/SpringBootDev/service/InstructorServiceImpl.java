package com.example.SpringBootDev.service;

import com.example.SpringBootDev.dao.InstructorRepository;
import com.example.SpringBootDev.entity.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, ObjectMapper objectMapper) {
        this.instructorRepository = instructorRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Instructor> findAll() {
        return this.instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);
        if (instructor.isPresent()) {
            return instructor.get();
        } else {
            throw new RuntimeException("Instructor with ID " + id + " not found");
        }
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return this.instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.instructorRepository.deleteInstructorById(id);
    }
}

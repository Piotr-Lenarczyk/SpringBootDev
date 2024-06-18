package com.example.SpringBootDev.service;

import com.example.SpringBootDev.dao.InstructorRepository;
import com.example.SpringBootDev.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Autowired

    @Override
    public List<Instructor> findAll() {
        return this.instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);
        Instructor theInstructor = null;
        if (instructor.isPresent()) {
            return instructor.get();
        } else {
            throw new RuntimeException(String.format("Instructor with ID %d not found", id));
        }
    }

    @Override
    public Instructor save(Instructor instructor) {
        return this.instructorRepository.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        try {
            findById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Warning: entity was not deleted");
        }
        this.instructorRepository.deleteById(id);
    }
}

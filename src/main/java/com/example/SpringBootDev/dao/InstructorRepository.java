package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>, CustomInstructorRepository {
}

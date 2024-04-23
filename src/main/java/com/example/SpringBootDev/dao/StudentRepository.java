package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members") // Changes default endpoint path
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

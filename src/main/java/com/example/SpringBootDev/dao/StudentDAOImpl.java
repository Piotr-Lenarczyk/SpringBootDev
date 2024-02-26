package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // Define the entity manager
    private final EntityManager entityManager;

    // Use constructor injection on entityManager

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // Makes this operation a transaction
    public void save(Student student) {
        this.entityManager.persist(student);
    }
}

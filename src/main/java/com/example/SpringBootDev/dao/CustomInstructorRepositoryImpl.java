package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomInstructorRepositoryImpl implements CustomInstructorRepository {
    private final EntityManager entityManager;

    @Autowired
    public CustomInstructorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }
}

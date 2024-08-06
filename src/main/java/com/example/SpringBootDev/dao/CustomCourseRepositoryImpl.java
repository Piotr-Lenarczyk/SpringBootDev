package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomCourseRepositoryImpl implements CustomCourseRepository {
    private final EntityManager entityManager;

    @Autowired
    public CustomCourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("SELECT c from Course c JOIN FETCH c.students WHERE c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }
}

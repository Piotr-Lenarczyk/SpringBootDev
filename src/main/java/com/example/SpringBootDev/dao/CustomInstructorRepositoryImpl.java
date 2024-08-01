package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import com.example.SpringBootDev.entity.Instructor;
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

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = this.entityManager.createQuery("SELECT i FROM Instructor i " +
                "JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }
}

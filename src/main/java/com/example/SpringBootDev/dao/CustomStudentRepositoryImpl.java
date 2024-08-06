package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {
    private final EntityManager entityManager;

    @Autowired
    public CustomStudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = this.entityManager.createQuery("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :data", Student.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        this.entityManager.remove(this.entityManager.find(Student.class, id));
    }
}

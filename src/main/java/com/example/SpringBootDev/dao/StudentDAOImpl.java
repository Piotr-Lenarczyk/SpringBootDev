package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Student save(Student student) {
        return this.entityManager.merge(student);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Using JPQL, not SQL
        // JPQL - uses class attributes instead of column names
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public void delete(Integer id) {
        Student student = this.entityManager.find(Student.class, id);
        this.entityManager.remove(student);
    }

    @Override
    public int deleteAll() {
        return this.entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}

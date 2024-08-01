package com.example.SpringBootDev.dao;

import com.example.SpringBootDev.entity.Course;
import com.example.SpringBootDev.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = this.entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();

        // Break association
        for (Course course : courses) {
            course.setInstructor(null);
        }

        this.entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        this.entityManager.remove(this.entityManager.find(Course.class, id));
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.reviews " +
                "WHERE c.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }


}

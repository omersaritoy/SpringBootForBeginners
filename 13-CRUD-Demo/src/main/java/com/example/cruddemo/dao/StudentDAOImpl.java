package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private final EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager em) {
        this.entityManager = em;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }
}

package com.example.jpaadvanced.dao;


import com.example.jpaadvanced.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

public class AppDAOImpl implements  AppDAO{

    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }
}

package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        //create Query
        TypedQuery<Student> theQurey=entityManager.createQuery("From Student order by lastName asc",Student.class);

        return theQurey.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE  lastName=:theData",Student.class);
        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}

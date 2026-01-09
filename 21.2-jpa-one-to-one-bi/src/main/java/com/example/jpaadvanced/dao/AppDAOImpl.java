package com.example.jpaadvanced.dao;


import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //find instructor
        Instructor temp = entityManager.find(Instructor.class, theId);
        entityManager.remove(temp);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        //Retrieve instructor detail
        InstructorDetail temp = entityManager.find(InstructorDetail.class, theId);

        //remove the associated object reference
        //break bi-directional link
        temp.getInstructor().setInstructorDetail(null);


        //delete the instructor detail
        entityManager.remove(temp);
    }
}

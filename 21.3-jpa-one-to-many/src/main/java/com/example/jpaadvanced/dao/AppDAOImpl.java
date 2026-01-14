package com.example.jpaadvanced.dao;


import com.example.jpaadvanced.entity.Course;
import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        //get courses
        List<Course> courses = temp.getCourses();

        //break association of all course for the instructor
        courses.forEach(x -> temp.setCourses(null));

        //delete instructor
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class
        );
        query.setParameter("data", theId);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id=:data", Instructor.class);
        query.setParameter("data", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        // retrieve course
        Course course = entityManager.find(Course.class, theId);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course thCourse) {
        entityManager.persist(thCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query= entityManager.createQuery(
                "select c from Course c join fetch c.reviews where c.id=:data", Course.class);

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

}

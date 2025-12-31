package com.example.security.dao;


import com.example.security.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);


        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {

        return entityManager.find(Employee.class,theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee=findById(theId);

        entityManager.remove(theEmployee);
        System.out.println("Employee deleted by id :"+theId);
    }
}

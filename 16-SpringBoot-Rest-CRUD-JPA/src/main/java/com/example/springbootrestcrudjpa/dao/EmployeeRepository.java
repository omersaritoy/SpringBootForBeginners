package com.example.springbootrestcrudjpa.dao;

import com.example.springbootrestcrudjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}

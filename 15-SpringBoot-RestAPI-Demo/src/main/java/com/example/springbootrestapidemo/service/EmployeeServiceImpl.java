package com.example.springbootrestapidemo.service;

import com.example.springbootrestapidemo.dao.EmployeeDAO;
import com.example.springbootrestapidemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = employeeDAO.findById(theId);
        if (employee == null)
            throw new RuntimeException("Employee id not found-" + theId);

        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        theEmployee.setId(0);

        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        Employee employee = employeeDAO.findById(theId);
        if (employee == null)
            throw new RuntimeException("Employee id not found-" + theId);
        employeeDAO.deleteById(theId);
    }

}

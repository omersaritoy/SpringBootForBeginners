package com.example.springbootrestapidemo.rest;

import com.example.springbootrestapidemo.dao.EmployeeDAO;
import com.example.springbootrestapidemo.entity.Employee;
import com.example.springbootrestapidemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{theId}")
    public Employee findById(@PathVariable int theId){
        return employeeService.findById(theId);
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PutMapping
    public Employee  updateEmployee(@RequestBody Employee employee){
        Employee dbEmp= employeeService.save(employee);
        return  employee;
    }
}

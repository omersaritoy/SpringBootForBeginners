package com.example.openapiswagger.rest;


import com.example.openapiswagger.entity.Employee;
import com.example.openapiswagger.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JsonMapper jsonMapper;
    public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
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
    @PatchMapping("/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayload){
        Employee tempEmployee=employeeService.findById(employeeId);
        if(tempEmployee==null) throw new RuntimeException("Employee id not found-"+employeeId);
        if(patchPayload.containsKey("id"))
            throw  new RuntimeException("Employee id not allowed in request body -"+employeeId);
        Employee patchEmployee=jsonMapper.updateValue(tempEmployee,patchPayload);
        return employeeService.save(patchEmployee);
    }
}

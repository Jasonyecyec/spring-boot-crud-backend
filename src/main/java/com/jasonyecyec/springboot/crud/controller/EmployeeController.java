package com.jasonyecyec.springboot.crud.controller;

import com.jasonyecyec.springboot.crud.entity.Employee;
import com.jasonyecyec.springboot.crud.repository.EmployeeDAO;
import com.jasonyecyec.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://spring-boot-crud.netlify.app/")
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
       Employee employee =  this.employeeService.findById(employeeId);

       if(employee == null){
           throw  new RuntimeException("employee id not found - " + employeeId);
       }

       return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

        this.employeeService.saveEmployee(employee);
        return  employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        this.employeeService.saveEmployee(employee);

        return employee;
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
      Employee employee = this.employeeService.findById(employeeId);

      if(employee == null) {
        throw new RuntimeException("Employee id not found - " + employeeId);
      }
      this.employeeService.deleteEmployee(employeeId);

    }
}

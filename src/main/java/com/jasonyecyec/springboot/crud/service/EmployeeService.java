package com.jasonyecyec.springboot.crud.service;

import com.jasonyecyec.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);
    public void  deleteEmployee(int id);
}

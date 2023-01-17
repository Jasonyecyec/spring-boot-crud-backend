package com.jasonyecyec.springboot.crud.repository;

import com.jasonyecyec.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);
    public void  deleteEmployee(int id);
}

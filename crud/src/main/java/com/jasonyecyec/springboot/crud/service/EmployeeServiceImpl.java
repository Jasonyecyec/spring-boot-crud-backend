package com.jasonyecyec.springboot.crud.service;

import com.jasonyecyec.springboot.crud.entity.Employee;
import com.jasonyecyec.springboot.crud.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAll() {
      return   this.employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        this.employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeDAO.deleteEmployee(id);
    }
}

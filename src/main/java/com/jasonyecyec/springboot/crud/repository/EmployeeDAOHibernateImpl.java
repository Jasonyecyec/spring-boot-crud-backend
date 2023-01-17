package com.jasonyecyec.springboot.crud.repository;

import com.jasonyecyec.springboot.crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get current hibernate session
        Session session = this.entityManager.unwrap(Session.class);

        //create query
        Query<Employee> query = session.createQuery("from Employee ",Employee.class);

        //execute query and get result list
        List<Employee> employees = query.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get current hibernate session
        Session session = this.entityManager.unwrap(Session.class);

        //create query
        Employee employee = session.get(Employee.class,id);

        //return the results
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        // get current hibernate session
        Session session = this.entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        // get current hibernate session
        Session session = this.entityManager.unwrap(Session.class);

        //create query
        Employee employee = session.get(Employee.class,id);

        Query query = session.createQuery("delete from Employee  where id = :employeeId");

        query.setParameter("employeeId",id);

        query.executeUpdate();

    }
}

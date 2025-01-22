package com.entrainement.dao;

import com.entrainement.model.Employee;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class EmployeeDao extends Dao {

    public Employee findEmployeeById(long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
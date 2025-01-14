package com.entrainement.dao;

import com.entrainement.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeeDao {

    @PersistenceContext(unitName = "Gpt-entraînement")
    private EntityManager entityManager;

    public Employee findEmployeeById(long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    public void deleteEmployee(Employee employee) {
        if (!entityManager.contains(employee)) {
            employee = entityManager.merge(employee);
        }
        entityManager.remove(employee);
    }
}
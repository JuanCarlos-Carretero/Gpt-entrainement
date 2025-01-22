package com.entrainement.dao;

import com.entrainement.model.Department;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class DepartmentDao extends Dao {

    public Department findDepartmentById(long id) {
        return entityManager.find(Department.class, id);
    }

    public List<Department> findAllDepartments() {
        return entityManager.createNamedQuery("Department.findAll", Department.class).getResultList();
    }
}
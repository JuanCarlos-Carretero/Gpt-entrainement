package com.entrainement.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.entrainement.dao.DepartmentDao;
import com.entrainement.model.Department;

@RequestScoped
public class DepartmentService {
	
	@Inject
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.findAllDepartments();
    }
    
    public Department getDepartmentById(int id) {
        return departmentDao.findDepartmentById(id);
    }

    @Transactional
    public void insertDepartment(Department department) {
        departmentDao.insertObject(department);
    }

    @Transactional
    public void updateDepartment(int id, Department department) {
        Department existingDepartment = departmentDao.findDepartmentById(id);
        if (existingDepartment != null) {
            departmentDao.updateObject(department);
        }
    }

    @Transactional
    public void deleteDepartment(int id) {
        departmentDao.deleteObject(getDepartmentById(id));
    }
}

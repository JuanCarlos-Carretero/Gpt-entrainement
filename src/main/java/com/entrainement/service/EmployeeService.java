package com.entrainement.service;

import com.entrainement.dao.EmployeeDao;
import com.entrainement.model.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

@RequestScoped
public class EmployeeService {

    @Inject
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }
    
    public Employee getEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public void insertEmployee(Employee employee) {
        employeeDao.insertObject(employee);
    }

    @Transactional
    public void updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeDao.findEmployeeById(id);
        if (existingEmployee != null) {
            buildEmployee(existingEmployee, employee);
            employeeDao.updateObject(existingEmployee);
        }
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteObject(getEmployeeById(id));
    }
    
    public Employee buildEmployee(Employee empl1, Employee empl2){
    	empl1.setEmployeeId(empl2.getEmployeeId());
    	empl1.setComissionPct(empl2.getComissionPct());
    	empl1.setCommissionPct(empl2.getCommissionPct());
    	empl1.setDepartementId(empl2.getDepartementId());
    	empl1.setEmail(empl2.getEmail());
    	empl1.setFirstName(empl2.getFirstName());
    	empl1.setHireDate(empl2.getHireDate());
    	empl1.setLastName(empl2.getLastName());
    	empl1.setPhoneNumber(empl2.getPhoneNumber());
    	empl1.setSalary(empl2.getSalary());
    	empl1.setDepartments(empl2.getDepartments());
    	empl1.setDepartment(empl2.getDepartment());
    	empl1.setEmployee(empl2.getEmployee());
    	empl1.setEmployees(empl2.getEmployees());
    	empl1.setJob(empl2.getJob());
        return empl2;
    }
}
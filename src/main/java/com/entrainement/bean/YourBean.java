package com.entrainement.bean;

import javax.inject.Inject;
import javax.inject.Named;

import com.entrainement.model.Employee;
import com.entrainement.service.EmployeeService;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

@Named
@RequestScoped
public class YourBean {
	
	@Inject
	private EmployeeService empService;
    
    public void action(ActionEvent event) {
        System.out.println("Le boutton a ete cliquée!");
    }
    
    public List<Employee> searchAllEmployee() {
    	return empService.getAllEmployees();
    }
    
}
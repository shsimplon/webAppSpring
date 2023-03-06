package com.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.EmployeesModel;
import com.api.repository.EmployeeRepository;


import lombok.Data;

@Data
@Service
public class EmloyeeService {
	
	@Autowired
	private EmployeeRepository employeeProxy;
	
	public EmployeesModel getEmployee(final int id) {
		return employeeProxy.getEmployee(id);
	}
	
	public Iterable<EmployeesModel> getEmployees() {
		return employeeProxy.getEmployees();
	}
	
	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}
	
	public EmployeesModel saveEmployee(EmployeesModel employee) {
		EmployeesModel savedEmployee;
		
		employee.setLastName(employee.getLastName().toUpperCase());

		if(employee.getId() == null) {
			savedEmployee = employeeProxy.createEmployee(employee);
		} else {
			savedEmployee = employeeProxy.updateEmployee(employee);
		}
		
		return savedEmployee;
	}

}
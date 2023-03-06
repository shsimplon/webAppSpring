package com.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.model.EmployeesModel;
import com.api.webapp.CustomPropreties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeRepository {

	@Autowired
	private CustomPropreties props;

	
	public Iterable<EmployeesModel> getEmployees() {

		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl = baseApiUrl + "/employees";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<EmployeesModel>> response = restTemplate.exchange(
				getEmployeesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<EmployeesModel>>() {}
			);
		
		
		return response.getBody();
	}
	
	
	public EmployeesModel getEmployee(int id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeeUrl = baseApiUrl + "/employee/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EmployeesModel> response = restTemplate.exchange(
				getEmployeeUrl, 
				HttpMethod.GET, 
				null,
				EmployeesModel.class
			);
		
		
		return response.getBody();
	}
	
	
	public EmployeesModel createEmployee(EmployeesModel e) {
		String baseApiUrl = props.getApiUrl();
		String createEmployeeUrl = baseApiUrl + "/employee";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<EmployeesModel> request = new HttpEntity<EmployeesModel>(e);
		ResponseEntity<EmployeesModel> response = restTemplate.exchange(
				createEmployeeUrl, 
				HttpMethod.POST, 
				request, 
				EmployeesModel.class);
		
		
		return response.getBody();
	}
	
	
	public EmployeesModel updateEmployee(EmployeesModel e) {
		String baseApiUrl = props.getApiUrl();
		String updateEmployeeUrl = baseApiUrl + "/employee/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<EmployeesModel> request = new HttpEntity<EmployeesModel>(e);
		ResponseEntity<EmployeesModel> response = restTemplate.exchange(
				updateEmployeeUrl, 
				HttpMethod.PUT, 
				request, 
				EmployeesModel.class);
		
		
		return response.getBody();
	}
	
	
	public void deleteEmployee(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteEmployeeUrl = baseApiUrl + "/employee/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteEmployeeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
	}

}
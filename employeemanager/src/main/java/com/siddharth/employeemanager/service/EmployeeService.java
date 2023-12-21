package com.siddharth.employeemanager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddharth.employeemanager.model.Employee;
import com.siddharth.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private EmployeeRepo empRepo;

	@Autowired
	public EmployeeService(EmployeeRepo empRepo) {
		
		this.empRepo = empRepo;
	}
	
	public Employee saveEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return empRepo.save(employee);
	}
	
}

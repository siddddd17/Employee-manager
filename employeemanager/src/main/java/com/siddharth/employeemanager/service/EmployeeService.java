package com.siddharth.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddharth.employeemanager.exception.UserNotFoundException;
import com.siddharth.employeemanager.model.Employee;
import com.siddharth.employeemanager.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	private EmployeeRepo empRepo;

	public EmployeeService(EmployeeRepo empRepo) {
		
		this.empRepo = empRepo;
	}
	
	public Employee saveEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return empRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	@Transactional
	public void deleteEmployee(Long id) {
		empRepo.deleteEmployeeById(id);
	}
	
	public Employee findEmployeeById(Long id) {
		return empRepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("The Employee with id: "+ id + " was not found"));
	}
}

package com.siddharth.employeemanager.service;

import java.util.List;

import com.siddharth.employeemanager.model.Employee;

public interface EmployeeServiceInterface {
	public Employee saveEmployee(Employee employee);
	public List<Employee> findAllEmployees();
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Long id);
	public Employee findEmployeeById(Long id);
}

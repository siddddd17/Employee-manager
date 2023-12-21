package com.siddharth.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siddharth.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}

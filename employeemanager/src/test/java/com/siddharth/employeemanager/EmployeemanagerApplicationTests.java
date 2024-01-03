package com.siddharth.employeemanager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.siddharth.employeemanager.model.Employee;
import com.siddharth.employeemanager.repo.EmployeeRepo;
import com.siddharth.employeemanager.service.EmployeeService;
import com.siddharth.employeemanager.service.EmployeeServiceInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeemanagerApplicationTests {

	@Autowired
	public EmployeeService service;
	
	@MockBean
	public EmployeeRepo repository;
	
	
	@Test
	public void saveEmployeeTest() {
		Employee employee=new Employee(1L,"Siddharth", "siddharth@123", "CTO", "19381723", "www.ronaldo.com", "121321");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.saveEmployee(employee));
	}
	
	@Test
	public void findAllEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(1L,"Siddharth", "siddharth@123", "CTO", "19381723", "www.ronaldo.com", "121321"), 
						new Employee(2L, "Aishu", "aish@123", "CTO", "129381723", "www.messi.com", "1312313")
						).collect(Collectors.toList()));
		assertEquals(2, service.findAllEmployees().size());
	}
	@Test
	public void updateEmployeeTest() {
		 Employee employee= new Employee(1L,"Siddharth", "siddharth@123123", "CTO", "19381723", "www.ronaldo.com", "121321");
		 when(repository.save(employee)).thenReturn(employee);
		 assertEquals(employee, service.updateEmployee(employee));
	}
	@Test
	public void deleteEmployeeTest() {
		long id= 2L;
		service.deleteEmployee(id);
		verify(repository, times(1)).deleteEmployeeById(id);
	}
	@Test
	public void findEmployeeById() {
		Long id= 1L;
		when(repository.findEmployeeById(id)).thenReturn(Optional
				.of(new Employee(1L,"Siddharth", "siddharth@123123", "CTO", "19381723", "www.ronaldo.com", "121321")));
		Employee foundEmployee= service.findEmployeeById(1L);
		assertEquals("Siddharth", foundEmployee.getName());
	}
	

}
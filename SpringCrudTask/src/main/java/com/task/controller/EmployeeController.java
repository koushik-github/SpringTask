package com.task.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.exception.EmployeeNotFoundException;
import com.task.model.Employee;
import com.task.repo.EmployeeRepo;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private final EmployeeRepo repository;

	public EmployeeController(EmployeeRepo repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<Employee> getEmployees() {
		return repository.findAll();
	}	
	
	@GetMapping("{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PutMapping("{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee empObj = repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
		empObj.setFirstName(employee.getFirstName());
		empObj.setLastName(employee.getLastName());
		empObj.setAge(employee.getAge());
		empObj.setEmailId(employee.getEmailId());
		empObj.setGender(employee.getGender());
		empObj.setAddress(employee.getAddress());
		return repository.save(empObj);
	}	
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
		repository.deleteById(id);
	}
}

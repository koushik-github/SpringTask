package com.task.repo;
import org.springframework.data.repository.CrudRepository;

import com.task.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
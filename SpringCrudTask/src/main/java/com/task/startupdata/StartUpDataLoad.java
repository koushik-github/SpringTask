package com.task.startupdata;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.task.model.Employee;
import com.task.repo.EmployeeRepo;



@Component
public class StartUpDataLoad implements ApplicationListener<ContextRefreshedEvent> {

	private final EmployeeRepo repository;
	
	
	public StartUpDataLoad(EmployeeRepo repository) {
		this.repository = repository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Employee empObj = new Employee();
		empObj.setFirstName("Jane");
		empObj.setLastName("Doe");
		empObj.setAge(18);
		empObj.setEmailId("ksd.koush@gmail.com");
		empObj.setGender("male");
		empObj.setAddress("Sample address");
		repository.save(empObj);
	}
}
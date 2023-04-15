package com.cvds.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			
			employeeService.getAllEmployees().forEach(employee -> employeeService.deleteEmployee(employee.getEmployeeId()));

			System.out.println("Adding employee....\n");
			employeeService.addEmployee(new Employee("Jessica", "Munoz", "Estudiante", 0.0, "0001-10-08"));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Estudiante", 10.0, "1990-06-26"));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
		};
	}

}

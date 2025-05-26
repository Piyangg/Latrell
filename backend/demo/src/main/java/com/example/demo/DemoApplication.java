package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository; // Ensure this import exists
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(EmployeeRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(new Employee("John Doe", "Manager"));
				repo.save(new Employee("Jane Smith", "Tester"));
			}
		};
	}
}


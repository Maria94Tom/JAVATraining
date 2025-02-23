package com.employee;

import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.repo.User;
import com.employee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EntityScan(basePackages = "com.employee.entities")
//@EnableJpaRepositories(basePackages = "com.employee.repo")
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepo dao;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		dao.save(new Employee("Rahul", "IT", new BigDecimal(10000)));
//		dao.save(new Employee("Ravi", "IT", new BigDecimal(20000)));
//		System.out.println("Product is added");

//
//		userService.
//				addUserEntity(new User("Maria",
//						passwordEncoder.encode("1234"),
//						List.of("ROLE_MANAGER","ROLE_TEAMLEAD")));
//		userService.
//				addUserEntity(new User("Isabel",
//						passwordEncoder.encode("1234"),
//						List.of("ROLE_MANAGER")));
//		userService.
//				addUserEntity(new User("Tibin",
//						passwordEncoder.encode("1234"),
//						List.of("ROLE_TEAMLEAD")));
//		userService.addUserEntity(new User("Tom",
//				passwordEncoder.encode("1234"),
//				List.of("ROLE_MANAGER","ROLE_TEAMLEAD")));
//		System.out.println("USERS ADDED");


	}
}

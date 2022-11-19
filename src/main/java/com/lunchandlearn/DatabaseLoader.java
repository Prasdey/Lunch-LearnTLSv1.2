package com.lunchandlearn;

import java.util.List;

import com.lunchandlearn.admin.User;
import com.lunchandlearn.admin.UserRepository;
import com.lunchandlearn.customer.Customer;
import com.lunchandlearn.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

	private UserRepository userRepo;
	private CustomerRepository customerRepo;

	public DatabaseLoader(UserRepository userRepo, CustomerRepository customerRepo) {
		this.userRepo = userRepo;
		this.customerRepo = customerRepo;
	}

	@Bean
	public CommandLineRunner initializeDatabase() {
		return args -> {
			User user1 = new User("david@gmail.com", "david123");
			User user2 = new User("john@yahoo.com", "john2020");
			
			userRepo.saveAll(List.of(user1, user2));
			
			Customer customer1 = new Customer("alex@gmail.com", "alex123", "Alex Stevenson");
			Customer customer2 = new Customer("peter@mail.ru", "peter246", "Peter Senkovski");
			
			customerRepo.saveAll(List.of(customer1, customer2));
			
			System.out.println("Database initialized");
		};
	}
}

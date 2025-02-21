package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.awt.print.Book;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {


	@Autowired
	private MongoTemplate mongoTemplate;


	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String name, Integer qty, String vendor, Double cost

		insert();
	}

	private void insert() {
		mongoTemplate.save(new Product("ThinkpadLaptop", 30, "AAB electronic", 5000000.0));
		mongoTemplate.save(new Product("LenovoMouse", 300, "MAA electronic", 500.0));
		mongoTemplate.save(new Product("KeyboardDell", 20, "ZAA electronic", 600.0));
		System.out.println("------------------------");
	}
}

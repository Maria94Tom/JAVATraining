package com.productstore.productstore;

import com.productstore.productstore.entities.Product;
import com.productstore.productstore.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication

public class ProductstoreApplication implements CommandLineRunner {
@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insert 100 records in to database using java 8 streams
//List<Product> products = IntStream.rangeClosed(1,100)
//		.mapToObj(i->new Product("Product"+i, BigDecimal.valueOf(new Random().nextDouble(4000)), LocalDate.now())).toList();
//
//		productRepo.saveAll(products);
//
	}
}

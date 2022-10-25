package com.qualidade.ecommerce;

import com.qualidade.ecommerce.model.Product;
import com.qualidade.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L, "TV", 300.00, "Samsung 50 Polegadas"));
			productService.save(new Product(2L, "Celular", 200.00, "iPhone 14 PRO 256GB"));
			productService.save(new Product(3L, "Notebook", 100.00, "Acer i5"));
		};
	}
}

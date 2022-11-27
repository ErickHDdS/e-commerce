package com.qualidade.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qualidade.ecommerce.model.Product;
import com.qualidade.ecommerce.service.ProductService;

import com.qualidade.ecommerce.model.Order;
import com.qualidade.ecommerce.service.OrderService;

import com.qualidade.ecommerce.model.OrderProduct;
import com.qualidade.ecommerce.service.OrderProductService;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService, OrderService orderService,
            OrderProductService orderProductService) {
        return args -> {
            productService.save(new Product(1L, "TV", 300.00, "Samsung 50 Polegadas"));
            productService.save(new Product(2L, "Celular", 200.00, "iPhone 14 PRO 256GB"));
            productService.save(new Product(3L, "Notebook", 100.00, "Acer i5"));

            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()), productService.getProduct(1L), 1));
            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()), productService.getProduct(2L), 2));
            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()), productService.getProduct(3L), 3));
        };
    }
}

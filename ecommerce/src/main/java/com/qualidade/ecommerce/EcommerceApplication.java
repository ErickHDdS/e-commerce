package com.qualidade.ecommerce;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qualidade.ecommerce.model.Order;
import com.qualidade.ecommerce.model.OrderProduct;
import com.qualidade.ecommerce.model.Product;
import com.qualidade.ecommerce.model.User;
import com.qualidade.ecommerce.service.OrderProductService;
import com.qualidade.ecommerce.service.OrderService;
import com.qualidade.ecommerce.service.ProductService;
// import com.qualidade.ecommerce.service.UserOrderService;
import com.qualidade.ecommerce.service.UserService;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService, OrderService orderService,
            OrderProductService orderProductService, UserService userService) {
        return args -> {
            ArrayList<User> users = new ArrayList<>();
            users.add(new User("Erick", 123, "admin", "erk", 31720560, 10, "casa"));
            users.add(new User("Gabriel", 125, "admin", "gbr", 30532000, 30, "ap 302"));
            users.add(new User("Julia", 124, "admin", "jla", 31320350, 20, "fundos"));

            users.forEach(user -> {
                userService.save(user);

            });

            productService.save(new Product("TV", 300.00, "Samsung 50 Polegadas"));
            productService.save(new Product("Celular", 200.00, "iPhone 14 PRO 256GB"));
            productService.save(new Product("Notebook", 100.00, "Acer i5"));

            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()),
                            productService.getProduct(1L), 1));
            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()),
                            productService.getProduct(2L), 2));
            orderProductService
                    .create(new OrderProduct(orderService.create(new Order()),
                            productService.getProduct(3L), 3));

        };
    }
}

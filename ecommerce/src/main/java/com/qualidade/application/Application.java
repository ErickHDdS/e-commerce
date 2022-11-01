package com.qualidade.application;

import com.qualidade.application.entities.User;
import com.qualidade.application.repositories.UserRepository;

import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            ArrayList<User> users = new ArrayList<>();
            users.add(new User("Erick", 123, "admin", "erk", 31720560, 10, "casa"));
            users.add(new User("Gabriel", 125, "admin", "gbr", 30532000, 30, "ap 302"));
            users.add(new User("Julia", 124, "admin", "jla", 31320350, 20, "fundos"));

            users.forEach(user -> {
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
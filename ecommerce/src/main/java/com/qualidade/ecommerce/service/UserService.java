package com.qualidade.ecommerce.service;

import com.qualidade.ecommerce.model.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface UserService {

    @NotNull
    Iterable<User> getAllUsers();

    User getUser(@Min(value = 1L, message = "Invalid User ID.") long id);

    User save(User user);
}

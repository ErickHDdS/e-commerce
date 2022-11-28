package com.qualidade.ecommerce.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.qualidade.ecommerce.model.Order;

@Validated
public interface OrderService {

    @NotNull
    Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    Order getOrder(@Min(value = 1L, message = "Invalid order ID.") long id);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}

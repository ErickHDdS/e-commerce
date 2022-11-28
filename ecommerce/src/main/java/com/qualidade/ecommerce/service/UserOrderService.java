package com.qualidade.ecommerce.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.qualidade.ecommerce.model.UserOrder;

@Validated
public interface UserOrderService {

    UserOrder create(@NotNull(message = "The orders for order cannot be null.") @Valid UserOrder userOrder);
}

package com.qualidade.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.qualidade.ecommerce.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

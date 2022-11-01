package com.qualidade.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.qualidade.ecommerce.model.OrderProduct;
import com.qualidade.ecommerce.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}

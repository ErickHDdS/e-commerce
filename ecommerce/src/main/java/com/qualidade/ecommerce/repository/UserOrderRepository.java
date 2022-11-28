package com.qualidade.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.qualidade.ecommerce.model.UserOrder;
import com.qualidade.ecommerce.model.UserOrderPK;

public interface UserOrderRepository extends CrudRepository<UserOrder, UserOrderPK> {
}

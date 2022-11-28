package com.qualidade.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qualidade.ecommerce.model.UserOrder;
import com.qualidade.ecommerce.repository.UserOrderRepository;

@Service
@Transactional
public class UserOrderServiceImpl implements UserOrderService {

    private UserOrderRepository userOrderRepository;

    public UserOrderServiceImpl(UserOrderRepository userOrderRepository) {
        this.userOrderRepository = userOrderRepository;
    }

    @Override
    public UserOrder create(UserOrder orderProduct) {
        return this.userOrderRepository.save(orderProduct);
    }
}

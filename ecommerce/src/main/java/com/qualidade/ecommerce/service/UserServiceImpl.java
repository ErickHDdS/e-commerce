package com.qualidade.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qualidade.ecommerce.exception.ResourceNotFoundException;
import com.qualidade.ecommerce.model.User;
import com.qualidade.ecommerce.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return UserRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return UserRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User save(User User) {
        return UserRepository.save(User);
    }
}

package com.qualidade.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qualidade.ecommerce.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

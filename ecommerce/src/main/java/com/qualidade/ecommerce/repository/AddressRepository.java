package com.qualidade.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qualidade.ecommerce.utils.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}

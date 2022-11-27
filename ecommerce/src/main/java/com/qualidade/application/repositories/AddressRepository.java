package com.qualidade.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qualidade.application.utils.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}

package com.service2.repository;


import com.service2.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address,Long> {
}

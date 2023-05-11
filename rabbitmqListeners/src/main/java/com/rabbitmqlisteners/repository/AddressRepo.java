package com.rabbitmqlisteners.repository;

import com.rabbitmqlisteners.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address,Long> {
}

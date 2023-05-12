package com.transactionmanagement.repository;

import com.transactionmanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}


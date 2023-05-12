package com.transactionmanagement.service;

import com.transactionmanagement.model.Address;
import com.transactionmanagement.model.Employee;
import com.transactionmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

    @Transactional
    public Employee addEmployee(Employee employee) throws Exception {
        Employee employeeSavedToDB = this.employeeRepository.save(employee);

        // we will initialize the
        // address object as null
        Address address = null;
        address.setId(123L);
        address.setAddress("Varanasi");
        address.setEmployee(employee);

        // calling addAddress() method
        // of AddressService class
        this.addressService.addAddress(address);
        return employeeSavedToDB;
    }
}


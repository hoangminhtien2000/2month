package com.uuhnaut69.customer.api;

import com.uuhnaut69.customer.domain.CustomerRequest;
import com.uuhnaut69.customer.domain.entity.Customer;
import com.uuhnaut69.customer.domain.port.CustomerUseCasePort;
import com.uuhnaut69.customer.infrastructure.repository.CustomerEntity;
import com.uuhnaut69.customer.infrastructure.repository.CustomerJpaRepository;
import jakarta.validation.Valid;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerUseCasePort customerUseCase;

  private final CustomerJpaRepository customerJpaRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Customer create(@RequestBody @Valid CustomerRequest customerRequest) {
    return customerUseCase.create(customerRequest);
  }

  @GetMapping("/{customerId}")
  public Customer findById(@PathVariable Long customerId) {
    return customerUseCase.findById(customerId);
  }

  @GetMapping("/all")
  public List<CustomerEntity> findAll(){
    return customerJpaRepository.findAll();
  }
}

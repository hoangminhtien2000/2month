package com.apiread.controller;

import com.apiread.model.Account;
import com.apiread.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;


    @GetMapping("/show")
    public List<Account> getAll() {
        return (List<Account>) accountRepo.findAll();
    }


    @GetMapping("/{id}")
    public Account findAccountById(@PathVariable long id) {
        return accountRepo.findById(id).get();
    }

}

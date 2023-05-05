package com.apiread.controller;

import com.apiread.model.Account;
import com.apiread.service.registerLogin.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    Register register;

    @PostMapping("/save")
    public String save(@RequestBody Account account) {
        return register.save(account);
    }

}

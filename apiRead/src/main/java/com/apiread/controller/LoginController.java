package com.apiread.controller;

import com.apiread.model.Account;
import com.apiread.model.dto.AccountToken;
import com.apiread.service.registerLogin.AccountServiceImpl;
import com.apiread.service.registerLogin.JwtService;
import com.apiread.service.registerLogin.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private Login login;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public AccountToken login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        Account account1 = login.findAccountByUsername(account.getUsername());

        return new AccountToken(account1.getId() ,account.getUsername(), account1.getRoles(), token);
    }



}

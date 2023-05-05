package com.apiread.service.registerLogin;

import com.apiread.model.Account;
import com.apiread.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements  Login,Register,UserDetailsService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }

    @Override
    public String save(Account account) {
        if (checkUsername(account.getUsername())){
            accountRepo.save(account);
            return "Success";
        }else return "Error";
    }

    @Override
    public Boolean checkUsername(String username) {
        Account account = accountRepo.findAccountByUsername(username);
        if (account == null) {
            return true;
        } else {
            return false;
        }
    }


}

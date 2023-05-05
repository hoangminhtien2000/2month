package com.apiread.service.registerLogin;

import com.apiread.model.Account;

public interface Login {
    Account findAccountByUsername(String username);
}

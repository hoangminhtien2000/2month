package com.apiread.service.registerLogin;

import com.apiread.model.Account;

public interface Register {
    public String save( Account account);
    Boolean checkUsername(String username);

}

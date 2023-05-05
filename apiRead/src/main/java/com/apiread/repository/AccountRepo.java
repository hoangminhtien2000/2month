package com.apiread.repository;

import com.apiread.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {

    Account findAccountByUsername(String username);

}

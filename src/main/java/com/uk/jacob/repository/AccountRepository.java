package com.uk.jacob.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uk.jacob.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
    public Account findByEmail(String email);
}

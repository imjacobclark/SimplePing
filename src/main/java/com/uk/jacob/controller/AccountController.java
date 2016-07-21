package com.uk.jacob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uk.jacob.DocumentModel.Account;
import com.uk.jacob.repository.AccountRepository;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Account> getAccounts(){
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Account createAccount(final @RequestBody Account account){
		repository.save(account);
		return account;
	}
}





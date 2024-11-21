package com.BankSystem.Bank.Service;

import java.util.List;

import com.BankSystem.Bank.Dto.AccountDto;

public interface AccountService {

	
	

	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(long Id);
	
	AccountDto deposit(long id ,double amount);
	
	AccountDto withdraw (long id, double amount);
	
	List<AccountDto>getAllAccounts();
	
	void deleteAccount(long id);
	
	



	}

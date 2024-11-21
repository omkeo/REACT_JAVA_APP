package com.BankSystem.Bank.Service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankSystem.Bank.Dto.AccountDto;
import com.BankSystem.Bank.Entity.Account;
import com.BankSystem.Bank.Repository.AccountRepository;
import com.BankSystem.Bank.Service.AccountService;
import com.BankSystem.Bank.Service.Mapper.AccountMapper;

@Service
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	
	

	public AccountServiceImp(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {

	    Account account = AccountMapper.mapToAccount1(accountDto);
	    Account savedAccount = accountRepository.save(account);
	    return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(long Id) {
		Account account =accountRepository.findById(Id).
				                           orElseThrow();
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(long id, double amount) {
		Account account =accountRepository.findById(id).
                orElseThrow();
		
      double total = account.getBalance() + amount;
      account.setBalance(total);
     Account savedAccount = accountRepository.save(account);

		 
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account =accountRepository.findById(id).
                                            orElseThrow();
		if(account.getBalance() < amount) {
			throw new RuntimeException("insufficient amount");		
		}
		double total = account.getBalance()- amount;
		account.setBalance(total);
		Account accountsaved = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(accountsaved);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
	    List<Account> accounts = accountRepository.findAll();

	    // Map each Account to AccountDto using the correct method
	    return accounts.stream()
	                   .map(account -> AccountMapper.mapToAccountDto(account)) // Fix variable name and method call
	                   .collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account =accountRepository.findById(id).
                                         orElseThrow();
	        accountRepository.deleteById(id);
	}
	



 
	




	

}

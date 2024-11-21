package com.BankSystem.Bank.Service.Mapper;

import com.BankSystem.Bank.Dto.AccountDto;
import com.BankSystem.Bank.Entity.Account;

public class AccountMapper {
	
		
		public static AccountDto mapToAccountDto(Account account) {
	        return new AccountDto(
	            account.getId(),
	            account.getAccountHolderName(),
	            account.getBalance()
	        );
	    }

	    public static Account mapToAccount1(AccountDto accountDto) {

	        Account account = new Account();
	        account.setId(accountDto.getId());
	        account.setAccountHolderName(accountDto.getAccountHolderName());
	        account.setBalance(accountDto.getBalance()); // Ensure balance is set
	        return account;
	    
}}

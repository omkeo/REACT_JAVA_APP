package com.BankSystem.Bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankSystem.Bank.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {


}

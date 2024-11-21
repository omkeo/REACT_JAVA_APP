package com.BankSystem.Bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankSystem.Bank.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}

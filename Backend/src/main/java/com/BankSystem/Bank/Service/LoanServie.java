package com.BankSystem.Bank.Service;

import java.util.List;

import com.BankSystem.Bank.Dto.LoanDto;

public interface LoanServie {
	
	 LoanDto createLoan(LoanDto loanDto);

	    LoanDto updateLoanStatus(Long loanId, String status);

	    LoanDto getLoanById(Long loanId);

	    List<LoanDto> getAllLoans();

	    void deleteLoan(Long loanId);


}

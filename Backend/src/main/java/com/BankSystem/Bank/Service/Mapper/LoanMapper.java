package com.BankSystem.Bank.Service.Mapper;

import org.springframework.stereotype.Component;

import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Entity.Loan;
import com.BankSystem.Bank.Entity.User;

@Component

public class LoanMapper {

	public LoanDto toDTO(Loan loan) {
        return LoanDto.builder()
                .id(loan.getId())
                .amount(loan.getAmount())
                .loanType(loan.getLoanType())
                .status(loan.getStatus())
                .userId(loan.getUser().getId())
                .build();
    }

    public LoanDto toEntity(LoanDto loanDTO, Long user) {
        return Loan.builder()
                .id(loanDTO.getId())
                .amount(loanDTO.getAmount())
                .loanType(loanDTO.getLoanType())
                .status(loanDTO.getStatus())
                .userId(user)
                .build();
    }

	public Loan toEntity(LoanDto loanDto) {
		// TODO Auto-generated method stub
		return null;
	}
}

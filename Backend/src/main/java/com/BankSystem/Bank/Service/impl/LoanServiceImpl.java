package com.BankSystem.Bank.Service.impl;


import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Entity.Loan;

import com.BankSystem.Bank.Repository.LoanRepository;

import com.BankSystem.Bank.Service.LoanServie;
import com.BankSystem.Bank.Service.Mapper.LoanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanServie {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        Loan loan = loanMapper.toEntity(loanDto);
        Loan savedLoan = loanRepository.save(loan);
        return loanMapper.toDTO(savedLoan);
    }

    @Override
    public LoanDto updateLoanStatus(Long loanId, String status) {
        Optional<Loan> optionalLoan = loanRepository.findById(loanId);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setStatus(status);
            Loan updatedLoan = loanRepository.save(loan);
            return loanMapper.toDTO(updatedLoan);
        } else {
            throw new RuntimeException("Loan not found with ID: " + loanId);
        }
    }

    @Override
    public LoanDto getLoanById(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with ID: " + loanId));
        return loanMapper.toDTO(loan);
    }

    @Override
    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(loanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLoan(Long loanId) {
        if (loanRepository.existsById(loanId)) {
            loanRepository.deleteById(loanId);
        } else {
            throw new RuntimeException("Loan not found with ID: " + loanId);
        }
    }
}

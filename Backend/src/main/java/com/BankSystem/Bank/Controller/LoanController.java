package com.BankSystem.Bank.Controller;


import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Service.impl.LoanServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanServiceImpl loanService;

    // Create a new Loan
    @PostMapping
    public ResponseEntity<LoanDto> createLoan(@RequestBody LoanDto loanDto) {
        LoanDto createdLoan = loanService.createLoan(loanDto);
        return ResponseEntity.ok(createdLoan);
    }

    // Update Loan Status (Approve/Reject)
    @PutMapping("/{id}")
    public ResponseEntity<LoanDto> updateLoanStatus(@PathVariable Long id, @RequestBody LoanDto loanDto) {
        LoanDto updatedLoan = loanService.updateLoanStatus(id, loanDto.getStatus());
        return ResponseEntity.ok(updatedLoan);
    }

    // Get Loan Details by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getLoanById(@PathVariable Long id) {
        LoanDto loanDto = loanService.getLoanById(id);
        return ResponseEntity.ok(loanDto);
    }

    // Get All Loans
    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        List<LoanDto> loanDtos = loanService.getAllLoans();
        return ResponseEntity.ok(loanDtos);
    }

    // Delete Loan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}

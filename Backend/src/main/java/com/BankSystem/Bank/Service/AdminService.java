package com.BankSystem.Bank.Service;

import java.util.List;

import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Dto.UserDto;

public interface AdminService {

	UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    LoanDto approveLoan(Long id);
    LoanDto rejectLoan(Long id);
    List<LoanDto> getAllLoans();
}

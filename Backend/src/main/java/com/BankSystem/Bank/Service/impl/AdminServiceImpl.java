package com.BankSystem.Bank.Service.impl;



import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Dto.UserDto;
import com.BankSystem.Bank.Entity.Loan;
import com.BankSystem.Bank.Entity.User;
import com.BankSystem.Bank.Repository.LoanRepository;
import com.BankSystem.Bank.Repository.UserRepository;
import com.BankSystem.Bank.Service.Mapper.LoanMapper;
import com.BankSystem.Bank.Service.Mapper.UserMapper;
import com.BankSystem.Bank.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoanMapper loanMapper;

    // Update User
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));

        // Update user details
        user.setFullName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setActive(userDto.isActive());

        // Save and return the updated user as DTO
        User updatedUser = userRepository.save(user);
        return userMapper.mapToUserDto(updatedUser);
    }

    // Delete User
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    // Approve Loan
    @Override
    public LoanDto approveLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loan with ID " + id + " not found"));

        // Approve loan
        loan.setStatus("APPROVED");

        // Save and return the updated loan as DTO
        Loan approvedLoan = loanRepository.save(loan);
        return loanMapper.toDTO(approvedLoan);
    }

    // Reject Loan
    @Override
    public LoanDto rejectLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loan with ID " + id + " not found"));

        // Reject loan
        loan.setStatus("REJECTED");

        // Save and return the updated loan as DTO
        Loan rejectedLoan = loanRepository.save(loan);
        return loanMapper.toDTO(rejectedLoan);
    }

    // Get All Loans
    @Override
    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toDTO)
                .collect(Collectors.toList());
    }
}

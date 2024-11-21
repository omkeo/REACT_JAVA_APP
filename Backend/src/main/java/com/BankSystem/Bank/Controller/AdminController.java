package com.BankSystem.Bank.Controller;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankSystem.Bank.Dto.AccountDto;
import com.BankSystem.Bank.Dto.LoanDto;
import com.BankSystem.Bank.Dto.UserDto;
import com.BankSystem.Bank.Service.impl.AdminServiceImpl;
import com.BankSystem.Bank.Service.impl.UserServicelmpl;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private AdminServiceImpl adminService;

	@Autowired
	private UserServicelmpl userServicelmpl;
	
	@PostConstruct
	public void checkDependencies() {
	    System.out.println("AdminServiceImpl: " + adminService);
	    System.out.println("UserServicelmpl: " + userServicelmpl);
	}

	
    // Update User
    @PostMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(adminService.updateUser(id, userDto));
    }

    // Delete User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Approve Loan
    @PutMapping("/loans/{id}/approve")
    public ResponseEntity<Object> approveLoan(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.approveLoan(id));
    }

    // Reject Loan
    @PutMapping("/loans/{id}/reject")
    public ResponseEntity<Object> rejectLoan(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.rejectLoan(id));
    }

    // Get All Loans
    @GetMapping("/loans")
    public ResponseEntity<Object> getAllLoans() {
        return ResponseEntity.ok(adminService.getAllLoans());
    }
}
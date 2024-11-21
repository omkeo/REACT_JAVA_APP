package com.BankSystem.Bank.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.BankSystem.Bank.Dto.UserDto;
import com.BankSystem.Bank.Entity.User;


public interface UserService1 {
	
	User registerUser(User user);

    String loginUser(String username, String password);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
    
    public UserDetails loadUserDetails(String username) throws UsernameNotFoundException;
}



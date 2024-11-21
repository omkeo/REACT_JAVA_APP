package com.BankSystem.Bank.Service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BankSystem.Bank.Dto.UserDto;
import com.BankSystem.Bank.Entity.User;
import com.BankSystem.Bank.Repository.UserRepository;
import com.BankSystem.Bank.Service.UserService1;

@Service
public class UserServicelmpl implements UserService1{
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
    public User registerUser(User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user); // Save and return the user
    }

	@Override
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the password matches
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        return identifyRole(user);
    }
 
	private String identifyRole(User user) {
        switch (user.getRole().toUpperCase()) {
            case "ADMIN":
                return "Admin role identified.";
            case "MANAGER":
                return "Manager role identified.";
            case "ACCOUNTANT":
                return "Accountant role identified.";
            case "CLERK":
                return "Clerk role identified.";
            case "USER":
                return "User role identified.";
            default:
                return "Unknown role.";
        }
    }
	
	@Override
	public UserDetails loadUserDetails(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	    return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            getAuthorities(user.getRole())
	    );
	}
	
	 private Collection<? extends GrantedAuthority> getAuthorities(String role) {
	        return List.of(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
	    }
	 
	 @Override
	    public Optional<User> getUserById(Long id) {
	        return userRepository.findById(id);
	    }
	 
	 @Override
	    public User updateUser(Long id, User user) {
	        User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        // Update user details here
	        existingUser.setUsername(user.getUsername());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setRole(user.getRole());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setFullName(user.getFullName());
	        existingUser.setPhoneNumber(user.getPhoneNumber());
	        existingUser.setAddress(user.getAddress());

	        return userRepository.save(existingUser);
	    }
	 
	 @Override
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

	 @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	
	

	
}

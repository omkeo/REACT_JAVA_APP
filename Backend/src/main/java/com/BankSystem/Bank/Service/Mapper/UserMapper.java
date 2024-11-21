package com.BankSystem.Bank.Service.Mapper;

import org.springframework.stereotype.Component;

import com.BankSystem.Bank.Dto.UserDto;
import com.BankSystem.Bank.Entity.User;

@Component
public class UserMapper {
	
	public static UserDto mapToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFullName(),
                user.getRole(),
                user.getPhoneNumber(),
                user.getAddress()
        );
    }
	 public static User mapToEntity(UserDto userDto) {
	        if (userDto == null) {
	            return null;
	        }
	        User user = new User();
	        user.setId(userDto.getId());
	        user.setUsername(userDto.getUsername());
	        user.setPassword(userDto.getPassword());
	        user.setEmail(userDto.getEmail());
	        user.setFullName(userDto.getFullName());
	        user.setRole(userDto.getRole());
	        user.setPhoneNumber(userDto.getPhoneNumber());
	        user.setAddress(userDto.getAddress());
	        return user;
	    }

}

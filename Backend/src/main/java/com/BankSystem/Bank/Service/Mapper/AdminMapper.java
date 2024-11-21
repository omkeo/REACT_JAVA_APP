package com.BankSystem.Bank.Service.Mapper;

import com.BankSystem.Bank.Dto.AdminDto;
import com.BankSystem.Bank.Entity.Admin;

public class AdminMapper {

    // Convert Admin entity to AdminDto
    public static AdminDto toDto(Admin admin) {
        return new AdminDto(
            admin.getId(),
            admin.getUsername(),
            admin.getEmail(),
            admin.getPassword() // Make sure to hash or exclude password as needed
        );
    }

    // Convert AdminDto to Admin entity
    public static Admin toEntity(AdminDto adminDto) {
        return new Admin(
            adminDto.getUsername(),
            adminDto.getEmail(),
            adminDto.getPassword() // Handle password securely
        );
    }
}

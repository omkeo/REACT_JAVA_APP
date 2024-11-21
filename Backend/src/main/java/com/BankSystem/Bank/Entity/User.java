package com.BankSystem.Bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="User")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String password;
	    
	    @Column(name="email")
	    private String email;
	    private String fullName;
	    private String role;
	    private String phoneNumber;
	    private String address;
	    
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Long id, String username, String password, String email, String fullName, String role,
				String phoneNumber, String address) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.fullName = fullName;
			this.role = role;
			this.phoneNumber = phoneNumber;
			this.address = address;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		 private boolean isActive;

		    // Getter method for isActive
		    public boolean isActive() {
		        return this.isActive;
		    }

		    // Setter method for isActive
		    public void setActive(boolean isActive) {
		        this.isActive = isActive;
		    }
	    
}

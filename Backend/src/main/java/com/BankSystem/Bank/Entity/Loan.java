package com.BankSystem.Bank.Entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String loanType; // e.g., HOME, CAR, PERSONAL

    @Column(nullable = false)
    private String status; // e.g., PENDING, APPROVED, REJECTED

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	private Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Loan(Long id, Double amount, String loanType, String status, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.loanType = loanType;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static com.BankSystem.Bank.Dto.LoanDto.Builder builder() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}


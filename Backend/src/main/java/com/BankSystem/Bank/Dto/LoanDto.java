package com.BankSystem.Bank.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class LoanDto {
	
    private LoanDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long id;
    private Double amount;
    private String loanType;
    private String status;
    private Long userId;

    // Private constructor for builder usage
    private LoanDto(Long id, Double amount, String loanType, String status, Long userId) {
        this.id = id;
        this.amount = amount;
        this.loanType = loanType;
        this.status = status;
        this.userId = userId;
    }

    // Static nested Builder class
    public static class Builder {
        private Long id;
        private Double amount;
        private String loanType;
        private String status;
        private Long userId;
        
        

        private Builder() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder loanType(String loanType) {
            this.loanType = loanType;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public LoanDto build() {
            return new LoanDto(id, amount, loanType, status, userId);
        }
    }

    // Getters (optional, depending on usage)
    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

	public static Builder builder() {
		// TODO Auto-generated method stub
		return null;
	}
}


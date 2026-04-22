package io.github.dr3amer1.optimaldeposits.dto;

import lombok.Data;

@Data
public class BestDepositResponse {

    private boolean found;
    private String message;

    private Long depositId;
    private String depositName;
    private Double interestRate;
    private Integer termMonths;

    private Double amount;
    private Double profit;
    private Double totalAmount;
}
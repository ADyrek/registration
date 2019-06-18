package de.smava.register.loanservice.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanApplicationDto {

    private BigDecimal amount;
    private int duration;
    private Long ownerId;

}

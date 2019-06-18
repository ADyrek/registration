package de.smava.register.loanservice.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "loanApplication")
public class LoanApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private int duration;
    private Long ownerId;

}

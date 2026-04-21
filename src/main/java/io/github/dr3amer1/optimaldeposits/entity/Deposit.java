package io.github.dr3amer1.optimaldeposits.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "deposits")
@Data
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double interestRate;

    private int termMonths;

    private double minAmount;

    private double maxAmount;

}

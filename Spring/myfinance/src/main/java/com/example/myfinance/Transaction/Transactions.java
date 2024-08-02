package com.example.myfinance.Transaction;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
@Table
@NoArgsConstructor
public class Transactions {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "transaction_sequence"
    )
    private Long id;
    private Type type;

    private double amount;

    private LocalDate date;

    public Transactions(Type type, double amount, LocalDate date) {

        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}

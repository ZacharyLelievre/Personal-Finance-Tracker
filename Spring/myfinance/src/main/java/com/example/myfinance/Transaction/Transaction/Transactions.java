package com.example.myfinance.Transaction.Transaction;

import com.example.myfinance.Transaction.Customer.Customers;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="transactions")
@NoArgsConstructor
public class Transactions {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    //@Column(name="transactionid", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionid; // Database id

    @Enumerated(EnumType.STRING)
    private Type type;

    private double amount;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="customerid", referencedColumnName = "customerid")
    private Customers customers;
}
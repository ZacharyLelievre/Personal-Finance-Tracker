package com.example.myfinance.Transaction.Transaction;

import com.example.myfinance.Transaction.Customer.Customers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name="transactions")
@NoArgsConstructor
@AllArgsConstructor
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

    public LocalDate getTransactionDate() {
        return date;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.date = transactionDate;
    }


}


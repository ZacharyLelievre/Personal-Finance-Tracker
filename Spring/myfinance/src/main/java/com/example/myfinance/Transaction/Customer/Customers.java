package com.example.myfinance.Transaction.Customer;

import com.example.myfinance.Transaction.Transaction.Transactions;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="customers")
@NoArgsConstructor
public class Customers {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;

    //@Column(name="customerid", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid; // Database id

    private String name;
    private String username;
    private String password;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> transactions;
}

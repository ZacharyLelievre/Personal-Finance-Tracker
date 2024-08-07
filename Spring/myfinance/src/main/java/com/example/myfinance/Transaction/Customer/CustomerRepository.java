package com.example.myfinance.Transaction.Customer;

import com.example.myfinance.Transaction.Transaction.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {

    //Optional<Customers> findByUsername(String username);

//    List<Transactions> findTransactionsByCustomer_CustomerId(String customerid);

}
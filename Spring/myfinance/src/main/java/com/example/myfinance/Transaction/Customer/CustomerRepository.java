package com.example.myfinance.Transaction.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {

    //Optional<Customers> findByUsername(String username);

//    List<Transactions> findTransactionsByCustomer_CustomerId(String customerid);

}
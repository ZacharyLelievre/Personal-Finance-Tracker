package com.example.myfinance.Transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {

//    Transactions findByTransactionId(Long transactionId);
//
//    Transactions findByTransactionDate(String transactionDate);
//    Transactions findTransactionDateByTransaction();

    //List<Transactions>
}

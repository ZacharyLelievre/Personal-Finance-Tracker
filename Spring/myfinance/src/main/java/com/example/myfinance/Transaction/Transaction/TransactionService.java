package com.example.myfinance.Transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }



    public List<Transactions> getInfos(){
      return transactionRepository.findAll();

    }

    public void addNewTransaction(Transactions transactions) {
        transactionRepository.save((transactions));
    }
}

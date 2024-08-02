package com.example.myfinance.Transaction;

import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

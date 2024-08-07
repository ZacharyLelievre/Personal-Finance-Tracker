package com.example.myfinance.Controller;

import com.example.myfinance.Transaction.Transaction.TransactionService;
import com.example.myfinance.Transaction.Transaction.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transaction")
@CrossOrigin(origins = "http://127.0.0.1:5502")
public class TransactionsController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transactions> getInfos(){
        return transactionService.getInfos();
    }
    @PostMapping
    public void addTransaction(@RequestBody Transactions transactions){
        transactionService.addNewTransaction(transactions);
    }
}

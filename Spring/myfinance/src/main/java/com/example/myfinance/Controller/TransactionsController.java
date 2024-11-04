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

    @GetMapping(value = "", produces = "application/json")
    public List<Transactions> getInfos(@RequestParam(required = false) String minDate,
                                       @RequestParam(required = false) String maxDate){
        return transactionService.getInfos(minDate, maxDate);
    }
    @PostMapping(value = "", consumes = "application/json")
    public void addTransaction(@RequestBody Transactions transactions){
        transactionService.addNewTransaction(transactions);
    }
}

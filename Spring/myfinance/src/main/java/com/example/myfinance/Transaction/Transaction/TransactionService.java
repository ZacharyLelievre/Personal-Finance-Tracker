package com.example.myfinance.Transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }



    @GetMapping
    public List<Transactions> getInfos(@RequestParam(required = false) Date minDate,
                                       @RequestParam(required = false) Date maxDate) {
        if (minDate == null && maxDate == null) {
            return transactionRepository.findAll();
        }

        LocalDate minLocalDate = minDate != null ? minDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate maxLocalDate = maxDate != null ? maxDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

        return transactionRepository.findAll().stream()
                .filter(e -> (minLocalDate == null || e.getTransactionDate().isAfter(minLocalDate)) &&
                        (maxLocalDate == null || e.getTransactionDate().isBefore(maxLocalDate)))
                .sorted()
                .collect(Collectors.toList());
    }

    public void addNewTransaction(Transactions transactions) {
        transactionRepository.save((transactions));
    }
}

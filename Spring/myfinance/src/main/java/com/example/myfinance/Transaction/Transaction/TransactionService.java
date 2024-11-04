package com.example.myfinance.Transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
    public List<Transactions> getInfos(@RequestParam(required = false) String minDate,
                                       @RequestParam(required = false) String maxDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate minLocalDate = null;
        LocalDate maxLocalDate = null;


        if (minDate != null) {
            minLocalDate = LocalDate.parse(minDate, formatter);
        }
        if (maxDate != null) {
            maxLocalDate = LocalDate.parse(maxDate, formatter);
        }

        LocalDate finalMinLocalDate = minLocalDate;
        LocalDate finalMaxLocalDate = maxLocalDate;

        return transactionRepository.findAll().stream()
                .filter(e -> (finalMinLocalDate == null || e.getTransactionDate().isAfter(finalMinLocalDate)) &&
                        (finalMaxLocalDate == null || e.getTransactionDate().isBefore(finalMaxLocalDate)))
                .sorted(Comparator.comparing(Transactions::getTransactionDate))
                .collect(Collectors.toList());
    }

    public void addNewTransaction(Transactions transactions) {
        transactionRepository.save((transactions));
    }
}

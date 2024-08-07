package com.example.myfinance.Transaction.Customer;


import com.example.myfinance.Transaction.Transaction.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }


    public void addCustomer(Customers customers){
        customerRepository.save(customers);
    }

}

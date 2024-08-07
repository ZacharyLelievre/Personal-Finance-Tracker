package com.example.myfinance.Controller;

import com.example.myfinance.Transaction.Customer.CustomerService;
import com.example.myfinance.Transaction.Customer.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomersController {

    private final CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService){
        this.customerService=customerService;

    }
    @GetMapping
    public List<Customers> getAllCustomers(){
        return customerService.getAllCustomers();

    }
    @PostMapping
    public void addCustomers(@RequestBody Customers customers){
        customerService.addCustomer(customers);
    }


}

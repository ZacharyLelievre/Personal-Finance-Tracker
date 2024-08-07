package com.example.myfinance.Transaction.Transaction;

import com.example.myfinance.Transaction.Customer.CustomerRepository;
import com.example.myfinance.Transaction.Customer.Customers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5502")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

//    @Bean
//    CommandLineRunner commandLineRunner(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
//        return args -> {
//            // Create some sample customers
//            Customers customer1 = new Customers();
//            customer1.setCustomerid(1);
//            customer1.setName("John Doe");
//            customer1.setUsername("johndoe");
//            customer1.setPassword("password123");
//
//            Customers customer2 = new Customers();
//            customer2.setCustomerid(2);
//            customer2.setName("Jane Smith");
//            customer2.setUsername("janesmith");
//            customer2.setPassword("password456");
//
//            Customers customer3 = new Customers();
//            customer3.setCustomerid(3);
//            customer3.setName("Alice Johnson");
//            customer3.setUsername("alicej");
//            customer3.setPassword("password789");
//
//            // Save customers to the repository
//            customerRepository.saveAll(List.of(customer1, customer2, customer3));
//
//            // Create some sample transactions
//            Transactions transaction1 = new Transactions(
//                    Type.PURCHASE,
//                    100.0,
//                    LocalDate.of(2024, 1, 20)
//            );
//            transaction1.setCustomers(customer1);
//
//            Transactions transaction2 = new Transactions(
//                    Type.DEPOSIT,
//                    200.0,
//                    LocalDate.of(2024, 1, 21)
//            );
//            transaction2.setCustomers(customer2);
//
//            Transactions transaction3 = new Transactions(
//                    Type.WITHDRAWAL,
//                    50.0,
//                    LocalDate.of(2024, 1, 22)
//            );
//            transaction3.setCustomers(customer3);
//
//            // Save transactions to the repository
//            transactionRepository.saveAll(List.of(transaction1, transaction2, transaction3));
//        };
//    }

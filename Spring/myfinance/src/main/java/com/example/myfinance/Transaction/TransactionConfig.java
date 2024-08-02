package com.example.myfinance.Transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfig {


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5502")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }


    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository repository) {
        return args -> {
            // Create some sample transactions
            Transactions transaction1 = new Transactions(
                    Type.PURCHASE,
                    100.0,
                    LocalDate.of(2024, 1, 20)
            );

            Transactions transaction2 = new Transactions(
                    Type.DEPOSIT,
                    200.0,
                    LocalDate.of(2024, 1, 21)
            );

            Transactions transaction3 = new Transactions(
                    Type.WITHDRAWAL,
                    50.0,
                    LocalDate.of(2024, 1, 22)
            );

            // Save transactions to the repository
            repository.saveAll(List.of(transaction1, transaction2, transaction3));
        };
    }
}

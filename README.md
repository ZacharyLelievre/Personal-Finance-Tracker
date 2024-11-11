# Work in Progress
# MyFinance Application

MyFinance is a finance tracking application built with Spring Boot, allowing users to securely manage their transactions with encrypted data storage, generate financial reports, and export them to PDF format.

## Features

- **User Registration**: Allows new users to sign up and create an account.
- **Login System**: Secure login functionality with password encryption.
- **Customer Management**: Add and manage customers.
- **Transaction Management**: Create, view, and manage financial transactions, including deposits, withdrawals, purchases, transfers, and refunds.
- **Reports**: View financial reports based on transactions, with options to export as PDF.
- **PDF Generation**: Generate PDF reports of transaction summaries for easy sharing and record-keeping.
- **Responsive UI**: Basic web interface for managing accounts and transactions.

## Technologies Used

- **Backend**: Spring Boot (Java)
- **Database**: JPA with Hibernate (supports MySQL or other relational databases)
- **Frontend**: HTML, CSS, and Thymeleaf for dynamic content rendering
- **Security**: Spring Security for user authentication and password encryption
- **PDF Export**: Integration with PDF generation libraries to export reports
- **Charts**: Chart.js for visualizing financial data (e.g., income vs. expenses)

## API Endpoints

- **Customers API** (`/api/v1/customers`)
  - `GET`: Retrieve all customers
  - `POST`: Add new customers

- **Transactions API** (`/api/v1/transaction`)
  - `GET`: Retrieve all transactions
  - `POST`: Add new transactions

- **PDF Report API** (`/api/v1/reports/pdf`)
  - `GET`: Generate a PDF of financial transactions report

## Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle for dependency management
- MySQL or any other relational database

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/ZacharyLelievre/Personal-Finance-Tracker.git
   cd myfinance

# Banking System Simulation - Java OOP Project

A comprehensive banking system simulation built with Java that demonstrates Object-Oriented Programming principles through real-world banking operations including account management, transactions, and customer services.

## 🏦 Overview

The Banking System Simulation is a multi-class Java application that models real banking operations with a command-line interface. It showcases advanced OOP concepts while providing practical banking functionality including deposits, withdrawals, transfers, and comprehensive transaction tracking.

## ✨ Features

### Customer Management
- **Customer Registration**: Add new bank customers with unique IDs
- **Customer Directory**: View all registered customers with contact information
- **Customer Validation**: Prevent duplicate customer registrations

### Account Management
- **Account Creation**: Open new bank accounts for registered customers
- **Account Overview**: View all accounts with balances and holder information
- **Account Verification**: Ensure account existence for transactions

### Banking Operations
- **Deposits**: Add funds to accounts with amount validation
- **Withdrawals**: Remove funds with overdraft protection
- **Transfers**: Move money between accounts with balance checks
- **Balance Inquiry**: Check current account balances

### Transaction System
- **Complete History**: Full transaction logging with timestamps
- **Mini Statements**: View last 5 transactions for quick overview
- **Transaction Types**: Categorized operations (Deposit, Withdrawal, Transfer)
- **Real-time Tracking**: Automatic recording of all financial activities

### Account Services
- **Account Details**: Comprehensive account information display
- **Transaction History**: Complete audit trail of all account activities
- **Mini Statements**: Quick overview of recent transactions
- **Balance Reporting**: Current balance with transaction context

## 🏗️ System Architecture

### Class Structure

```
BankingSystem/
├── BankApp.java              # Main application entry point
├── Bank.java                 # Core banking operations and management
├── Account.java              # Account entity with transaction methods
├── Customer.java             # Customer entity with personal information
├── Transaction.java          # Transaction record with metadata
└── TransactionType.java      # Enumeration of transaction types
```

### Class Responsibilities

- **BankApp**: Main application class with menu navigation and user interface
- **Bank**: Core business logic managing customers, accounts, and transactions
- **Account**: Handles account operations, balance management, and transaction history
- **Customer**: Stores customer information and personal details
- **Transaction**: Records individual transaction data with timestamps
- **TransactionType**: Defines possible transaction categories

## 🚀 Installation & Execution

### Prerequisites
- Java JDK 8 or higher
- VS Code, IntelliJ IDEA, or any Java-compatible IDE
- Terminal/Command Prompt access

### Running the Application

#### Using VS Code
1. Create a new Java project in VS Code
2. Copy all six Java files into your `src` directory
3. Run `BankApp.java`

#### Using IntelliJ IDEA
1. Create a new Java project
2. Add all six Java classes to your project
3. Execute the `main` method in `BankApp.java`

#### Using Terminal/Command Line
```bash
# Compile all Java files
javac *.java

# Run the application
java BankApp
```

## 📖 User Guide

### Main Menu Navigation

The system features a hierarchical menu system organized by functionality:

1. **Customer Management**
   - Register new bank customers
   - View all registered customers
   - Manage customer information

2. **Account Management**
   - Create new bank accounts
   - View all accounts with details
   - Link accounts to registered customers

3. **Transactions**
   - Deposit funds into accounts
   - Withdraw funds with balance validation
   - Transfer money between accounts

4. **Account Services**
   - View comprehensive account details
   - Access complete transaction history
   - Generate mini statements
   - Check current balances

### Key Operations

#### Customer Registration
- Provide unique Customer ID, name, email, and phone
- System validates unique customer identification

#### Account Creation
- Requires existing customer ID
- Unique account number assignment
- Initial deposit processing
- Automatic transaction recording

#### Deposit Operations
- Verify target account existence
- Validate deposit amount (must be positive)
- Update account balance
- Record transaction with timestamp

#### Withdrawal Operations
- Confirm account existence and ownership
- Validate sufficient funds
- Process withdrawal amount
- Update balance and transaction history

#### Transfer Operations
- Verify both sender and recipient accounts
- Validate transfer amount and sufficient funds
- Process dual account updates
- Record transactions for both accounts

## 🛠️ Technical Implementation

### Object-Oriented Programming Principles

- **Encapsulation**: All classes use private fields with controlled access through methods
- **Abstraction**: Complex banking operations simplified through intuitive method interfaces
- **Composition**: Bank system composed of Customer, Account, and Transaction objects
- **Modularity**: Separate concerns across specialized classes
- **Data Hiding**: Internal implementation details protected from external access

### Transaction Management System

```java
// Transaction recording example
public boolean deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        addTransaction(TransactionType.DEPOSIT, amount, "Cash deposit");
        return true;
    }
    return false;
}
```

### Data Structures and Collections

- **ArrayList**: Dynamic collections for customers, accounts, and transactions
- **Enum Types**: Type-safe transaction categorization
- **DateTime API**: Precise transaction timestamping
- **String Formatting**: Professional output presentation

### Validation and Error Handling

- Input validation for all user interactions
- Balance verification for withdrawals and transfers
- Account existence checks for all operations
- Duplicate prevention for customer and account IDs
- Comprehensive exception handling

## 🎯 Learning Outcomes

### Real-World OOP Implementation
- Class design and relationships
- Method encapsulation and access control
- Object composition and aggregation
- Enumeration usage for type safety

### Banking Business Logic
- Financial transaction processing
- Account balance management
- Transaction auditing and history
- Customer-account relationships

### Java Programming Skills
- Collection management with ArrayList
- DateTime API for timestamp operations
- Scanner class for user input handling
- String manipulation and formatting
- Menu-driven application architecture

## 🔧 Sample Data

The system includes pre-loaded sample data for immediate testing:

### Sample Customers
- John Smith (C001) - john.smith@email.com
- Emma Wilson (C002) - emma.wilson@email.com  
- Mike Johnson (C003) - mike.johnson@email.com

### Sample Accounts
- ACC001: $1,000.00 initial balance
- ACC002: $2,500.00 initial balance
- ACC003: $500.00 initial balance

### Sample Transactions
- Deposits, withdrawals, and transfers between sample accounts
- Complete transaction history with timestamps
- Demonstration of all transaction types

## 🔮 Extensibility

The system architecture supports easy extension:

### Additional Account Types
```java
class SavingsAccount extends Account {
    private double interestRate;
    // Savings-specific methods
}

class CurrentAccount extends Account {
    private double overdraftLimit;
    // Current account specific methods
}
```

### Enhanced Features
- Interest calculation and compounding
- Overdraft protection and limits
- Loan management system
- Multiple currency support
- Graphical user interface
- Database persistence
- Web service integration
- Mobile application backend

### Security Enhancements
- User authentication and authorization
- Transaction encryption
- Audit logging
- Compliance reporting

## 🤝 Contributing

Contributions are welcome! This project demonstrates fundamental banking operations and can be extended with:

- Additional financial products
- Enhanced security features
- Reporting and analytics
- Integration capabilities

Feel free to fork this project and submit pull requests for any improvements or additional features.

---

**Experience Real Banking Operations Through Code!** 🏦💻
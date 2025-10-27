import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;
    private Scanner scanner;
    
    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeSampleData();
    }
    

    public void addCustomer() {
        System.out.println("\n=== ADD NEW CUSTOMER ===");
        
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        
        if (findCustomerById(customerId) != null) {
            System.out.println("Error: Customer with ID " + customerId + " already exists!");
            return;
        }
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        Customer customer = new Customer(customerId, name, email, phone);
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }
    
    public void viewAllCustomers() {
        System.out.println("\n=== ALL CUSTOMERS ===");
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }
        
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }
    }
    

    public void createAccount() {
        System.out.println("\n=== CREATE NEW ACCOUNT ===");
        
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found! Please register customer first.");
            return;
        }
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        if (findAccountByNumber(accountNumber) != null) {
            System.out.println("Error: Account with number " + accountNumber + " already exists!");
            return;
        }
        
        System.out.print("Enter Initial Deposit: $");
        double initialDeposit = Double.parseDouble(scanner.nextLine());
        
        if (initialDeposit < 0) {
            System.out.println("Error: Initial deposit cannot be negative!");
            return;
        }
        
        Account account = new Account(accountNumber, customerId, initialDeposit);
        accounts.add(account);
        System.out.println("Account created successfully for " + customer.getName());
        System.out.println("Account Number: " + accountNumber + " | Initial Balance: $" + initialDeposit);
    }
    
    public void viewAllAccounts() {
        System.out.println("\n=== ALL ACCOUNTS ===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            Customer customer = findCustomerById(account.getAccountHolderId());
            String customerName = (customer != null) ? customer.getName() : "Unknown";
            
            System.out.println((i + 1) + ". " + account + " | Holder: " + customerName);
        }
    }
    

    public void deposit() {
        System.out.println("\n=== DEPOSIT MONEY ===");
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        Customer customer = findCustomerById(account.getAccountHolderId());
        System.out.print("Enter amount to deposit: $");
        double amount = Double.parseDouble(scanner.nextLine());
        
        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Deposit failed! Amount must be positive.");
        }
    }
    
    public void withdraw() {
        System.out.println("\n=== WITHDRAW MONEY ===");
        
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter amount to withdraw: $");
        double amount = Double.parseDouble(scanner.nextLine());
        
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed! Insufficient funds or invalid amount.");
        }
    }
    
    public void transfer() {
        System.out.println("\n=== TRANSFER MONEY ===");
        
        System.out.print("Enter Sender Account Number: ");
        String senderAccountNumber = scanner.nextLine();
        
        Account senderAccount = findAccountByNumber(senderAccountNumber);
        if (senderAccount == null) {
            System.out.println("Sender account not found!");
            return;
        }
        
        System.out.print("Enter Recipient Account Number: ");
        String recipientAccountNumber = scanner.nextLine();
        
        Account recipientAccount = findAccountByNumber(recipientAccountNumber);
        if (recipientAccount == null) {
            System.out.println("Recipient account not found!");
            return;
        }
        
        if (senderAccountNumber.equals(recipientAccountNumber)) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }
        
        System.out.print("Enter transfer amount: $");
        double amount = Double.parseDouble(scanner.nextLine());
        
        if (senderAccount.transfer(recipientAccount, amount)) {
            System.out.println("Transfer successful!");
            System.out.println("Sender new balance: $" + senderAccount.getBalance());
        } else {
            System.out.println("Transfer failed! Insufficient funds or invalid amount.");
        }
    }
    
    public void viewAccountDetails() {
        System.out.print("\nEnter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        Customer customer = findCustomerById(account.getAccountHolderId());
        
        System.out.println("\n=== ACCOUNT DETAILS ===");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Current Balance: $" + account.getBalance());
        
        account.viewMiniStatement();
    }
    
    public void viewTransactionHistory() {
        System.out.print("\nEnter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        account.viewTransactionHistory();
    }
    

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    private Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    

    private void initializeSampleData() {

        customers.add(new Customer("C001", "John Smith", "john.smith@email.com", "123-456-7890"));
        customers.add(new Customer("C002", "Emma Wilson", "emma.wilson@email.com", "123-456-7891"));
        customers.add(new Customer("C003", "Mike Johnson", "mike.johnson@email.com", "123-456-7892"));
        

        accounts.add(new Account("ACC001", "C001", 1000.0));
        accounts.add(new Account("ACC002", "C002", 2500.0));
        accounts.add(new Account("ACC003", "C003", 500.0));
        

        Account acc1 = findAccountByNumber("ACC001");
        Account acc2 = findAccountByNumber("ACC002");
        
        if (acc1 != null && acc2 != null) {
            acc1.deposit(200.0);
            acc1.withdraw(150.0);
            acc1.transfer(acc2, 100.0);
        }
    }
}
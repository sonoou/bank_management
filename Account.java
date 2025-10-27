import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolderId;
    private double balance;
    private List<Transaction> transactionHistory;
    
    public Account(String accountNumber, String accountHolderId, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderId = accountHolderId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        

        if (initialBalance > 0) {
            addTransaction(TransactionType.DEPOSIT, initialBalance, "Initial deposit");
        }
    }
    

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(TransactionType.DEPOSIT, amount, "Cash deposit");
            return true;
        }
        return false;
    }
    

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction(TransactionType.WITHDRAWAL, amount, "Cash withdrawal");
            return true;
        }
        return false;
    }
    

    public boolean transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            recipient.balance += amount;
            

            this.addTransaction(TransactionType.TRANSFER_SENT, amount, 
                              "Transfer to " + recipient.getAccountNumber());
            recipient.addTransaction(TransactionType.TRANSFER_RECEIVED, amount, 
                                   "Transfer from " + this.accountNumber);
            return true;
        }
        return false;
    }
    

    private void addTransaction(TransactionType type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, description);
        transactionHistory.add(transaction);
    }
    

    public String getAccountNumber() {
       return accountNumber; 
    }
    public String getAccountHolderId() {
       return accountHolderId; 
    }
    public double getBalance() {
       return balance; 
    }
    public List<Transaction> getTransactionHistory() { return transactionHistory; }
    

    public void viewTransactionHistory() {
        System.out.println("\n=== TRANSACTION HISTORY for Account: " + accountNumber + " ===");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
    

    public void viewMiniStatement() {
        System.out.println("\n=== MINI STATEMENT for Account: " + accountNumber + " ===");
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        
        int startIndex = Math.max(0, transactionHistory.size() - 5);
        List<Transaction> recentTransactions = transactionHistory.subList(startIndex, transactionHistory.size());
        
        if (recentTransactions.isEmpty()) {
            System.out.println("No recent transactions.");
            return;
        }
        
        System.out.println("Last " + recentTransactions.size() + " transactions:");
        for (int i = 0; i < recentTransactions.size(); i++) {
            System.out.println((i + 1) + ". " + recentTransactions.get(i));
        }
    }
    
    @Override
    public String toString() {
        return String.format("Account: %s | Holder ID: %s | Balance: $%.2f", 
                           accountNumber, accountHolderId, balance);
    }
}
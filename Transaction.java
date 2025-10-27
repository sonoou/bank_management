import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public Transaction(TransactionType type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.transactionId = generateTransactionId();
    }
    
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis() + (int)(Math.random() * 1000);
    }

    public String getTransactionId() {
       return transactionId; 
    }
    
    public TransactionType getType() {
       return type; 
    }
    public double getAmount() {
       return amount; 
    }

    public LocalDateTime getTimestamp() {
       return timestamp; 
    }
    public String getDescription() {
       return description; 
    }

    public String getFormattedTimestamp() {
       return timestamp.format(formatter);
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %-12s: $%-8.2f | %s", 
                           getFormattedTimestamp(), 
                           type.toString(), 
                           amount, 
                           description);
    }
}
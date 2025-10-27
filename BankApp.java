import java.util.Scanner;

public class BankApp {
    private Bank bank;
    private Scanner scanner;
    private boolean running;
    
    public BankApp() {
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
        this.running = true;
    }
    
    public void start() {
        System.out.println("====================================");
        System.out.println("      BANKING SYSTEM SIMULATION");
        System.out.println("====================================");
        
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            processMainMenuChoice(choice);
        }
        
        scanner.close();
        System.out.println("Thank you for using Banking System!");
    }
    
    private void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Customer Management");
        System.out.println("2. Account Management");
        System.out.println("3. Transactions");
        System.out.println("4. Account Services");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }
    
    private void displayCustomerMenu() {
        System.out.println("\n=== CUSTOMER MANAGEMENT ===");
        System.out.println("1. Add New Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option (1-3): ");
    }
    
    private void displayAccountMenu() {
        System.out.println("\n=== ACCOUNT MANAGEMENT ===");
        System.out.println("1. Create New Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option (1-3): ");
    }
    
    private void displayTransactionMenu() {
        System.out.println("\n=== TRANSACTIONS ===");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Transfer Money");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose an option (1-4): ");
    }
    
    private void displayServicesMenu() {
        System.out.println("\n=== ACCOUNT SERVICES ===");
        System.out.println("1. View Account Details");
        System.out.println("2. View Transaction History");
        System.out.println("3. View Mini Statement");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose an option (1-4): ");
    }
    
    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handleCustomerManagement();
                break;
            case 2:
                handleAccountManagement();
                break;
            case 3:
                handleTransactionManagement();
                break;
            case 4:
                handleServicesManagement();
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Invalid option! Please choose 1-5.");
        }
    }
    
    private void handleCustomerManagement() {
        boolean inCustomerMenu = true;
        while (inCustomerMenu) {
            displayCustomerMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    bank.addCustomer();
                    break;
                case 2:
                    bank.viewAllCustomers();
                    break;
                case 3:
                    inCustomerMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-3.");
            }
        }
    }
    
    private void handleAccountManagement() {
        boolean inAccountMenu = true;
        while (inAccountMenu) {
            displayAccountMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.viewAllAccounts();
                    break;
                case 3:
                    inAccountMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-3.");
            }
        }
    }
    
    private void handleTransactionManagement() {
        boolean inTransactionMenu = true;
        while (inTransactionMenu) {
            displayTransactionMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    bank.deposit();
                    break;
                case 2:
                    bank.withdraw();
                    break;
                case 3:
                    bank.transfer();
                    break;
                case 4:
                    inTransactionMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }
    
    private void handleServicesManagement() {
        boolean inServicesMenu = true;
        while (inServicesMenu) {
            displayServicesMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    bank.viewAccountDetails();
                    break;
                case 2:
                    bank.viewTransactionHistory();
                    break;
                case 3:
                    bank.viewTransactionHistory(); // Mini statement is part of account details
                    break;
                case 4:
                    inServicesMenu = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }
    
    public static void main(String[] args) {
        BankApp app = new BankApp();
        app.start();
    }
}
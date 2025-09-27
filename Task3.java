
import java.util.Scanner;

public class Task3{        // ATM InterFace! .
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(500.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
class BankAccount{

    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance ;
    }

   public double getBalance(){

    return  balance ;

   }

   public boolean deposit(double amount){

    if(amount <= 0){

        return false ;
    }
    balance += amount ;
    return  true ;
   }

   public boolean withrow(double amount){

    if(amount <= 0 || amount > balance){
 
       return false ;
    }
    balance -= amount ;
    return  true ;
   }
}

class ATM{

    private BankAccount account ;
    private  Scanner scanner ;

    public ATM(BankAccount account){

        this.account  = account ;
        scanner = new Scanner(System.in);

    }

    public void start(){
        int choice ;

        do { 

           displayMenu();
           choice = getUserChoice();

           switch(choice){
            case 1 : withrow();
            case 2 : deposit();
            case 3 : checkbalance();
            case 4 : System.out.println("thank for using the ATM. Goodbye!");
            default: System.out.println("Invalid option. please try again.");
           } 
        } while (choice != 4);
    }

    private  void displayMenu(){

        System.out.println("ATM Menu");
        System.out.println("Withdraw");
        System.out.println("Deposit");
        System.out.println("Check Balance");
        System.out.println("Exit");
        System.out.println("Enter your Choice");
    }

    private int getUserChoice(){

        while(!scanner.hasNextInt()){
            System.out.println("please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void withrow(){

        System.out.println("Enter amount to withdrow: ");
        double amount = getValidAmount();
        if(account.withrow(amount)){

            System.out.println("withdrawal successful. new balance: $" +account.getBalance());

        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit(){

        System.out.println("Enter amount to deposit: ");
        double amount = getValidAmount() ;
        if(account.deposit(amount)){
            System.out.println("Deposit successful. new balance: $" +account.getBalance());

        } else {
            System.out.println("Invalid amount. Deposit failed. ");
        }
    }
    private void checkbalance(){

        System.out.println("Current balance: $" +account.getBalance());
    }
    private double getValidAmount(){

        while(!scanner.hasNextDouble()){
            System.out.print("please enter a valid amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
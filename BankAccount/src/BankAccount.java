/*
ASSIGNMENT 9:
Using concepts of Object Oriented programming develop solution for any one application
1) Banking solution contains following operations such as 1. Create an account 2.Deposit
money 3.Withdraw money 4. Honor daily withdrawal limit 5. Check the balance 6.
Display Account information.
 */

import java.util.Scanner;
class Customer {
    private String CustomerName;
    private int CustomerAge;
    public void setCustomerName(String customerName){
        this.CustomerName=customerName;  //setting value of customerName
    }

    public String getCustomerName(){
        return CustomerName;   //returning value of customerName
    }

    public void setCustomerAge(int customerAge){
        this.CustomerAge=customerAge; //setting value of customerAge
    }

    public int getCustomerAge(){
        return CustomerAge;  //returning value of customerAge
    }

}
abstract class Account {
    protected double balance;
    protected int accountId;
    protected String accountType;
    protected Customer custobj;

    void setBalance(double balance){
        this.balance=balance;   //setting value of balance
    }

    double getBalance(){
        return balance;  //returning value of balance
    }

    void setAccountId(int accountId){
        this.accountId=accountId;
    }

    int getAccountId(){
        return accountId; //returning value of accountId
    }

    void setAccountType(String accountType){
        this.accountType=accountType;
    }

    String getAccountType(){
        return accountType;  //returning value of accountType
    }

    void setCustomerObject(Customer custobj){
        this.custobj=custobj;
    }
}

class SavingsAccount extends Account{
    //inheriting Account class in SavingAccount
    private double MinimumBalance;
    public void setMinimumBalance(double minimumBalance){
        this.MinimumBalance=minimumBalance;    //setting minimumBalance
    }

    public double getMinimumBalance(){
        return MinimumBalance;  //returning minimumBalance
    }

    public boolean withdraw(double amount){
        if((balance-amount)>MinimumBalance){
            //check whether withdraw amount is greater than minimumBalance
            balance-=amount;
            return true;
        }
        else
            return false; //returning false
    }
}

class Bank {
    public static Scanner sc=new Scanner(System.in);  //creating object of scanner class
    public SavingsAccount a=new SavingsAccount();    // creating object of SavingAccount class
    public Customer c=new Customer();         //creating object of Customer class

    public SavingsAccount createAccount(){

        System.out.print("Enter your name: ");
        String CustomerName=sc.nextLine();
        c.setCustomerName(CustomerName);

        System.out.print("Enter your age: ");
        int CustomerAge=sc.nextInt();
        if(CustomerAge<18){
            do{
                System.out.print("Minimum age should be 18 to create an account.\nPlease enter valid age: ");
                CustomerAge=sc.nextInt();
            }while(CustomerAge<18); //if age is less than 18
        }
        sc.nextLine();
        c.setCustomerAge(CustomerAge);

        a.setCustomerObject(c);

        System.out.print("Enter your account Id: ");
        int AccountId=sc.nextInt();
        sc.nextLine();
        a.setAccountId(AccountId);

        System.out.print("Enter your account type: ");
        String AccountType=sc.nextLine();
        a.setAccountType(AccountType);

        System.out.print("Enter balance: ");
        double balance=sc.nextDouble();
        a.setBalance(balance);

        System.out.print("Enter minimum balance: ");
        double MinBalance=sc.nextDouble();
        a.setMinimumBalance(MinBalance);

        sc.nextLine();

        return a;
    }

    void getWithdrawAmount(){     //method to withdraw amount
        System.out.print("Enter the amount you want to withdraw: ");
        double amount=sc.nextDouble();
        if(amount>20000){ //check whether amount is greater than 20000
            System.out.println("Withdrawal failed. Maximum limit of withdrawal in one transaction is Rs.20000.");
        }
        else{
            if(a.withdraw(amount)){ //calling withdraw method
                System.out.println("Withdrawal successful. Balance is: "+a.getBalance());
            }
            else
                System.out.println("Sorry!!! Not enough balance"); //if not enough balance
        }
    }

    public void depositAmount(double amount){
        double bal=a.getBalance()+amount;    //previous balance + amount
        a.setBalance(bal);
        System.out.println("Amount deposited successfully. Balance is: "+a.getBalance());
    }

    public void checkBalance(){
        System.out.println("Balance is: "+a.getBalance());
    }
    public void displayAccountInformation(){
        System.out.println("Welcome "+c.getCustomerName()+"! Following are your account details:");
        //display name of customer
        System.out.println("Age :"+c.getCustomerAge());
        System.out.println("Account Id: "+a.getAccountId());
        System.out.println("Account Type: "+a.getAccountType());
        System.out.println("Balance: "+a.getBalance());
        System.out.println("Minimum balance: "+a.getMinimumBalance());
    }
}

public class BankAccount{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SavingsAccount a=new SavingsAccount();
        Bank bm=new Bank();

        do{
            //menu driven program
            System.out.println("\t1.Create Account\n\t2.Display Account\n\t3.Check Balance"
                    + "\n\t4.Deposit Amount\n\t5.Withdraw Amount\n\t6.Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            System.out.println("");
            switch(choice)      //switch case
            {
                case 1:
                    a=bm.createAccount();    //calling createAccount method
                    System.out.println("--------------------------------------------------");
                    break;
                case 2:
                    bm.displayAccountInformation();  //calling displayAccountInformation method
                    System.out.println("--------------------------------------------------");
                    break;
                case 3:
                    bm.checkBalance();   //calling checkBalance method
                    System.out.println("--------------------------------------------------");
                    break;
                case 4:
                    System.out.print("Enter the amount you want to deposit: ");
                    double amount=sc.nextDouble();
                    bm.depositAmount(amount);       //calling depositAmount method
                    System.out.println("--------------------------------------------------");
                    break;
                case 5:
                    bm.getWithdrawAmount();          //calling getWithdrawAmount method
                    System.out.println("--------------------------------------------------");
                    break;
                case 6:
                    System.out.println("--------------------------------------------------");
                    return ; //stop execution of program
                default:
                    System.out.println("INVALID INPUT !!");//printing invalid input
                    System.out.println("--------------------------------------------------");
                    break;
            }

        }while(true);
    }
}

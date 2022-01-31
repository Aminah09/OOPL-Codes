/*
ASSIGNMENT 11:
Implement and apply Strategy Design pattern for simple Shopping Cart where three
payment strategies are used such as Credit Card, PayPal, Bit Coin. Create the interface for
strategy pattern and give concrete implementation for payment.
 */
import java.util.Scanner;

interface PaymentProcessor {

    void pay(int amount);//interface method pay

}

class CreditCard implements PaymentProcessor {
    Scanner sc =new Scanner (System.in);
    String name,ExpDate;
    double CardNo,cvv;

    //Constructor of CreditCard class
    CreditCard(){
        super();//calling parent class constructor
        System.out.println("----------------------------------------------------------");
        System.out.print("\tCard holder Name :: ");
        this.name =sc.nextLine();//taking cardholder Name as input from user
        System.out.print("\tCard Number :: ");
        this.CardNo =sc.nextDouble();//taking Card Number as input from user
        System.out.print("\tCard CVV Number :: ");
        this.cvv= sc.nextDouble();
        System.out.print("\tCard Expire Date :: ");
        this.ExpDate =sc.next();//taking Card Expire Date as input from user
        System.out.println("----------------------------------------------------------");
    }

    @Override
    public void pay(int amount) { 	//method for payment

        System.out.println("Paying through CreditCard : Charging $" + amount);
        System.out.println("----------------------------------------------------------");
    }

}

class PayPal implements PaymentProcessor {
    Scanner sc = new Scanner(System.in);
    String email,pass;

    //Constructor of PayPal class
    PayPal(){
        super();//calling parent class constructor
        System.out.print("Verify Email Id :: ");
        this.email=sc.next();
        System.out.print("Enter password :: ");
        this.pass=sc.next();
        System.out.println("\nChecking Internet Connection........");
    }

    @Override
    public void pay(int amount) { 	//method for payment
        System.out.println("----------------------------------------------------------");
        System.out.println("Paying through PayPal : Charging $" + amount);
        System.out.println("----------------------------------------------------------");
    }

}

class BitCoin implements PaymentProcessor {
    Scanner sc =new Scanner (System.in);
    String add,otp;

    //Constructor of BitCoin class
    BitCoin(){
        super();//calling parent class constructor
        System.out.print("\nEnter your Phone Number :: ");
        add= sc.next();
        System.out.print("Enter OTP :: ");
        otp=sc.next();

    }

    @Override
    public void pay(int amount) { 	//method for payment
        System.out.println("----------------------------------------------------------");
        System.out.println("Paying through BitCoin payment: Charging $" + amount);
        System.out.println("----------------------------------------------------------");
    }
}

class Order {

    private final PaymentProcessor paymentProcessor;
    private final int amount;

    //Order Method
    public Order(int amount, PaymentProcessor paymentProcessor) {
        this.amount = amount;//storing value
        this.paymentProcessor = paymentProcessor;//storing value
    }

    //process Method
    public void process() {
        paymentProcessor.pay(amount);//calling pay method
    }

}
public class Payment {
    public static void main(String[] args) {
        int c,amt=0;
        Order order;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println();
            System.out.println("**** SHOPPING CART ****");
            System.out.print("1.Credit Card \n2.Pay Pal \n3.Bit Coin \n4.Exit");
            System.out.print("\n\nEnter the Choice ::");
            c=sc.nextInt();
            System.out.println("----------------------------------------------------------");
            if(c==1||c==2||c==3) {//check whether 0<c<4
                System.out.print("\nEnter amount to be Transfer :: ");
                amt = sc.nextInt();
                System.out.println("----------------------------------------------------------");
            }
            //switch case
            switch(c) {
                case 1://for input c ==1
                    order = new Order(amt, new CreditCard());
                    order.process();
                    break;

                case 2://for input c == 2
                    order = new Order(amt, new PayPal());
                    order.process();
                    break;

                case 3://for input c == 3
                    order = new Order(amt, new BitCoin());
                    order.process();
                    break;

                case 4:
                    System.out.println("\nThank you For Shopping !!!! ");
                    System.out.println("----------------------------------------------------------");
                    return;//stop execution of program

                default:
                    System.out.println("Invalid Payment Mode !!!");// default
                    System.out.println("----------------------------------------------------------");
            }
        }
    }
}



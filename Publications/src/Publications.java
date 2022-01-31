import java.util.Scanner;

class Publication {
    private String title;
    private int copies, price,total;

    Scanner sc = new Scanner(System.in);

    public void setcopies(int copies) {
        //setter method for copies
        this.copies=copies;
    }
    public String gettitle() {
        //getter method for title
        return title;
    }
    public int getTotal() {
        //getter method for price
        return total;
    }
    public int getCopies() {
        //getter method for copies
        return copies;
    }

    void readPubl() {
        System.out.print("Enter title : ");
        title= sc.nextLine();
        System.out.print("Enter price : ");
        price = sc.nextInt();
        System.out.print("Enter copies : ");
        copies = sc.nextInt();
    }

    void display() {
        //display method for common data members of book and magazine class
        System.out.print(title+"\t\t"+price+"\t\t\t"+copies);
    }

    void saleCopy(int num) {
        //common method to sale book or magazine and generate bill
        if (num <= copies)
        //if customer needed copies are less than available
        {
            copies = copies-num;
            total = total +num*price;
            System.out.println("\tYou purchased "+num +" copies \n\tYou have to pay :  "+(price*num));
        }
        else
            System.out.println("     Insufficient Stock   !!!!   ");
    }
}
class Book extends Publication {
   private String author;

    void orderCopies(int num) {
        int x = getCopies()+num;
        setcopies(getCopies()+num);
        //as data members are private, we access them with the help of methods
        System.out.println("\n\tOrder Successful....");
        System.out.println("\tCopies Available : "+x);
    }
    void readBook() {
        readPubl();
        System.out.print("Enter author of book: ");
        author=sc.next();
    }
    void displayBook() {
        System.out.println("Title \t\tPrice \t\tCopy \t\tAuthor");
        display();//call to display defined in publication class
        System.out.println("\t\t"+author);
    }
}
class Magazine extends Publication {
    private String issueDate;

    void receiveIssue(String new_issueDate) {
        System.out.println("Enter new copies ordered : ");
        int orderQty = sc.nextInt();
        setcopies(orderQty);
        issueDate = new_issueDate;
        System.out.println("The magazine "+gettitle()+" with issue date "+issueDate+" is available.");
    }
    void readMag() {		//method to read or input magazine details
        readPubl();		//call to read method defined in publication class
        System.out.print("Enter the current issue date [dd/mm/yyyy]");
        issueDate=sc.next();
    }
    void displayMag() {
        System.out.println("Title\t \tPrice\t \tCopy \t\tDate");
        display();
        System.out.println("\t\t"+issueDate);
    }


}
public class Publications {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book();
        Magazine m1 = new Magazine();

        int menu;
        do {
            System.out.println("\nINDEX\n1.BOOK \t\t\t\t\t2.MAGAZINE"
                    + "\n3.TOTAL SALE AMOUNT");
            System.out.print("Choice::");
            int k=sc.nextInt();
            int a;
            aa:
            if(k==1) {
                do {
                    int c;
                    System.out.print("\nINDEX  FOR  BOOK\n");
                    System.out.print("1.Read Book \t\t2.Display \n3.Sale Copies \t\t4.Order Copies\n");
                    System.out.print("Choice::");
                    c=sc.nextInt();
                    switch (c){

                        case 1:
                            b1.readBook();
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 2:
                            b1.displayBook();
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 3:
                            System.out.print("How many copies you want (for customer) : ");
                            int n1=sc.nextInt();
                            b1.saleCopy(n1);
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 4:
                            System.out.print("Enter copies you want to order (for shop) : ");
                            int n2=sc.nextInt();
                            b1.orderCopies(n2);
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        default:
                            System.out.println("Invalid");
                    }
                    System.out.println("Do you want to continue with book section\n1.YES \t\t0.NO");
                    System.out.print("Choice::");
                    a=sc.nextInt();
                    if(a==0)
                        break aa;

                }while(a==1);
            }
            else if(k==2)
            {
                bb:
                do {
                    System.out.println("\nINDEX  FOR  MAGAZINE\n1.READ  \t\t\t\t2.DISPLAY \n3.SALE MAGAZINE COPIES \t4.RECEIVE NEW ISSUE");
                    int d;
                    System.out.print("Choice::");
                    d=sc.nextInt();
                    switch(d) {
                        case 1:
                            m1.readMag();
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 2:
                            m1.displayMag();
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 3:
                            System.out.println("How many copies you want (for customer) : ");
                            int n3=sc.nextInt();
                            m1.saleCopy(n3);
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                        case 4:
                            System.out.println("Enter the new issue date [dd/mm/yyyy]: ");
                            String date=sc.next();
                            m1.receiveIssue(date);
                            System.out.println("------------------------------------------------------------------------------\n");
                            break;
                    }
                    System.out.println("Do you want to continue with magazine section \n1.YES\t0.NO");
                    System.out.print("Choice::");
                    a=sc.nextInt();
                    if(a==0)
                        break bb;
                }while(a==1);
            }
            else if (k==3) {
                System.out.println("\nTotal sale amount to be paid by customer is  = "+(b1.getTotal()+m1.getTotal())+ "  ");
            }
            else
                System.out.println("Invalid  Key ");
                System.out.println("\nDo you want to continue with publication ? \n1.YES \t0.NO");
                menu=sc.nextInt();
        }while(menu!=0);
        sc.close();
    }
}


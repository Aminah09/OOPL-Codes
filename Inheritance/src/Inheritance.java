/*
ASSIGNMENT 3:
Design and develop inheritance for a given case study, identify objects and relationships
and implement inheritance wherever applicable. Employee class has Emp_name, Emp_id,
Address, Mail_id, and Mobile_no as members. Inherit the classes: Programmer, Team Lead,
Assistant Project Manager and Project Manager from employee class. Add Basic Pay (BP) as
the member of all the inherited classes . with 97% of BP as DA, 10 % of BP as HRA, 12% of
BP as PF, 0.1% of BP for staff club fund. Generate pay slips for the employees with their
gross and net salary
*/
import java.util.Scanner;

class Employee {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    String Emp_name,Mail_id,Address;
    int Emp_id;
    long Mobile_no;
    double Basic_pay;

    void input()
    {
        System.out.print("Enter the name of Employee: ");
        Emp_name=sc.nextLine();//input Employee name
        System.out.print("Enter Employee ID:  ");
        Emp_id=sc.nextInt();//input Employee ID
        System.out.print("Enter Address:  ");
        Address=sc.next();//input Employee address
        System.out.print("Enter Mobile No.:  ");
        Mobile_no=sc.nextLong();//input Employee mobile no.
        System.out.print("Enter Email ID: ");
        Mail_id=sc.next();
    }
    void display(){
        //display database for Employee
        System.out.println("****************************************************************");
        System.out.println("EMP NAME\t\tID\t \tADDRESS\t\tMOBILE\t\tEMAIL");
        System.out.println("****************************************************************");
        System.out.println(Emp_name+"\t"+Emp_id+"\t"+Address+"\t"+Mobile_no +"\t"+Mail_id+"\n");
    }

    void salary()
    {
        double DA,HRA,PF,CF,gross;
        DA=Basic_pay*97/100;
        HRA=Basic_pay*10/100;
        PF=Basic_pay*12/100;
        CF= (float) (Basic_pay*0.1/100);
        gross = Basic_pay + DA + HRA - PF - CF;
        System.out.println("HRA : "+HRA);
        System.out.println("PF : "+PF);
        System.out.println("Net Salary : " + Basic_pay);
        System.out.println("Gross Salary : " + gross);
        System.out.println();
    }
}
class Programmer extends Employee {
    void read_programmer() {
        //input data from user for Programmer
        input();
        boolean a=false;
        while(!a) {
            System.out.print("BASIC PAY[30000-40000]: ");
            Basic_pay=sc.nextDouble();
            if(Basic_pay>40000 || Basic_pay<30000) {
                //validation for basic_pay of Programmer
                System.out.println("SORRY!!! Basic Pay range for Programmer [30000 - 40000]  \nTRY AGAIN.....");
                a=false;
            }
            else
                a=true;
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
class TeamLead extends Employee {
    void read_teamlead() {
        //input data from user for teamlead
        input();
        boolean a=false;
        while(!a) {
            System.out.print("BASIC   PAY  [40000 - 50000] : ");
            Basic_pay=sc.nextDouble();
            if(Basic_pay>50000 || Basic_pay<40000) {
                //validation for basic pay of Teamlead
                System.out.println("SORRY!!! Basic Pay range for Teamlead [40000 - 50000] \nTRY AGAIN.....");
                a=false;
            }
            else
                a=true;
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
class AssistantProjectManager extends Employee {
    void read_Asst_pro_manager() {
        //input data from user for Asst_pro_manager
        input();
        boolean a=false;
        while(!a) {
            System.out.print("BASIC   PAY  [50000 - 60000] : ");
            Basic_pay=sc.nextDouble();
            if(Basic_pay>60000 || Basic_pay<50000) {
                //validation for basic pay of Asst_pro_manager
                System.out.println("SORRY!!! Basic Pay range for Assistant Project Manager [50000 - 60000] \nTRY AGAIN.....");
                a=false;
            }
            else
                a=true;
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
class ProjectManager extends Employee {
    void read_Pro_manager() {
        //input data from user for Pro_manager
        input();
        boolean a=false;
        while(!a) {
            System.out.print("BASIC   PAY  [60000 - 70000] : ");
            Basic_pay=sc.nextDouble();
            if(Basic_pay>70000 || Basic_pay<60000) {
                //validation for basic pay of pro_manager
                System.out.println("SORRY!!! Basic Pay range for Project Manager [60000 - 70000] \nTRY AGAIN.....");
                a=false;
            }
            else
                a=true;
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Programmer p1=new Programmer();

        TeamLead t=new TeamLead();

        AssistantProjectManager a=new AssistantProjectManager();

        ProjectManager p2=new ProjectManager();

        menu:
        do {
            //menu driven program
            System.out.println("\n1.PROGRAMMER \n2.TEAM LEAD \n3.ASSISTANT PROJECT MANAGER \n4.PROJECT MANAGER \n5.EXIT");
            System.out.print("Choice::");
            int k=sc.nextInt();//input choice from user
            int ch;
            switch(k) {

                case 1://if input from user is 1
                    do {
                        System.out.print("\tPROGRAMMER  INFO\n\t1. INPUT \n\t2. DISPLAY  \n\t3. EXIT \n\tChoice::");
                        ch = sc.nextInt();
                        //input choice from user
                        System.out.println("---------------------------------------------------------------------------------");
                        if (ch == 1)//if input from user is 1
                        {
                            p1.read_programmer();
                            //taking input for Programmer
                        } else if (ch == 2) {
                            p1.display();
                            p1.salary();
                            //printing salary of Programmer
                        }
                        System.out.println("---------------------------------------------------------------------------------");
                    }
                                while(ch!=3);
                    break;

                case 2://if input from user is 2
                    do {
                        System.out.print("\tTEAMLEAD  INFO\n\t1. INPUT \n\t2. DISPLAY  \n\t3. EXIT \n\tChoice::");
                        ch=sc.nextInt();
                        System.out.println("-------------------------------------------------------------------------------------------");
                        if(ch==1)
                        {
                                t.read_teamlead();
                                //taking input for teamlead
                            }
                        else if(ch==2 )
                        {
                                t.display();
                                t.salary();
                                //printing salary of teamlead
                        }
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }while(ch!=3);
                    break;

                case 3://if input from user is 3
                    do {
                        System.out.print("\tASSISTANT MANAGER INFO\n\t1. INPUT \n\t2. DISPLAY  \n\t3. EXIT \n\tChoice::");
                        ch=sc.nextInt();
                        System.out.println("-------------------------------------------------------------------------------------------");
                        if(ch==1)
                        {
                                a.read_Asst_pro_manager();
                                //taking input for Assistant Manager
                            }
                        else if(ch==2)
                        {
                                a.display();
                                //display database for Assistant Manager
                                a.salary();
                                //printing salary of Assistant Manager
                            }
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }while(ch!=3);
                    break;

                case 4://if input from user is 4
                    do {
                        System.out.print("\tPROJECT MANAGER INFO \n\t1. INPUT \n\t2. DISPLAY  \n\t3. EXIT \n\tChoice::");
                        ch=sc.nextInt();
                        System.out.println("-------------------------------------------------------------------------------------------");
                        if(ch==1)
                        {
                            p2.read_Pro_manager();
                            //taking input for Project Manager
                        }
                        else if(ch==2)
                        {
                            p2.display();
                            //display database for Project Manager
                            p2.salary();
                            //printing salary of Project Manager
                        }
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }while(ch!=3);
                    break;

                case 5://if input from user is 5
                    System.out.print("Would you like to Exit\n\t1.YES\n\t2.No\n\tChoice::");
                    int temp=sc.nextInt();
                    if(temp==1)//checking for breaking loop
                        break menu;//breaking menu bar

                default://default
                    System.out.println("   INVALID   ");
            }

        }while(true);
        sc.close();
    }
}

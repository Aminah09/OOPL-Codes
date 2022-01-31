/*
ASSIGNMENT 5:
Design and develop a context for given case study and implement an
interface for Vehicles Consider the example of vehicles like bicycle,
car and bike. All Vehicles have common functionalities such as Gear Change,
Speed up and apply breaks. Make an interface and put all these common functionalities.
Bicycle, Bike, Car classes should be implemented for all these functionalities in their
own class in their own way
 */

import java.util.Scanner;

interface Vehicles {
    void gearChange(int a);
    void speedUp();
    void applyBrakes();
    void display();
}
class Bicycle implements Vehicles {
    int gear, speed;
    Bicycle()
    {
        System.out.println("Bicycle started successfully");
        gear=1;         //gear is 1 when Cycle starts
        speed=10;		//speed is 10 when Cycle Starts

    }
    public void gearChange(int geared ) {
        if(geared<7 && geared>0)
        {
            gear=geared;
            System.out.println("Gear changed for bicycle is "+gear);
        }
        else
            System.out.println("Gear out of range");
    }

    public void speedUp() {
        if((speed+5)< 50) {
            speed+=5;
            System.out.println("Speed up for bicycle and speed is "+speed+" km/hr");
        }
        else
            System.out.println("Speed cannot be increased above 50 km/hr");
    }

    public void applyBrakes() {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("1. Decrease speed\n2. Stop bicycle\n");
        x= sc.nextInt();

        if(x==1)
            if((speed-5)>0)			// speed never be negative
            {
                speed-=5;			//per apply brakes bicycles speed is reduced by 5
                System.out.println("Applied brakes for bicycle \nCurrent speed is "+speed+" km/hr ");
            }
        if(x==2) {
                speed = 0;
                gear = 0;
                System.out.println("Bicycle stopped Successfully \n");
        }
    }

    public void display() {
        System.out.println("Bicycle's speed is "+speed+" km/hr and gear is "+gear);
    }
}

class Bike implements Vehicles {
    int gear, speed;
    Bike()
    {
        System.out.println("Bike started successfully");
        gear=1;		//initial gear when bike starts
        speed=10;	//initial speed of bike when starts
    }
    public void gearChange(int geared) {
        if(geared<6 && geared>0)		//maximum gears is 5
        {
            gear=geared;
            System.out.println("Gear changed for bike is "+gear);
        }
        else
            System.out.println("Gear out of range \n");
    }

    public void speedUp() {
        if((speed+20)<100) {
            speed += 20;
            System.out.println("Speed up for bike and speed is "+ speed +" km/hr");
        }
        else
            System.out.println("Speed cannot be increased above 100 km/hr \n");
    }

    public void applyBrakes() {
        Scanner sc=new Scanner(System.in);
        int x;
        System.out.println("1. Decrease speed \n2. Stop bike\n");
        x=sc.nextInt();
        if(x==1)
            if((speed-20)>0)	//checks speed is negative or positive if reduced by 20
            {
                speed-=20;			//per apply brakes vehicle speed is reduced by 20
                System.out.println("Applied brakes for bike \nCurrent speed is "+speed+ " km/hr" );
            }
        if(x==2)
            {
                speed=0;
                gear=0;
                System.out.println("Bike stopped successfully \n");
            }
    }

    public void display() {
        System.out.println("Bike's speed is "+speed+" km/hr and gear is "+gear);
    }
}

class Car implements Vehicles {
    int gear,speed;
    Car()
    {
        System.out.println("Car started successfully");
        gear=1;
        speed=10;
    }
    public void gearChange(int geared) {
        if(geared<7 && geared >0)	//maximum gear is 6
        {
            this.gear=geared;
            System.out.println("Gear changed for car \nCurrent Gear is "+gear);
        }
        else
            System.out.print(" Gear Out Of Range \n");
    }

    public void speedUp() {
        if ((speed+=20)<150) {
            speed += 20;
            System.out.println("Speed up for car\nCurrent speed is "+speed+" km/hr");
        }
        else
            System.out.println("Speed cannot be increased above 150 km/hr\n");
    }

    public void applyBrakes() {
        Scanner sc=new Scanner(System.in);
        int x;
        System.out.println("1. Decrease speed \n2. Stop car\n");
        x=sc.nextInt();
        if(x==1)
            if((speed-20)>0)		//checks speed is negative or positive if reduced by 20
            {
                speed-=20;			//per apply brakes vehicle speed is reduced by 20
                System.out.println("Applied brakes for car \nCurrent speed is "+speed+" km/hr");
            }
        if(x==2)
            {
                speed=0;
                gear=0;
                System.out.println("Car stopped Successfully\n ");
            }
    }

    public void display() {
        System.out.println("Car's speed is "+speed+" km/hr and gear is "+gear);
    }
}

public class Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicles v = null;
        int k;
        aa:
        do {

            System.out.print(" \n SELECT VEHICLE  \n\t1.BICYCLE \n\t2.CAR  \n\t3.BIKE \n\t4.Exit \nChoice::");
            k=sc.nextInt();
            System.out.println("----------------------------------------------------------------------");

            if(k==1)
                v=new Bicycle();	//object of bicycle class
            else if(k==2)
                v= new Car();		//object of car class
            else if(k==3)
                v=new Bike();		//object of bike class
            else if(k==4)
                break aa;			//label break
            else
                System.out.println("Invalid Input");
                System.out.println("----------------------------------------------------------------------");

            if(0<k&&k<4) {
                dd:		//label for inner do while loop
                do {
                    System.out.print(" \t1. Speed Up \n\t2. Change gear \n\t3. Apply Brakes  "
                            + "\n\t4. Display Vehicle Status \n\t5. Change Vehicle /Exit \nChoice::");
                    int z=sc.nextInt();
                    System.out.println("----------------------------------------------------------------------");
                    switch(z)
                    {
                        case 1:
                            v.speedUp();
                            System.out.println("----------------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.print("Which gear you want?   ");
                            int a=sc.nextInt();
                            v.gearChange(a);
                            System.out.println("----------------------------------------------------------------------");
                            break;
                        case 3:
                            v.applyBrakes();
                            System.out.println("----------------------------------------------------------------------");
                            break;
                        case 4:
                            v.display();
                            System.out.println("----------------------------------------------------------------------");
                            break;
                        case 5:
                            break dd;		//label break
                        default:
                            System.out.println("Invalid Input");
                    }
                }while(true);
            }
        }
        while(k!=4); //loop break when input y=4
    }
}





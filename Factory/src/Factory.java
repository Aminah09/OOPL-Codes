/*
ASSIGNMENT 10:
Design and implement Factory design pattern for the given context. Consider Car
building process, which requires many steps from allocating accessories to final makeup. These
steps should be written as methods and should be called while creating an instance of a specific
car type. Hatchback, Sedan, SUV could be the subclasses of Car class. Car class and its
subclasses, CarFactory and TestFactoryPattern should be implemented.
 */

import java.util.Scanner;
abstract class Car_Factory{

        String company,car_name;
        double budget;

        abstract void getprice(double price);
        abstract void detail(String company_name,String car_name);
        abstract void accessories();

        void input() {
            Scanner scan =new Scanner (System.in);
            System.out.print("Company : ");
            company=scan.nextLine();
            System.out.print("Car : ");
            car_name=scan.nextLine();
            System.out.print("Rough Budget(in Lakhs) : ");
            budget=scan.nextDouble();
        }
        void display(Car_Factory obj1) {

            obj1.getprice(budget);
            System.out.println("\n----------------------------------------");
            obj1.detail(company, car_name);
            System.out.println("\n----------------------------------------");
            obj1.accessories();
            System.out.println("\n----------------------------------------");
        }
    }

    class Small_car extends Car_Factory{
        String Ans;

        public void getprice(double price) {
            if(price>2&&price<5)
                Ans="No";	//modify Ans
            else
                Ans="Yes";	//modify Ans

        }

        public void detail(String company_name,String car_name) {
            System.out.println("Company : "+company_name);
            System.out.println("Name of Car : "+car_name);
            System.out.println("Color : Black/White/Orange/Red ");
            System.out.println("Fuel : Petrol");
            System.out.println("Gears: Manual");
        }

        //method to display accessories of car//
        public void accessories() {
            System.out.println("Types of Tyres- Alloy Wheels");
            System.out.println("Airbags : "+Ans);
            System.out.println("Back Wiper : "+Ans);
            System.out.println("Side Mirror : Two");
            System.out.println("Touch Screen Music Player : "+Ans);
        }
    }

    class Sedan extends Car_Factory{
        String Ans;

        public void getprice(double price) {
            if(price>6&&price<10)
                Ans="No";	//modify Ans
            else
                Ans="Yes";	//modify Ans
        }

        //method for displaying car detail//
        public void detail(String company_name,String car_name) {
            System.out.println("Company : "+company_name);
            System.out.println("Name of Car : "+car_name);
            System.out.println("Color : Black/White/Orange/Red");
            System.out.println("Fuel : Petrol/Diesel");
            System.out.println("Gears : Auto/Manual");
        }

        public void accessories() {
            System.out.println("Types of Tyres : Alloy Wheels");
            System.out.println("Airbags : YES");
            System.out.println("Back Wiper : YES");
            System.out.println("Side Mirror : Two");
            System.out.println("Touch Screen Music Player : YES");
            System.out.println("Roof Window- "+Ans);
        }
    }


    class Luxury extends Car_Factory{
        String Ans;


        public void getprice(double price) {
            if(price>10&&price<14)
                Ans="No";	//modify Ans
            else
                Ans="Yes";	//modify Ans
        }

        //method for displaying car detail//
        public void detail(String company_name,String car_name) {
            System.out.println("Company : "+company_name);
            System.out.println("Name of Car : "+car_name);
            System.out.println("Color : Black/White/Orange/Red");
            System.out.println("Fuel : Diesel");
            System.out.println("Gears : Auto");
        }


        public void accessories() {
            System.out.println("Types of Tyres : Alloy Wheels");
            System.out.println("Airbags : YES");
            System.out.println("Back Wiper : YES");
            System.out.println("Side Mirror : Two");
            System.out.println("Touch Screen Music Player : YES");
            System.out.println("Roof Window : YES");
            System.out.println("Automotive Garbage Cans : "+Ans);
            System.out.println("Automatic Air Freshener : "+Ans);
            System.out.println("Button Start : "+Ans);
        }
    }

    public class Factory {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner scan = new Scanner(System.in);
            int ch;
            //double price;
            Car_Factory obj;
            while(true){
                //menu driven
                System.out.println("Which Car you want to See ? ");
                System.out.println("\n\t1.Small Car\n\t2.Sedan Car\n\t3.Luxury Car\n\t4.Exit");
                ch=scan.nextInt();
                System.out.println();
                //switch case
                switch(ch) {

                    case 1:
                        obj= new Small_car();
                        obj.input();
                        obj.display(obj);
                        break;

                    case 2:
                        obj= new Sedan();
                        obj.input();
                        obj.display(obj);
                        break;

                    case 3:
                        obj= new Luxury();
                        obj.input();
                        obj.display(obj);
                        break;

                    case 4:
                        System.out.println("\n--------------------------------------");
                        return;//stop execution of program

                    default:
                        System.out.println("INVALID CHOICE !!");//default
                        System.out.println("\n--------------------------------------");
                        break;

                }
            }
        }
    }


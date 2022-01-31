/*
ASSIGNMENT 6:
Implement a program to handle Arithmetic exception, Array Index Out Of Bounds.
The user enters two numbers Num1 and Num2. The division of Num1 and Num2 is displayed.
If Num1 and Num2 were not integers, the program would throw a Number Format Exception. If
Num2 were zero, the program would throw an Arithmetic Exception. Display the exception.
 */

import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        int no1,no2;
        double result;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter First Number : ");
            no1 = Integer.parseInt(input.next());

            System.out.print("Enter Second Number : ");
            no2 = Integer.parseInt(input.next());

            result = no1/no2;
            System.out.println("The Division is : "+ result);

        }
        catch (ArithmeticException e) {
            System.out.println("Denominator is zero "+ e +"\nEnter Valid Denominator.... ");

        }
        catch (NumberFormatException e) {
            System.out.println("Input number is not an Integer "+ e +"\nEnter valid number.... ");
        }

    }
}

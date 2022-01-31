/*
ASSIGNMENT 4 :
design a base class shape with two double type values and member function to
input the data and compute area() for calculating area of shape. Derive two classes
Triangle and Rectangle make compute area() as abstract function and redefine this function
in the derive class to suit their requirement .Write a program that accepts the dimension
of Triangle /Rectangle and display calculated area. Implement dynamic binding.
*/
import java.util.Scanner;

abstract class Shape {
    double num1, num2;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st value : ");
        num1 = sc.nextDouble();
        System.out.print("Enter 2nd value : ");
        num2 = sc.nextDouble();
    }

    abstract void compute_area() ;

    }

    class Triangle extends Shape {
        void compute_area() {
            double area;
            area = 1.0/2.0 * num1 * num2;
            System.out.println("Area of triangle is "+ area);
            System.out.println();
        }
    }

    class Rectangle extends Shape {
        void compute_area() {
            double area;
            area = num1 * num2;
            System.out.println("Area of rectangle is "+ area);
        }


    public static class Dynamic {
        public static void main(String[] args) {
            Shape s;
            Triangle t = new Triangle();
            Rectangle r = new Rectangle();
            s = t;
            System.out.println("\nInput for triangle");
            s.input();
            s.compute_area();

            s = r;
            System.out.println("Input for rectangle");
            s.input();
            s.compute_area();

        }
    }
}

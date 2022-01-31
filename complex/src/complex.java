/*
ASSIGNMENT 1 :
Design a class ‘Complex ‘with data members for real and imaginary part.
Provide default and Parameterized constructors. Write a program to perform
arithmetic operations of two complex numbers.
*/
public class complex {

    private float real;
    private float imag;

    complex() // default constructor
    {
        System.out.print("In default constructor ");

        this.real=0;
        this.imag=0;
    }

    complex(int a, int b) //parameterized constructor
    {
        this.real=a;
        this.imag=b;
    }

    void display()
    {
        System.out.println("("+this.real+") + i("+this.imag+")");

    }

    void add(complex c3)
    {
        System.out.println( ("Addition is : (") + (real+c3.real) + ") + i(" + (c3.imag+imag)+")");
    }

    void sub(complex c3)
    {
        System.out.println( ("Subtraction is : (") + (real-c3.real) + ") + i(" + (imag-c3.imag)+")");
    }

    void mult(complex c3)
    {
        System.out.println(("Multiplication is : (") + (real * c3.real - (c3.imag * imag)) + ") + i(" + (imag * c3.real + (real * c3.imag)) + ")");
    }

    void div(complex c3)
    {
        float demo = (c3.real * c3.real + c3.imag * c3.imag);
        System.out.println( ("Division is : (") +(real*c3.real+(c3.imag*imag))/demo + ") + i(" + (imag*c3.real-real*c3.imag)/demo +")");
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        complex c1=new complex();
        c1.display();
        c1.real=7;
        c1.imag=4;
        c1.display();
        complex c2=new complex(5,2);

        c2.display();
        c1.add(c2);
        c1.sub(c2);
        c1.mult(c2);
        c1.div(c2);

    }

}








/*
ASSIGNMENT 8:
Implement a program for maintaining a student records database using File Handling.
Student has Student_id, name, Roll_no, Class, marks and address. Display the data for five
students.
i) Create Database
ii)Display Database
iii) Clear Records
iv)Modify record
v)Search Record
 */

import java.io.*;
import java.io.File;
import java.util.*;
public class Students {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void addRecords() throws IOException
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sample.txt",true)));
        String name, address,Class;
        int id, rollno;
        float marks;
        String s;
        boolean addMore = false;
        do
        {
            System.out.print("Student Id: ");
            id = Integer.parseInt(br.readLine());
            System.out.print("Enter Student Name: ");
            name = br.readLine();
            System.out.print("Roll no: ");
            rollno = Integer.parseInt(br.readLine());
            System.out.print("Class: ");
            Class = br.readLine();
            System.out.print("Marks : ");
            marks = Float.parseFloat(br.readLine());
            System.out.print("Address: ");
            address = br.readLine();
            pw.println(name+" "+id+"   "+rollno+"   "+address+"    "+Class+"   "+marks);
            System.out.print("\nRecords added successfully !\nDo you want to add more records ? (y/n) : ");
            s = br.readLine();
            if(s.equalsIgnoreCase("y"))
            {
                addMore = true;
                System.out.println();
            }
            else
                addMore = false;
        }
        while(addMore);
        pw.close();
        showMenu();
    }
    public void displayRecords() throws IOException
    {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader("sample.txt"));
            String name;
            int i=1;
            System.out.println("----------------------------------------------------");
            System.out.println("NAME\t ID\t\t ROLL NO\t ADDRESS\t CLASS\t MARKS\t");
            while((name = file.readLine()) != null)
            {
                System.out.println(name);
                System.out.println("");
            }
            file.close();
            showMenu();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR : File not Found !!!");
        }
    }
    public void searchRecords() throws IOException
    {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader("sample.txt"));
            String name;
            int flag=0;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter an id of the student you want to search: ");
            String searchname=sc.next();
            while((name = file.readLine()) != null)
            {
                String[] line = name.split(" ");
                if(searchname.equalsIgnoreCase(line[1])){
                    System.out.println("Record found");
                    System.out.println(name);
                    System.out.println("");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("Record not found");
            file.close();
            showMenu();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR : File not Found !!!");
        }
    }
    public void deleteRecords() throws IOException
    {
        try
        {
            BufferedReader file1 = new BufferedReader(new FileReader("sample.txt")); PrintWriter pw
                = new PrintWriter(new BufferedWriter(new FileWriter("new.txt",true))); String name;
            int flag=0;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the name of the student you want to delete: ");
            String searchname=sc.next();
            while((name = file1.readLine()) != null)
            {
                String[] line = name.split(" ");
                if(!searchname.equalsIgnoreCase(line[0]))
                {
                    pw.println(name);
                    flag=0;
                }
                else
                {
                    System.out.println("Record found");
                    flag=1;
                }
            }
            file1.close();
            pw.close();
            File delName = new File("sample.txt");
            File oldName = new File("new.txt");
            File newName = new File("sample.txt");
            if(delName.delete())
                System.out.println("Deleted successfully");
            else
                System.out.println("Error");
            if (oldName.renameTo(newName))
                System.out.println("Renamed successfully");
            else
                System.out.println("Error");
            showMenu();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR : File not Found !!!");
        }
    }
    public void updateRecords() throws IOException
    {
        try
        {
            BufferedReader file1 = new BufferedReader(new FileReader("sample.txt")); PrintWriter pw
                = new PrintWriter(new BufferedWriter(new FileWriter("new.txt",true))); String name;
            int flag=0;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the name of the student you want to update: ");
            String searchname=sc.next();
            while((name = file1.readLine()) != null)
            {
                String[] line = name.split(" ");
                if(!searchname.equalsIgnoreCase(line[0])){
                    pw.println(name);
                    flag=0;
                }
                else
                {
                    System.out.println("Record found");
                    System.out.print("Enter updated marks:");
                    String up_mark=sc.next();
                    pw.println(line[0]+" "+line[1]+" "+line[2]+" "+line[3]+" "+line[4]+" "+up_mark);
                    flag=1;
                }
            }
            file1.close();
            pw.close();
            File delName = new File("sample.txt");
            File oldName = new File("new.txt");
            File newName = new File("sample.txt");
            if(delName.delete())
                System.out.println("Record updated successfully");
            else
                System.out.println("Error");
            if (oldName.renameTo(newName))
                System.out.println("Renamed successfully");
            else
                System.out.println("Error");
            showMenu();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR : File not Found !!!");
        }
    }
    public void clear(String filename) throws IOException
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        pw.close();
        System.out.println("\nAll Records cleared successfully !");
        for(int i=0;i<999999999;i++);
        showMenu();
    }
    public void showMenu() throws IOException
    {
        //System.out.println("\n** Student Database Management **");
        System.out.print("\n1. Create Records\n2. Display Records\n3. Delete Records \n4. Clear All Records\n5. Update Records \n6. Search Records \n7. Exit\n\nEnter your choice : "); int
        choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
            case 1:
                addRecords();
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 2:
                displayRecords();
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 3:
                deleteRecords();
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 4:
                clear("sample.txt");
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 5:
                updateRecords();
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 6:
                searchRecords();
                System.out.println("\n----------------------------------------------------\n");
                break;
            case 7:
                System.out.println("\n----------------------------------------------------\n");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid Choice !");
                System.out.println("\n----------------------------------------------------\n");
                break;
        }
    }
    public static void main(String args[]) throws
            IOException {
        Students s1 = new Students ();
        s1.showMenu();
    }
}
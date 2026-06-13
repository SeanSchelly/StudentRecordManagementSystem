import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Student Record Portal");
        System.out.println("-------------------------------");
        System.out.println("Instantiating objects(4)...");
        //
        Student s1 = new Student (0, "name", "dept", 0.0);
        Student s2 = new Student (0, "name", "dept", 0.0);
        Student s3 = new Student (0, "name", "dept", 0.0);
        Student s4 = new Student (0, "name", "dept", 0.0);
        //
        System.out.println("Objects instantiated.");
        System.out.println("Checking for Student folder...");
        File studentsFolder = new File("Students Folder");
        if (!(studentsFolder.exists())) {
            Scanner input1 = new Scanner(System.in);
            System.out.println("No folder detected, shall we add one for you?(yes/no)");
            String ans1 = input1.nextLine();
            if(ans1.equals("yes")) {
                System.out.println("Creating student record folder...");
                studentsFolder.mkdir();
                System.out.println("Folder created. Restart program to proceed with record creation or file details display.");
            } else {
                System.out.println("Can't continue without folder to store data, program finished.");
            }
        } else {
            System.out.println("Folder detected. Would you like to know file data(1) or continue(2) with record creation? (1/2)");
            Scanner input2 = new Scanner(System.in);
            int ans = input2.nextInt();
            switch(ans) {
                case 1:
                    System.out.println("Folder details: ");
                    System.out.println("-------------------------------");
                    System.out.println("Name: "+studentsFolder.getName());
                    System.out.println("Path: "+studentsFolder.getPath());
                    System.out.println("Size: "+studentsFolder.length());
                    //TODO: Make last modified in date/time format
                    System.out.println("Last Modified(Date): "+studentsFolder.lastModified());
                    break;
                case 2:
                    System.out.println("Record creation: ");
                    System.out.println("-------------------------------");
                    System.out.println("Initializing fileOut object...");
                        try(PrintWriter fileOut = new PrintWriter("Students Folder\\StudentsFile.txt")) {
                            System.out.println("Done. Proceeding...");
                            System.out.println("-------------------------------");
                            //
                            System.out.println("Student 1: ");
                            s1.setID(1);
                            System.out.println("ID:");
                            fileOut.print(s1.getID()+" ");
                            System.out.println("ID set.(preset)");
                            //
                            //
                            System.out.println("Name: ");
                            Scanner input_1 = new Scanner(System.in);
                            String ans1 = input_1.nextLine();
                            s1.setName(ans1);
                            fileOut.print(s1.getName()+" ");
                            System.out.println("Name set.");
                            //
                            //
                            System.out.println("Department: ");
                            Scanner input_2 = new Scanner(System.in);
                            String ans2 = input_2.nextLine();
                            s1.setName(ans2);
                            fileOut.print(s1.getDept()+" ");
                            System.out.println("Department set.");
                            //
                            //
                            System.out.println("GPA: ");
                            Scanner input_3 = new Scanner(System.in);
                            double ans3 = input_1.nextDouble();
                            s1.setGpa(ans3);
                            fileOut.print(s1.getGpa());
                            System.out.println("GPA set.");
                            fileOut.println();
                            System.out.println("-------------------------------");
                            //
                            //Student 2
                            System.out.println("Student 2: ");
                            s2.setID(2);
                            System.out.println("ID:");
                            fileOut.print(s2.getID()+" ");
                            System.out.println("ID set.(preset)");
                            //
                            //
                            System.out.println("Name: ");
                            Scanner input_12 = new Scanner(System.in);
                            String ans12 = input_12.nextLine();
                            s2.setName(ans12);
                            fileOut.print(s2.getName()+" ");
                            System.out.println("Name set.");
                            //
                            //
                            System.out.println("Department: ");
                            Scanner input_21 = new Scanner(System.in);
                            String ans21 = input_21.nextLine();
                            s2.setName(ans21);
                            fileOut.print(s2.getDept()+" ");
                            System.out.println("Department set.");
                            //
                            //
                            System.out.println("GPA: ");
                            Scanner input_31 = new Scanner(System.in);
                            double ans31 = input_31.nextDouble();
                            s2.setGpa(ans31);
                            fileOut.print(s2.getGpa());
                            System.out.println("GPA set.");
                            fileOut.println();
                            System.out.println("-------------------------------");
                            //
                            //Student 3
                            System.out.println("Student 3: ");
                            s3.setID(3);
                            System.out.println("ID:");
                            fileOut.print(s3.getID()+" ");
                            System.out.println("ID set.(preset)");
                            //
                            //
                            System.out.println("Name: ");
                            Scanner input_13 = new Scanner(System.in);
                            String ans13 = input_13.nextLine();
                            s3.setName(ans13);
                            fileOut.print(s3.getName()+" ");
                            System.out.println("Name set.");
                            //
                            //
                            System.out.println("Department: ");
                            Scanner input_22 = new Scanner(System.in);
                            String ans22 = input_22.nextLine();
                            s3.setName(ans22);
                            fileOut.print(s3.getDept()+" ");
                            System.out.println("Department set.");
                            //
                            System.out.println("GPA: ");
                            Scanner input_32 = new Scanner(System.in);
                            double ans32 = input_32.nextDouble();
                            s2.setGpa(ans32);
                            fileOut.print(s2.getGpa());
                            System.out.println("GPA set.");
                            fileOut.println();
                            System.out.println("-------------------------------");
                            //
                            //Student 4
                            System.out.println("Student 4: ");
                            s4.setID(4);
                            System.out.println("ID:");
                            fileOut.print(s4.getID()+" ");
                            System.out.println("ID set.(preset)");
                            //
                            //
                            System.out.println("Name: ");
                            Scanner input_14 = new Scanner(System.in);
                            String ans14 = input_14.nextLine();
                            s4.setName(ans14);
                            fileOut.print(s4.getName()+" ");
                            System.out.println("Name set.");
                            //
                            //
                            System.out.println("Department: ");
                            Scanner input_23 = new Scanner(System.in);
                            String ans23 = input_23.nextLine();
                            s4.setName(ans23);
                            fileOut.print(s4.getDept()+" ");
                            System.out.println("Department set.");
                            //
                            //
                            System.out.println("GPA: ");
                            Scanner input_33 = new Scanner(System.in);
                            double ans33 = input_33.nextDouble();
                            s4.setGpa(ans33);
                            fileOut.print(s4.getGpa());
                            System.out.println("GPA set.");
                            fileOut.println();
                            System.out.println("-------------------------------");
                            //

                            break;
                    } catch(IOException e) {
                        e.printStackTrace();
                }

                default:
                    System.out.println("Err: Invalid Option. Rerun Program.");

            }
        }
    }
}

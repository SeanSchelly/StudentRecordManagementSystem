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
        Student s5 = new Student (0, "name", "dept", 0.0);
        //Global students array
        Student[] studentsArray = {s1, s2, s3, s4};
        //
        System.out.println("Objects instantiated.");
        System.out.println("Checking for Student folder...");
        File studentsFolder = new File("Students Folder");
        //global scanner
        Scanner input = new Scanner(System.in);
        if (!(studentsFolder.exists())) {

            System.out.println("No folder detected, shall we add one for you?(yes/no)");
            String ans1 = input.nextLine();
            if(ans1.equals("yes")) {
                System.out.println("Creating student record folder...");
                studentsFolder.mkdir();
                System.out.println("Folder created. Restart program to proceed with record creation.");
            } else {
                System.out.println("Can't continue without folder to store data, program finished.");
            }
        } else {
            System.out.println("Folder detected. Would you like to continue with record creation? (yes/no)");
            String ans2 = input.nextLine();
            switch(ans2) {
                case "no":
                    System.out.println("Exiting...");
                    break;
                case "yes":
                    System.out.println("Record creation: ");
                    System.out.println("-------------------------------");
                    System.out.println("Creating files...");
                    try(PrintWriter fileOut1 = new PrintWriter("Students Folder\\StudentsFile1.txt");
                        PrintWriter fileOut2 = new PrintWriter("Students Folder\\StudentsFile2.txt");
                        PrintWriter fileOut3 = new PrintWriter("Students Folder\\StudentsFile3.txt");
                        PrintWriter fileOut4 = new PrintWriter("Students Folder\\StudentsFile4.txt")) {

                        PrintWriter[] files = {fileOut1, fileOut2, fileOut3, fileOut4};
                        System.out.println("Done.");
                        System.out.println("-------------------------------");

                        //student inputs
                        System.out.println("ID: ");
                        for(int i=0; i<studentsArray.length; i++) {
                            studentsArray[i].setID(i+1);
                        }
                        System.out.println("ID set(preset)");
                        System.out.println("-------------------------------");
                        //
                        System.out.println("Name: ");
                        for(int i=0; i<studentsArray.length; i++) {
                            String name = input.nextLine();
                            studentsArray[i].setName(name);
                        }
                        System.out.println("Name set.");
                        System.out.println("-------------------------------");
                        //
                        System.out.println("Department: ");
                        for(int i=0; i<studentsArray.length; i++) {
                            String dept = input.nextLine();
                            studentsArray[i].setDept(dept);
                        }
                        //
                        System.out.println("Department set.");
                        System.out.println("-------------------------------");
                        System.out.println("GPA: ");
                        for(int i=0; i<studentsArray.length; i++) {
                            double gpa = input.nextDouble();
                            studentsArray[i].setGpa(gpa);
                        }
                        //
                        System.out.println("GPA set.");
                        System.out.println("-------------------------------");
                        System.out.println("Adding entries to files... ");
                        System.out.println("-------------------------------");
                        for(int i=0; i<studentsArray.length; i++) {
                            files[i].println(studentsArray[i].getID()+" "+studentsArray[i].getName()+" "+studentsArray[i].getDept()+" "+studentsArray[i].getGpa());
                        }
                        //
                        System.out.println("-------------------------------");
                        System.out.println("Closing streams...");
                        //
                        fileOut1.close();
                        fileOut2.close();
                        fileOut3.close();
                        fileOut4.close();
                        //
                        System.out.println("-------------------------------");
                        System.out.println("Done.");
                        System.out.println("-------------------------------");
                        System.out.println("Your students are recorded successfully. What would you like to do now?");
                        System.out.println("1. Add Student");
                        System.out.println("2. Delete Student");
                        System.out.println("3. Search Student By ID");
                        System.out.println("4. Display All Students");
                        //
                        int actionChoice = input.nextInt();
                        switch(actionChoice) {
                            case 1:
                                System.out.println("-------------------------------");
                                System.out.println("Initializing new student array...");
                                System.out.println("-------------------------------");

                                //New student array
                                studentsArray = new Student[]{s1, s2, s3, s4, s5};
                                //
                                System.out.println("Done. Adding student to new file...");
                                try(PrintWriter fileOut5 = new PrintWriter("Students Folder\\StudentsFile5.txt")) {
                                    System.out.println("ID: ");
                                    studentsArray[4].setID(5);
                                    System.out.println("ID set. (preset)");
                                    //
                                    String nameNew = input.nextLine(); // consumes escape sequence, from previous int input, that is blocking buffer memory to allow name input
                                    System.out.println("Name: ");
                                    nameNew = input.nextLine();
                                    s5.setName(nameNew);
                                    System.out.println("Name set.");
                                    //
                                    System.out.println("Department: ");
                                    String deptNew = input.nextLine();
                                    studentsArray[4].setDept(deptNew);
                                    System.out.println("Department set.");
                                    //
                                    System.out.println("GPA: ");
                                    double gpaNew = input.nextDouble();
                                    studentsArray[4].setGpa(gpaNew);
                                    System.out.println("GPA set.");

                                    fileOut5.println(studentsArray[4].getID()+" "+studentsArray[4].getName()+" "+studentsArray[4].getDept()+" "+studentsArray[4].getGpa());
                                    System.out.println("Done.");
                                } catch(IOException e){
                                    e.printStackTrace();
                                }
                                break;

                            case 2:
                                System.out.println("Which record do you want removed?(Enter ID -> between 1 & 4)(Any new record must be deleted separately.)");
                                int idDel = input.nextInt();
                                if(idDel == 1) {
                                    System.out.println("Removing ID 1's file...");
                                    File fileDel1 = new File("Students Folder\\StudentsFile1.txt");
                                    fileDel1.delete();
                                    System.out.println("Done.");
                                } else if(idDel == 2) {
                                    System.out.println("Removing ID 2's file...");
                                    File fileDel2 = new File("Students Folder\\StudentsFile2.txt");
                                    fileDel2.delete();
                                    System.out.println("Done.");
                                } else if(idDel == 3) {
                                    System.out.println("Removing ID 3's file...");
                                    File fileDel3 = new File("Students Folder\\StudentsFile3.txt");
                                    fileDel3.delete();
                                    System.out.println("Done.");
                                } else if(idDel == 4) {
                                    System.out.println("Removing ID 4's file...");
                                    File fileDel4 = new File("Students Folder\\StudentsFile4.txt");
                                    fileDel4.delete();
                                    System.out.println("Done.");
                                } else if(idDel == 5) {
                                    System.out.println("Removing ID 5's file...");
                                    File fileDel5 = new File("Students Folder\\StudentsFile5.txt");
                                    fileDel5.delete();
                                    System.out.println("Done.");
                                }
                                break;

                            case 3:
                                System.out.println("Which record are you looking for? (Enter ID -> between 1 & 5)");
                                int idSearch = input.nextInt();
                                switch(idSearch) {
                                    case 1:
                                        try(Scanner fileIn1 = new Scanner(new File("Students Folder\\StudentsFile1.txt"))) {
                                            //Checks if StudentsFile1 has a line, and prints accordingly
                                            while(fileIn1.hasNextLine()) {
                                                System.out.println(fileIn1.nextLine());
                                            }
                                        } catch(IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case 2:
                                        try(Scanner fileIn2 = new Scanner(new File("Students Folder\\StudentsFile2.txt"))) {
                                            while(fileIn2.hasNextLine()) {
                                                System.out.println(fileIn2.nextLine());
                                            }
                                        } catch(IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case 3:
                                        try(Scanner fileIn3 = new Scanner(new File("Students Folder\\StudentsFile3.txt"))) {
                                            while(fileIn3.hasNextLine()) {
                                                System.out.println(fileIn3.nextLine());
                                            }
                                        } catch(IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case 4:
                                        try(Scanner fileIn4 = new Scanner(new File("Students Folder\\StudentsFile4.txt"))) {
                                            while(fileIn4.hasNextLine()) {
                                                System.out.println(fileIn4.nextLine());
                                            }
                                        } catch(IOException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case 5:
                                        try(Scanner fileIn5 = new Scanner(new File("Students Folder\\StudentsFile5.txt"))) {
                                            while(fileIn5.hasNextLine()) {
                                                System.out.println(fileIn5.nextLine());
                                            }
                                        } catch(IOException e) {
                                           e.printStackTrace();
                                        }
                                        break;

                                    default:
                                        System.out.println("Err: invalid entry. ");
                                }
                                break;

                            case 4:
                                System.out.println("All Students: ");
                                System.out.println("-------------------------------");
                                try(Scanner fileDisplay1 = new Scanner(new File("Students Folder\\StudentsFile1.txt"))) {
                                    while(fileDisplay1.hasNextLine()) {
                                        System.out.println(fileDisplay1.nextLine());;
                                    }
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                try(Scanner fileDisplay2 = new Scanner(new File("Students Folder\\StudentsFile2.txt"))) {
                                    while(fileDisplay2.hasNextLine()) {
                                        System.out.println(fileDisplay2.nextLine());;
                                    }
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                try(Scanner fileDisplay3 = new Scanner(new File("Students Folder\\StudentsFile3.txt"))) {
                                    while(fileDisplay3.hasNextLine()) {
                                        System.out.println(fileDisplay3.nextLine());;
                                    }
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                try(Scanner fileDisplay4 = new Scanner(new File("Students Folder\\StudentsFile4.txt"))) {
                                    while(fileDisplay4.hasNextLine()) {
                                        System.out.println(fileDisplay4.nextLine());
                                    }
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                try(Scanner fileDisplay5 = new Scanner(new File("Students Folder\\StudentsFile5.txt"))) {
                                    while(fileDisplay5.hasNextLine()) {
                                        System.out.println(fileDisplay5.nextLine());
                                    }
                                } catch(IOException e) {
                                    System.out.println("Err: File not found for ID.5. (New student was not added).");
                                    e.printStackTrace();
                                }
                                System.out.println("-------------------------------");
                                break;
                        }

                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Err: Invalid Option. Rerun Program.");
            }
        }
    }
}

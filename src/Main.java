//imports
import java.io.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//
//Main program

public class Main {
    public static void main(String[] args) {
        System.out.println("Student Record Portal");
        System.out.println("-------------------------------");
        System.out.println("Instantiating objects(4)...");

        //Global student objects
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
        //
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
                        //
                        System.out.println("Closing streams...");
                        fileOut1.close();
                        fileOut2.close();
                        fileOut3.close();
                        fileOut4.close();
                        System.out.println("Done.");
                        //
                        //Supported Operations
                        System.out.println("-------------------------------");
                        System.out.println("Your students are recorded successfully. What would you like to do now?");
                        System.out.println("1. Add Student");
                        System.out.println("2. Delete Student");
                        System.out.println("3. Search Student By ID");
                        System.out.println("4. Display All Students");
                        System.out.println("5. Update a student record");
                        System.out.println("6. Generate report");
                        System.out.println("7. Display file properties");
                        System.out.println("8. Serialize student records for object transfer");
                        System.out.println("9. Backup student records");
                        System.out.println("10. Generate logo for current batch");
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

                            //Uses delete method from File class to remove unwanted records upon user request
                            case 2:
                                System.out.println("Which record do you want removed?(Enter ID -> between 1 & 4)(Any new record must be deleted manually.)");
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
                                //All Students display using scanner to read student data into the program
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

                            case 5:
                                //Updates student information by using the delete() method from File class and creating a new file in its place
                                System.out.println("Which student's record do you want to overwrite?");
                                System.out.println("| 0 | 1 | 2 | 3 | "+" N.B -> to pick the first record, enter zero. To pick the second record, enter 1, etc.");
                                int updateSel = input.nextInt();
                                //
                                System.out.println("ID: (Unchanged)");
                                //
                                String nameUpdate = input.nextLine(); // consumes escape sequence, from previous int input, that is blocking buffer memory to allow name input
                                System.out.println("Name: ");
                                nameUpdate = input.nextLine();
                                studentsArray[updateSel].setName(nameUpdate);
                                System.out.println("Recorded.");
                                //
                                System.out.println("Department: ");
                                String deptUpdate = input.nextLine();
                                studentsArray[updateSel].setDept(deptUpdate);
                                System.out.println("Recorded.");
                                //
                                System.out.println("GPA:");
                                double gpaUpdate = input.nextDouble();
                                studentsArray[updateSel].setGpa(gpaUpdate);
                                //
                                System.out.println("Initializing old file deletion...");
                                File delFile1 = new File("Students Folder\\StudentsFile1.txt");
                                File delFile2 = new File("Students Folder\\StudentsFile2.txt");
                                File delFile3 = new File("Students Folder\\StudentsFile3.txt");
                                File delFile4 = new File("Students Folder\\StudentsFile4.txt");
                                File[] filesForDeletion = {delFile1, delFile2, delFile3, delFile4};
                                filesForDeletion[updateSel].delete();
                                //
                                System.out.println("Done. Writing changes...");
                                try(PrintWriter fileOutNew = new PrintWriter("Students Folder\\(UPDATED)StudentsFile"+(updateSel+1)+".txt");) {
                                    fileOutNew.println(studentsArray[updateSel].getID()+" "+studentsArray[updateSel].getName()+" "+studentsArray[updateSel].getDept()+" "+studentsArray[updateSel].getGpa());
                                    System.out.println("Done. To see the updated record, check the folder for the new file.");
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case 6:
                                //Simply uses assigned values from created objects to generate a final report
                                System.out.println("Set up is complete. We'll generate a report now.");
                                //
                                System.out.println("Finding total students...");
                                int totStudents = studentsArray.length;
                                //
                                System.out.println("Finding highest GPA...");
                                double gpa1 = s1.getGpa();
                                double gpa2 = s2.getGpa();
                                double gpa3 = s3.getGpa();
                                double gpa4 = s4.getGpa();
                                //GPA array
                                double[] gpaArray ={gpa1, gpa2, gpa3, gpa4};

                                //Enhanced for loop used for easy looping, to find the minimum and maximum gpa values from array
                                double maxVal = gpaArray[0];
                                double minVal = gpaArray[0];
                                for(double gpa : gpaArray) {
                                    if(gpa > maxVal) {
                                        maxVal = gpa;
                                    }
                                    if(gpa < minVal) {
                                        minVal = gpa;
                                    }
                                }

                                //Simple average calculation
                                System.out.println("Finding Average GPA...");
                                double avgGpa =(gpaArray[0]+gpaArray[1]+gpaArray[2]+gpaArray[3])/gpaArray.length;
                                //
                                //PrintWriter used to write the statistics to a new file.
                                try(PrintWriter finalReport = new PrintWriter("Students Folder\\REPORT.txt")){
                                    finalReport.println("FINAL REPORT");
                                    finalReport.println("Total Students: "+totStudents);
                                    finalReport.println("Highest GPA: "+maxVal);
                                    finalReport.println("Lowest GPA: "+minVal);
                                    finalReport.println("Average GPA: "+avgGpa);
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 7:
                                //Using File Class to display file properties depending on which file exists (updated or old)
                                System.out.println("Properties of all recorded Files(files must be created first): ");
                                File file_display1 = new File("Students Folder\\StudentsFile1.txt");
                                File file_display2 = new File("Students Folder\\StudentsFile2.txt");
                                File file_display3 = new File("Students Folder\\StudentsFile3.txt");
                                File file_display4 = new File("Students Folder\\StudentsFile4.txt");

                                if(file_display1.exists()) {
                                    System.out.println("Student 1 File:");
                                    System.out.println("Name: "+file_display1.getName());
                                    System.out.println("Path: "+file_display1.getPath());
                                    System.out.println("Size: "+file_display1.length());
                                    SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                                    System.out.println("Last Modified Date: "+sd.format(file_display1.lastModified()));
                                } else{
                                    System.out.println("Err: File for student 1 does not exist.");
                                }

                                if(file_display2.exists()) {
                                    System.out.println("Student 2 File:");
                                    System.out.println("Name: "+file_display2.getName());
                                    System.out.println("Path: "+file_display2.getPath());
                                    System.out.println("Size: "+file_display2.length());
                                    SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                                    System.out.println("Last Modified Date: "+sd.format(file_display2.lastModified()));
                                } else{
                                    System.out.println("Err: File for student 1 does not exist.");
                                }

                                if(file_display3.exists()) {
                                    System.out.println("Student 3 File:");
                                    System.out.println("Name: "+file_display3.getName());
                                    System.out.println("Path: "+file_display3.getPath());
                                    System.out.println("Size: "+file_display3.length());
                                    SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                                    System.out.println("Last Modified Date: "+sd.format(file_display3.lastModified()));
                                } else{
                                    System.out.println("Err: File for student 2 does not exist.");
                                }

                                if(file_display4.exists()) {
                                    System.out.println("Student 4 File:");
                                    System.out.println("Name: "+file_display4.getName());
                                    System.out.println("Path: "+file_display4.getPath());
                                    System.out.println("Size: "+file_display4.length());
                                    SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                                    System.out.println("Last Modified Date: "+sd.format(file_display4.lastModified()));
                                } else{
                                    System.out.println("Err: File for student 4 does not exist.");
                                }
                                break;

                            case 8:
                                //Saving objects; turning objects into serialized streams that can be deserialized upon user request.
                                System.out.println("'Freezing' student records...");
                                try(ObjectOutputStream frozenStudents1 = new ObjectOutputStream(new FileOutputStream("Students Folder\\FrozenStudentRecords1.ser"));
                                    ObjectOutputStream frozenStudents2 = new ObjectOutputStream(new FileOutputStream("Students Folder\\FrozenStudentRecords2.ser"));
                                    ObjectOutputStream frozenStudents3 = new ObjectOutputStream(new FileOutputStream("Students Folder\\FrozenStudentRecords3.ser"));
                                    ObjectOutputStream frozenStudents4 = new ObjectOutputStream(new FileOutputStream("Students Folder\\FrozenStudentRecords4.ser"))) {
                                    ObjectOutputStream[] frozenStudentsArray = {frozenStudents1, frozenStudents2, frozenStudents3, frozenStudents4};
                                    for(int i=0; i<studentsArray.length; i++){
                                        frozenStudentsArray[i].writeObject(studentsArray[i]);
                                    }
                                    frozenStudents1.close();
                                    frozenStudents2.close();
                                    frozenStudents3.close();
                                    frozenStudents4.close();
                                    System.out.println("Done.");
                                    System.out.println("Would you like to keep them serialized or 'unfreeze' them? Input --> (1/any other number) --> i.e. (unfreeze/keep)");
                                    int toFreeze = input.nextInt();
                                    if(toFreeze == 1) {
                                        System.out.println("Unfreezing...");
                                        try(ObjectInputStream unFrozenStudents1 = new ObjectInputStream(new FileInputStream("Students Folder\\FrozenStudentRecords1.ser"));
                                            ObjectInputStream unFrozenStudents2 = new ObjectInputStream(new FileInputStream("Students Folder\\FrozenStudentRecords2.ser"));
                                            ObjectInputStream unFrozenStudents3 = new ObjectInputStream(new FileInputStream("Students Folder\\FrozenStudentRecords3.ser"));
                                            ObjectInputStream unFrozenStudents4 = new ObjectInputStream(new FileInputStream("Students Folder\\FrozenStudentRecords4.ser"))) {
                                            ObjectInputStream[] unFrozenStudentsArray = {unFrozenStudents1, unFrozenStudents2, unFrozenStudents3, unFrozenStudents4};
                                            //New objects to inject deserialized objects into
                                            Student s1New = (Student)unFrozenStudentsArray[0].readObject();
                                            Student s2New = (Student)unFrozenStudentsArray[1].readObject();
                                            Student s3New = (Student)unFrozenStudentsArray[2].readObject();
                                            Student s4New = (Student)unFrozenStudentsArray[3].readObject();
                                            //
                                            System.out.println("Done.");
                                            System.out.println("Test: ");
                                            System.out.println("New student 1 name(should be the student of initial student 1 record): ");
                                            System.out.println(s1New.getName());
                                            System.out.println("Done.");
                                            //
                                        } catch(IOException e) {
                                            e.printStackTrace();
                                            System.out.println("Err: No objects to deserialize.");
                                        } catch(ClassNotFoundException e) {
                                            e.printStackTrace();
                                            System.out.println("Err: Could not deserialize objects.");
                                        }
                                    } else {
                                        System.out.println("No changes made.");
                                    }
                                } catch(IOException e) {
                                    System.out.println("Err: Can't serialize objects, no object exists.");
                                }
                                break;
                            case 9:

                                //Uses BufferedReader and BufferedWriter classes to create streams to create a backup
                                System.out.println("Creating the backup file...");
                                String line1 = "";
                                String line2 = "";
                                String line3 = "";
                                String line4 = "";

                                //Student 1
                                File test11 = new File("Students Folder\\StudentsFile1.txt");
                                File test12 = new File("Student Folder\\(UPDATED)StudentsFile1.txt");
                                if(test11.exists()) {
                                    try(BufferedReader newLine1 = new BufferedReader(new FileReader("Students Folder\\StudentsFile1.txt"))) {
                                        line1 = newLine1.readLine();
                                    } catch(IOException e) {
                                        System.out.println("Err: File might have been deleted. Can't create backup.");
                                    }
                                } else if(test12.exists()) {
                                    try(BufferedReader newLine1 = new BufferedReader(new FileReader("Students Folder\\(UPDATED)StudentsFile1.txt"))) {
                                        line1 = newLine1.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Err: Can't Find original or updated file for student 1.");
                                }

                                //Student 2
                                File test21 = new File("Students Folder\\StudentsFile2.txt");
                                File test22 = new File("Students Folder\\(UPDATED)StudentsFile2.txt");
                                if(test21.exists()) {
                                    try(BufferedReader newLine2 = new BufferedReader(new FileReader("Students Folder\\StudentsFile2.txt"))) {
                                        line2 = newLine2.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else if(test22.exists()) {
                                    try(BufferedReader newLine2 = new BufferedReader(new FileReader("Students Folder\\(UPDATED)StudentsFile2.txt"))) {
                                        line2 = newLine2.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Err: Can't find original or updated file for Student 2.");
                                }

                                //Student 3
                                File test31 = new File("Students Folder\\StudentsFile3.txt");
                                File test32 = new File("Students Folder\\(UPDATED)StudentsFile3.txt");
                                if(test31.exists()) {
                                    try(BufferedReader newLine3 = new BufferedReader(new FileReader("Students Folder\\StudentsFile3.txt"))) {
                                        line3 = newLine3.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else if(test32.exists()) {
                                    try(BufferedReader newLine3 = new BufferedReader(new FileReader("Students Folder\\(UPDATED)StudentsFile3.txt"))) {
                                        line3 = newLine3.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Err: Can't find original or updated file for Student 3.");
                                }

                                //Student 4
                                File test41 = new File("Students Folder\\StudentsFile4.txt");
                                File test42 = new File("Students Folder\\(UPDATED)StudentsFile4.txt");
                                if(test41.exists()) {
                                    try(BufferedReader newLine4 = new BufferedReader(new FileReader("Students Folder\\StudentsFile4.txt"))) {
                                        line4 = newLine4.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else if(test42.exists()) {
                                    try(BufferedReader newLine4 = new BufferedReader(new FileReader("Students Folder\\(UPDATED)StudentsFile4.txt"))) {
                                        line4 = newLine4.readLine();
                                    } catch(IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("Err: Can't find original or updated file for Student 4.");
                                }
                                try(BufferedWriter backUpFile = new BufferedWriter(new FileWriter("Students Folder\\StudentsBackupFile.txt"))) {
                                    backUpFile.write(line1+"\n");//Escape character used to make other data write to new line
                                    backUpFile.write(line2+"\n");
                                    backUpFile.write(line3+"\n");
                                    backUpFile.write(line4+"\n");
                                } catch(IOException e) {
                                    e.printStackTrace();
                                }
                                break;

                            //Basic binary file copying with DataInputStream and DataOutputStream
                            case 10:
                                System.out.println("Only Freshman students will get an identifier logo. Are your students Freshman or Senior year? (1/any other number)--> i.e. (Freshman/Senior)");
                                int batchChoice = input.nextInt();
                                if(batchChoice == 1) {
                                    System.out.println("Freshman selected, generating a logo...");
                                    try(DataInputStream picIn = new DataInputStream(new FileInputStream("fresh.png"));
                                        DataOutputStream picOut = new DataOutputStream(new FileOutputStream("Students Folder\\freshmanLogo.png"))) {
                                        int byteData;
                                        while((byteData = picIn.read()) != -1) {
                                            picOut.write(byteData);
                                        }
                                    } catch(IOException e) {
                                        System.out.println("Err: No data stream to read from or write to.");
                                    }
                                } else {
                                    System.out.println("Exiting...");
                                }
                        }

                    } catch(IOException e) {
                        System.out.println("Err: File can't be written to, file extension might have been altered.");
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Err: Invalid Option. Rerun Program.");

            }
        }
    }
}
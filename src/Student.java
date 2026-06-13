import java.io.*;
import java.util.Scanner;

public class Student {
    private int ID;
    private String name;
    private String dept;
    private double gpa;
    //Constructor
    public Student(int ID, String name, String dept, double gpa) {
        this.ID = ID;
        this.name = name;
        this.dept = dept;
        this.gpa = gpa;
    }
    //Getters and setters
    public int getID() {
        return ID;
    }
    public void setID(int newID) {
        this.ID = newID;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String newDept ) {
        this.dept = newDept;
    }
    public int getGpa() {
        return gpa;
    }
    public void setGpa(int newGPA) {
        this.gpa = newGPA;
    }

}

package student_management_system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayStudentDetails {

    public static void main(String[] args) {
        displayStudentDetailsMenu();
    }

    private static void displayStudentDetailsMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nStudent Personal Details Menu\n");
        System.out.println("1. Student ID, Name & Preferred Name, Gender, DOB, Address");
        System.out.println("2. Student Contact Details (Email, Phone Number)");
        System.out.println("3. Display Students Grades");
        System.out.println("4. Cancel");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                displayBasicStudentDetails();
                break;
            case 2:
                displayContactDetails();
                break;
            case 3:
                viewStudentGrades();
                break;
            case 4:
                System.out.println("Exiting Student Details Menu...");
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                displayStudentDetailsMenu();
        }
    }

    private static void displayBasicStudentDetails() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./textFiles/student_details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentDetails = line.split(",");
                // Display required student details
                System.out.println("Student ID: " + studentDetails[3]);
                System.out.println("Name: " + studentDetails[0] + " " + studentDetails[1]);
                System.out.println("Preferred Name: " + studentDetails[2]);
                System.out.println("Gender: " + studentDetails[4]);
                System.out.println("DOB: " + studentDetails[5]);
                System.out.println("Address: " + studentDetails [6]+ " " + studentDetails [7]+ " " + studentDetails [8]+ " " + studentDetails [9]+ " " + studentDetails [10]);
                System.out.println("Campus: " + studentDetails[18]);

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayContactDetails() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./textFiles/student_details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentDetails = line.split(",");            
                System.out.println("Email: " +studentDetails[12]);
                System.out.println("Phone Number: " + studentDetails[11]);
                
                System.out.println();
            }
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
}
 
       

private static void viewStudentGrades() {
    try (BufferedReader reader = new BufferedReader(new FileReader("./textFiles/grades.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] gradesDetails = line.split(",");
            String studentID = gradesDetails[0];
            String semester = gradesDetails[1];
            String class1 = gradesDetails[2];
            String class2 = gradesDetails[3];
            String class3 = gradesDetails[4];
            String class4 = gradesDetails[5];
            String grade1 = gradesDetails[6];
            String grade2 = gradesDetails[7];
            String grade3 = gradesDetails[8];
            String grade4 = gradesDetails[9];
            
            System.out.println("\nStudent ID: " + studentID);
            System.out.println("Semester: " + semester);
            System.out.println("Class 1: " + class1 + ", Grade: " + grade1);
            System.out.println("Class 2: " + class2 + ", Grade: " + grade2);
            System.out.println("Class 3: " + class3 + ", Grade: " + grade3);
            System.out.println("Class 4: " + class4 + ", Grade: " + grade4);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

package student_management_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentEnrollment {

    public static void main(String[] args) {
        displayStudentEnrollments();
    }

    private static void displayStudentEnrollments() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./textFiles/student_details.txt"))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nStudent Enrollments\n");
            System.out.println("Student ID | Degree Name | Class 1 | Class 2 | Class 3 | Class 4 | Semester | Campus");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentDetails = line.split(",");
                
                String studentID = studentDetails[3]; 
                String degree = studentDetails[17];
                String class1 = studentDetails[13];
                String class2 = studentDetails[14];
                String class3 = studentDetails[15];
                String class4 = studentDetails[16];
                String semester = studentDetails[19];
                String campus = studentDetails[18];

                System.out.println(studentID + " | " + degree + " | " + class1 + " | " + class2 + " | " + class3 + " | " + class4 + " | " + semester + " | " + campus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

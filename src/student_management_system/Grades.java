package student_management_system;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Grades {

    Scanner scanner;

    Grades() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter Student Grades");

        System.out.print("Enter Student ID Number: ");
        String studentID = scanner.nextLine();

        System.out.print("Select Semester (1, 2 or Summer School): ");
        String semester = scanner.nextLine();

        System.out.print("Enter Class 1: ");
        String class1 = scanner.nextLine();

        System.out.print("Enter Class 2: ");
        String class2 = scanner.nextLine();

        System.out.print("Enter Class 3: ");
        String class3 = scanner.nextLine();

        System.out.print("Enter Class 4: ");
        String class4 = scanner.nextLine();


     String[] grade = new String[4];
     for (int i = 0; i < 4; i++) {
         System.out.print("Enter Grade for Class " + (i + 1) + ": ");
         String grades = scanner.nextLine().toUpperCase();
         while (!isValidGrade(grades)) {
             System.out.println("Invalid input. Please enter a valid grade (e.g., A+, A-, B+).");
             System.out.print("Enter Grade for Class " + (i + 1) + ": ");
             grades = scanner.nextLine().toUpperCase();
         }
         grade[i] = grades; // Store the valid grade in the grades array 
}


      

        try {
            writeGradesToFile(studentID, semester, class1, class2, class3, class4,
                    grade[0], grade[1], grade[2], grade[3]);

            System.out.println("Marks Inserted Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeGradesToFile(String studentID, String semester, String class1, String class2,
            String class3, String class4, String grade1, String grade2, String grade3,
            String grade4) 
            throws IOException {
        try (FileWriter writer = new FileWriter("./textFiles/grades.txt", true)) {
            String gradesDetails = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", studentID, semester, class1,
                    class2, class3, class4, grade1, grade2, grade3, grade4 );
            writer.write(gradesDetails + "\n");
        }
    }
    
    public static void main(String[] args) {
        Grades grades = new Grades();
        grades.run();
    }
    
    private boolean isValidGrade(String grade) 
    {// List of valid grades
        String[] validGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D"};
        grade = grade.toUpperCase(); // Convert input grade to uppercase for case-insensitive comparison

    // Checks if the input grade is in the list of valid grades
    for (String validGrade : validGrades) {
        if (grade.equals(validGrade)) {
            return true; // Return true if the input grade is valid
        }
    }
    return false; // Return false if the input grade is invalid
    }

}

package student_management_system;

import java.util.Scanner;

public class StudentManagementSystem {

    Scanner scanner;

    StudentManagementSystem() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to Student Management System!");
        System.out.println("1. Add New Student");
        System.out.println("2. Display Student Details");
        System.out.println("3. Student Enrollment Details");
        System.out.println("4. Insert Student Grade");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Which option would you like to access (Enter Number): ");
            String choiceInput = scanner.nextLine();

            // Number needs to be entered, user is prompted again
            if (choiceInput.isEmpty()) {
                System.out.println("Please enter a number.");
                continue;
            }

            int choice;
            // input has to be a number
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showDisplayStudentDetails();
                    break;
                case 3:
                    showStudentEnrollmentDetails();
                    break;
                case 4:
                    insertStudentGrades();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private void showDisplayStudentDetails() {
        //Goes to StudentDetailsFile
        DisplayStudentDetails.main(new String[0]);
    }

    private void addStudent() {
        System.out.println("Adding a new student...");
        //Goes to
        AddStudent.main(new String[0]);
    }

    private void showStudentEnrollmentDetails() {
        // Goes to StudentEnrollment.java file
        StudentEnrollment.main(new String[0]);
    }

    private void insertStudentGrades() {
        // Goes to grade.java file
        Grades grades = new Grades();
        grades.run(); // Call the run method of the Grades class
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}

package student_management_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        
        System.out.println("Login to Student Management System");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate login credentials
        boolean isValidLogin = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("./textFiles/login.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    isValidLogin = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isValidLogin) {
            System.out.println("Login successful!");
            openMainMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    private static void openMainMenu() {
        // After successful login, run StudentManagementSystem.java 
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}

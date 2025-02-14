package student_management_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddStudent {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        try {
            System.out.println("\nEnter New Student Details\n");
            
            String firstName;
            do{
                System.out.print("First Name: ");
                firstName = scanner.nextLine();
                if (!firstName.matches("[a-zA-Z]+")) 
                {
                    System.out.println("Invalid. Please your First name.");
                }
            } while (!firstName.matches("[a-zA-Z]+"));
            
            String lastName;
            do{
                System.out.print("Last Name: ");
                lastName = scanner.nextLine();
                if (!lastName.matches("[a-zA-Z]+")) 
                {
                    System.out.println("Invalid. Please your Last name.");
                }
            } while (!lastName.matches("[a-zA-Z]+"));
            

            System.out.print("Student Preferred First Name (can be null): ");
            String preferredName = scanner.nextLine();

            String studentID;
            do{
                System.out.println("Student ID:  ");
                studentID = scanner.nextLine();
                if(!studentID.matches("\\d{8}")){
                    System.out.println("Invalid. Please enter your Student ID.");
                }
            }while (!studentID.matches("\\d{8}"));

            String gender;
            do{
                System.out.println("Gender (Male/Female/Non-binary/Other): ");
                gender = scanner.nextLine();
               if(!gender.matches("Male|Female|Non-Binary|Other")){
                    System.out.println("Invalid. Please enter your Gender (Male/Female/Non-binary/Other).");
                }
            } while (!gender.matches("Male|Female|Non-Binary|Other"));
            

            String dob;
            do {
                System.out.print("Date of Birth (DD-MM-YYYY): ");
                dob = scanner.nextLine();
                if (!dob.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    System.out.println("Invalid format. Please enter the Date of Birth in DD-MM-YYYY format.");
                }
            } while (!dob.matches("\\d{2}-\\d{2}-\\d{4}"));

        

            System.out.print("House number: ");
            String addressLine1 = scanner.nextLine().replaceAll(",", "");;
            
            System.out.print("Street Address: ");
            String addressLine2 = scanner.nextLine().replaceAll(",", "");;
            
            System.out.print("Suburb: ");
            String suburb = scanner.nextLine().replaceAll(",", "");;
            
            System.out.print("City: ");
            String city = scanner.nextLine().replaceAll(",", "");;
            
            
            System.out.print("PostCode: ");
            String postcode = scanner.nextLine().replaceAll(",", "");;

        

            String phone;
            do{
                System.out.print("Phone Number: ");
                phone = scanner.nextLine();
                if(!phone.matches("\\d+")){
                    System.out.println("Invalid. Please enter your Phone Number.");
                }
            } while(!phone.matches("\\d+"));

            System.out.print("Email: ");
            String email = scanner.nextLine();

            String class1;
            do{
                System.out.print("Class 1 Code: ");
                class1 = scanner.nextLine();
                if(!class1.matches("[a-zA-Z]{4}\\d{3}")){
                    System.out.println("Invalid. Please enter the Class Code again.");
                }
            }while (!class1.matches("[a-zA-Z]{4}\\d{3}"));
            
            String class2;
            do{
                System.out.print("Class 2 Code: ");
                class2 = scanner.nextLine();
                if(!class2.matches("[a-zA-Z]{4}\\d{3}")){
                    System.out.println("Invalid. Please enter the Class Code again.");
                }
            }while (!class2.matches("[a-zA-Z]{4}\\d{3}"));
            
            String class3;
            do{
                System.out.print("Class 3 Code: ");
                class3= scanner.nextLine();
                if(!class3.matches("[a-zA-Z]{4}\\d{3}")){
                    System.out.println("Invalid. Please enter the Class Code again.");
                }
            }while (!class3.matches("[a-zA-Z]{4}\\d{3}"));
            
            String class4;
            do{
                System.out.print("Class 4 Code: ");
                class4 = scanner.nextLine();
                if(!class4.matches("[a-zA-Z]{4}\\d{3}")){
                    System.out.println("Invalid. Please enter the Class Code again.");
                }
            }while (!class4.matches("[a-zA-Z]{4}\\d{3}"));

            System.out.print("Degree Name: ");
            String degree = scanner.nextLine();

            String campus;
            do {
                System.out.print("Campus (City, South, North): ");
                campus = scanner.nextLine();
                if(!campus.matches("City|South|North")){
                    System.out.println("Invalid. Please enter your Campus.");
                }
            } while (!campus.matches("(City|South|North)"));

            System.out.print("Semester (1, 2, or Summer School): "); 
            String semester = scanner.nextLine(); 

            String studentDetails = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                    firstName, lastName, preferredName, studentID, gender, dob, addressLine1,addressLine2,suburb,city,postcode,phone, email, class1, class2, class3, class4, degree, campus);

            
            studentDetails += "," + semester;

            writeStudentToFile(studentDetails);
            System.out.println("Student Details Successfully Recorded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeStudentToFile(String studentDetails) throws IOException {
        File file = new File("./textFiles/student_details.txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(studentDetails + "\n");
        }
    }

    public static void main(String[] args) {
        AddStudent addStudent = new AddStudent();
        addStudent.run();
    }
}

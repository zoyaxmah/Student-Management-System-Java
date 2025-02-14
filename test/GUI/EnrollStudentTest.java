
package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * @author zoyamahmood
 */
public class EnrollStudentTest {

    private EnrollStudent enrollStudent;

    @Before
    public void setUp() throws SQLException {
        enrollStudent = new EnrollStudent();

        // Student record for testing
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String insertStudentSQL = "INSERT INTO Student_Details (student_id, first_name, last_name, preferred_name, gender, dob, address, suburb, city, postcode, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertStudentSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.setString(2, "John");
                pstmt.setString(3, "Doe");
                pstmt.setString(4, "Johnny");
                pstmt.setString(5, "Male");
                pstmt.setDate(6, java.sql.Date.valueOf("2000-01-01"));
                pstmt.setString(7, "123 Main St");
                pstmt.setString(8, "Central");
                pstmt.setString(9, "Metropolis");
                pstmt.setString(10, "1234");
                pstmt.setString(11, "john.doe@example.com");
                pstmt.setString(12, "02123456");
                pstmt.executeUpdate();
            }
        }
    }

    @After
    public void tearDown() throws SQLException {
        // Clean up database 
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String deleteEnrollmentSQL = "DELETE FROM Enrollments WHERE student_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteEnrollmentSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.executeUpdate();
            }

            String deleteStudentSQL = "DELETE FROM Student_Details WHERE student_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteStudentSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.executeUpdate();
            }
        }

        enrollStudent = null;
    }

    @Test
    public void testEnrollmentProcess() throws Exception {
        enrollStudent.getTfStudID().setText("87654321");
        enrollStudent.getListDegree().setSelectedIndex(0); // Assume first index is selected
        enrollStudent.getListCampus().setSelectedIndex(0); // Assume first index is selected
        enrollStudent.getListSemester().setSelectedIndex(0); // Assume first index is selected
        enrollStudent.getListClass1().setSelectedIndex(0); // Assume first index is selected


        java.awt.event.ActionEvent evt = new java.awt.event.ActionEvent(enrollStudent.getBtnSubmit(), java.awt.event.ActionEvent.ACTION_PERFORMED, "Submit");
        invokePrivateMethod(enrollStudent, "BtnSubmit1ActionPerformed", evt);

        // Check enrollment was saved correctly
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String selectEnrollmentSQL = "SELECT * FROM Enrollments WHERE student_id = ? AND semester = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectEnrollmentSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.setString(2, "1"); // Assuming semester 1 is selected
                ResultSet rs = pstmt.executeQuery();
                assertTrue(rs.next()); // Check if a record exists
                assertEquals("Bachelor of Computing & Information Sciences", rs.getString("degree"));
                assertEquals("City", rs.getString("campus"));
                assertEquals("1", rs.getString("semester"));
                assertEquals("COMP500", rs.getString("class1_code"));
            }
        }
    }

    private void invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        java.lang.reflect.Method method = instance.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        method.invoke(instance, args);
    }
}

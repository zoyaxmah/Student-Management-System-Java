package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.*;

public class AddStudentGradesTest {

    private AddStudentGrades addStudentGrades;

    @Before
    public void setUp() throws Exception {
        addStudentGrades = new AddStudentGrades();

        // Cleaning up any prior test data
        tearDown();

        // test data in the database
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

            String insertEnrollmentSQL = "INSERT INTO Enrollments (student_id, degree, campus, semester, class1_code, class2_code, class3_code, class4_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertEnrollmentSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.setString(2, "Bachelor of Science");
                pstmt.setString(3, "City");
                pstmt.setString(4, "1");
                pstmt.setString(5, "COMP500");
                pstmt.setString(6, "COMP501");
                pstmt.setString(7, "COMP507");
                pstmt.setString(8, "COMP508");
                pstmt.executeUpdate();
            }
        }

        // Make GUI visible 
        EventQueue.invokeAndWait(() -> {
            addStudentGrades.setVisible(true);
        });

        // call private methods
        callPrivateMethod(addStudentGrades, "loadStudentIDs");
        callPrivateMethod(addStudentGrades, "loadSemesters");
        callPrivateMethod(addStudentGrades, "loadGrades");
        callPrivateMethod(addStudentGrades, "fetchStudentGrades");
    }

    @After
    public void tearDown() throws SQLException {
        // Clean database after tests
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String deleteGradeSQL = "DELETE FROM Grades WHERE student_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteGradeSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.executeUpdate();
            }

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
    }

    @Test
    public void testSaveGrade() throws Exception {
        EventQueue.invokeAndWait(() -> {
            JComboBox<String> cbStudentID = addStudentGrades.getCbStudentID();
            cbStudentID.setSelectedItem("87654321");
            System.out.println("Selected Student ID: " + cbStudentID.getSelectedItem());

            JList<String> listSemester = addStudentGrades.getListSemester();
            listSemester.setSelectedValue("1", true);
            System.out.println("Selected Semester: " + listSemester.getSelectedValue());

            // Load classes for the student after setting student ID and semester
            callPrivateMethod(addStudentGrades, "loadClassesForStudent");

            JList<String> listClasses = addStudentGrades.getJListClasses();
            listClasses.setSelectedValue("COMP500", true);
            System.out.println("Selected Class: " + listClasses.getSelectedValue());

            JComboBox<String> cbGrades = addStudentGrades.getCbGrades();
            cbGrades.setSelectedItem("A");
            System.out.println("Selected Grade: " + cbGrades.getSelectedItem());
        });

        // save button click
        EventQueue.invokeAndWait(() -> {
            JButton btnSave = addStudentGrades.getBtnSave();
            btnSave.doClick();
        });

        // Check if the grade was saved in database
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String selectGradeSQL = "SELECT grade FROM Grades WHERE student_id = ? AND semester = ? AND class_code = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectGradeSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.setString(2, "1");
                pstmt.setString(3, "COMP500");
                ResultSet rs = pstmt.executeQuery();
                assertTrue(rs.next());
                assertEquals("A", rs.getString("grade"));
            }
        } catch (SQLException e) {
            fail("Database error: " + e.getMessage());
        }

        // Check if the grade was updated in the JTable
        EventQueue.invokeAndWait(() -> {
            JTable jTable = addStudentGrades.getjTable1();
            boolean found = false;
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if (jTable.getValueAt(i, 0).equals("87654321") &&
                    jTable.getValueAt(i, 1).equals("1") &&
                    jTable.getValueAt(i, 2).equals("COMP500") &&
                    jTable.getValueAt(i, 3).equals("A")) {
                    found = true;
                    break;
                }
            }
            assertTrue(found);
        });
    }

    @Test
    public void testDeleteGrade() throws Exception {
        // Save a grade to be deleted
        testSaveGrade();

        // Select grade in JTable
        EventQueue.invokeAndWait(() -> {
            JTable jTable = addStudentGrades.getjTable1();
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if (jTable.getValueAt(i, 0).equals("87654321") &&
                    jTable.getValueAt(i, 1).equals("1") &&
                    jTable.getValueAt(i, 2).equals("COMP500")) {
                    jTable.setRowSelectionInterval(i, i);
                    break;
                }
            }
        });

        EventQueue.invokeAndWait(() -> {
            JButton btnDelete = addStudentGrades.getBtnDelete();
            btnDelete.doClick();
        });

        // Check grade was deleted from database
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
            String selectGradeSQL = "SELECT grade FROM Grades WHERE student_id = ? AND semester = ? AND class_code = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectGradeSQL)) {
                pstmt.setString(1, "87654321");
                pstmt.setString(2, "1");
                pstmt.setString(3, "COMP500");
                ResultSet rs = pstmt.executeQuery();
                assertFalse(rs.next());
            }
        } catch (SQLException e) {
            fail("Database error: " + e.getMessage());
        }

        // Check grade was removed from JTable
        EventQueue.invokeAndWait(() -> {
            JTable jTable = addStudentGrades.getjTable1();
            boolean found = false;
            for (int i = 0; i < jTable.getRowCount(); i++) {
                if (jTable.getValueAt(i, 0).equals("87654321") &&
                    jTable.getValueAt(i, 1).equals("1") &&
                    jTable.getValueAt(i, 2).equals("COMP500")) {
                    found = true;
                    break;
                }
            }
            assertFalse(found);
        });
    }

    private void callPrivateMethod(Object instance, String methodName) {
        try {
            Method method = instance.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

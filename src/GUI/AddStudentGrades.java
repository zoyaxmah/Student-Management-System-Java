/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zoyamahmood
 */
public class AddStudentGrades extends javax.swing.JFrame {

    /**
     * Creates New Form AddStudentGrades
     */
    public AddStudentGrades() throws SQLException {
        initComponents();
        loadStudentIDs();
        loadSemesters();
        loadGrades();
        fetchStudentGrades();
    }

    public javax.swing.JButton getBtnSave() {
        return BtnSave;
    }

    public javax.swing.JButton getBtnDelete() {
        return BtnDelete;
    }

    public javax.swing.JComboBox<String> getCbGrades() {
        return cbGrades;
    }

    public javax.swing.JComboBox<String> getCbStudentID() {
        return cbStudentID;
    }

    public javax.swing.JList<String> getListSemester() {
        return ListSemester1;
    }

    public javax.swing.JList<String> getJListClasses() {
        return jListClasses;
    }
    
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnHome = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        jLabelStudID = new javax.swing.JLabel();
        jLabelGrades = new javax.swing.JLabel();
        Class3GradeLABEL = new javax.swing.JLabel();
        jLabelSemester = new javax.swing.JLabel();
        cbStudentID = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        ListSemester1 = new javax.swing.JList<>();
        cbGrades = new javax.swing.JComboBox<>();
        BtnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListClasses = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(831, 497));
        jPanel1.setPreferredSize(new java.awt.Dimension(831, 497));

        BtnHome.setBackground(new java.awt.Color(2, 154, 154));
        BtnHome.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 11)); // NOI18N
        BtnHome.setForeground(new java.awt.Color(208, 244, 244));
        BtnHome.setText("Back Home");
        BtnHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHomeActionPerformed(evt);
            }
        });

        Title.setBackground(new java.awt.Color(0, 0, 102));
        Title.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Enter Student Grades");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelStudID.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 0, 15)); // NOI18N
        jLabelStudID.setForeground(new java.awt.Color(208, 244, 244));
        jLabelStudID.setText("* Student ID:");

        jLabelGrades.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 0, 15)); // NOI18N
        jLabelGrades.setForeground(new java.awt.Color(208, 244, 244));
        jLabelGrades.setText("*Grade");

        Class3GradeLABEL.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 0, 15)); // NOI18N
        Class3GradeLABEL.setForeground(new java.awt.Color(208, 244, 244));
        Class3GradeLABEL.setText("*Students Classes");

        jLabelSemester.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 0, 15)); // NOI18N
        jLabelSemester.setForeground(new java.awt.Color(208, 244, 244));
        jLabelSemester.setText("*Semester:");

        cbStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStudentIDActionPerformed(evt);
            }
        });

        ListSemester1.setFont(new java.awt.Font("Toppan Bunkyu Gothic", 0, 13)); // NOI18N
        ListSemester1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "Summer School" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(ListSemester1);

        cbGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGradesActionPerformed(evt);
            }
        });

        BtnSave.setBackground(new java.awt.Color(2, 154, 154));
        BtnSave.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 14)); // NOI18N
        BtnSave.setForeground(new java.awt.Color(208, 244, 244));
        BtnSave.setText("SAVE");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        BtnDelete.setBackground(new java.awt.Color(2, 154, 154));
        BtnDelete.setFont(new java.awt.Font("Toppan Bunkyu Midashi Gothic", 1, 14)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(208, 244, 244));
        BtnDelete.setText("Delete ");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jListClasses);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(cbStudentID, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStudID)
                            .addComponent(jLabelSemester)
                            .addComponent(Class3GradeLABEL)
                            .addComponent(jLabelGrades)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BtnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(cbGrades, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addComponent(BtnHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelSemester)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelStudID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Class3GradeLABEL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelGrades)
                        .addGap(2, 2, 2)
                        .addComponent(cbGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHomeActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnHomeActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        saveGrade();
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void cbStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStudentIDActionPerformed
        loadClassesForStudent();
    }//GEN-LAST:event_cbStudentIDActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String studentID = (String) model.getValueAt(selectedRow, 0);
        String semester = (String) model.getValueAt(selectedRow, 1);
        String classCode = (String) model.getValueAt(selectedRow, 2);
        String url = "jdbc:derby://localhost:1527/SMS";
        String deleteQuery = "DELETE FROM Grades WHERE student_id = ? AND semester = ? AND class_code = ?";
        try (Connection con = DriverManager.getConnection(url); PreparedStatement pst = con.prepareStatement(deleteQuery)) {
            pst.setString(1, studentID);
            pst.setString(2, semester);
            pst.setString(3, classCode);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Grade deleted successfully.");
                model.removeRow(selectedRow); // Removing row from the table model
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the grade.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while deleting the grade.");
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void cbGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGradesActionPerformed
private void loadStudentIDs() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT student_id FROM Student_Details")) {

            while (rs.next()) {
                cbStudentID.addItem(rs.getString("student_id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading student IDs: " + ex.getMessage());
        }
    }
private void loadGrades() {
    //load grades from database 
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    model.addElement("A+");
    model.addElement("A");
    model.addElement("A-");
    model.addElement("B+");
    model.addElement("B");
    model.addElement("B-");
    model.addElement("C+");
    model.addElement("C");
    model.addElement("C-");
    model.addElement("D+");
    model.addElement("D");
    model.addElement("D-");
    cbGrades.setModel(model);
}
private void loadSemesters() {
     DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("1");
        model.addElement("2");
        model.addElement("Summer School");
        ListSemester1.setModel(model);
    }

private void loadClassesForStudent() {
        String studentID = (String) cbStudentID.getSelectedItem();
        String semester = (String) ListSemester1.getSelectedValue();
        if (studentID == null || semester == null) {
            return;
        }

        DefaultListModel<String> model = new DefaultListModel<>();

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS");
             PreparedStatement ps = conn.prepareStatement("SELECT class1_code, class2_code, class3_code, class4_code FROM Enrollments WHERE student_id = ? AND semester = ?")) {

            ps.setString(1, studentID);
            ps.setString(2, semester);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String class1 = rs.getString("class1_code");
                String class2 = rs.getString("class2_code");
                String class3 = rs.getString("class3_code");
                String class4 = rs.getString("class4_code");

                if (class1 != null) {
                    model.addElement(class1);
                }
                if (class2 != null) {
                    model.addElement(class2);
                }
                if (class3 != null) {
                    model.addElement(class3);
                }
                if (class4 != null) {
                    model.addElement(class4);
                }
            }

            jListClasses.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading classes for student: " + ex.getMessage());
        }
    }

private void saveGrade() {
    String studentID = (String) cbStudentID.getSelectedItem();
        String semester = (String) ListSemester1.getSelectedValue(); 
        String classCode = (String) jListClasses.getSelectedValue();
        String grade = (String) cbGrades.getSelectedItem();

        if (studentID != null && semester != null && classCode != null && grade != null) {
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS")) {
                // Check if the record already exists
                PreparedStatement checkStmt = conn.prepareStatement(
                        "SELECT COUNT(*) FROM Grades WHERE student_id = ? AND semester = ? AND class_code = ?");
                checkStmt.setString(1, studentID);
                checkStmt.setString(2, semester);
                checkStmt.setString(3, classCode);
                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) { // If tjhe record already exists, update
                    PreparedStatement updateStmt = conn.prepareStatement(
                            "UPDATE Grades SET grade = ? WHERE student_id = ? AND semester = ? AND class_code = ?");
                    updateStmt.setString(1, grade);
                    updateStmt.setString(2, studentID);
                    updateStmt.setString(3, semester);
                    updateStmt.setString(4, classCode);
                    updateStmt.executeUpdate();
                } else { // If the record doessn't exist, insert
                    PreparedStatement insertStmt = conn.prepareStatement(
                            "INSERT INTO Grades (student_id, semester, class_code, grade) VALUES (?, ?, ?, ?)");
                    insertStmt.setString(1, studentID);
                    insertStmt.setString(2, semester);
                    insertStmt.setString(3, classCode);
                    insertStmt.setString(4, grade);
                    insertStmt.executeUpdate();
                }

                JOptionPane.showMessageDialog(this, "Grade saved successfully!");

                // Add new grade to table
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{studentID, semester, classCode, grade});

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving grade: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student, semester, class, and grade.");
        }
}

    private void fetchStudentGrades() throws SQLException {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Student ID", "Semester", "Class Code", "Grade"}, 0);
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS"); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT g.student_id, g.semester, g.class_code, g.grade " + "FROM Grades g " + "JOIN Student_Details s ON g.student_id = s.student_id")) {
            while (rs.next()) {
                String studentID = rs.getString("student_id");
                String semester = rs.getString("semester");
                String classCode = rs.getString("class_code");
                String grade = rs.getString("grade");
                model.addRow(new Object[]{studentID, semester, classCode, grade});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching student grades: " + ex.getMessage());
        }
        jTable1.setModel(model);
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddStudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddStudentGrades().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddStudentGrades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnHome;
    private javax.swing.JButton BtnSave;
    private javax.swing.JLabel Class3GradeLABEL;
    private javax.swing.JList<String> ListSemester1;
    private javax.swing.JLabel Title;
    private javax.swing.JComboBox<String> cbGrades;
    private javax.swing.JComboBox<String> cbStudentID;
    private javax.swing.JLabel jLabelGrades;
    private javax.swing.JLabel jLabelSemester;
    private javax.swing.JLabel jLabelStudID;
    private javax.swing.JList<String> jListClasses;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

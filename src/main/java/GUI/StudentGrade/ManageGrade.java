/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StudentGrade;

import BLL.CourseBLL;
import BLL.StudentGradeBLL;

import DTO.Course;
import DTO.Person;
import DTO.StudentGrade;
import java.awt.event.KeyEvent;

import BLL.DTO.StudentGrade;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ManageGrade extends javax.swing.JPanel {

    /**
     * Creates new form ManagerGrade
     */
    StudentGradeBLL SGbll = new StudentGradeBLL();
    ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
    // ArrayList<StudentGrade> updateGrades = new ArrayList<StudentGrade>();
    CourseBLL Cbll = new CourseBLL();
    ArrayList<Course> courses = new ArrayList<Course>();

    public ManageGrade() throws SQLException {
        initComponents();
        LoadData(0);
        LoadCbbCourse();
    }

    public void LoadData(int index) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTableManageGrade.getModel();
        model.setRowCount(0);
        ArrayList<Course> cID = new ArrayList<Course>();
        if (index == 0) {
            studentGrades = SGbll.gettAllGrade();
            for (int i = 0; i < studentGrades.size(); i++) {
                StudentGrade sg = studentGrades.get(i);
                int enrollmentID = sg.getEnrollmentID();
                int courseID = sg.getCourseID();
                cID = Cbll.findCourse(String.valueOf(courseID));
                String title = cID.get(0).getTitle();
                int studentID = sg.getStudentID();
                double grade = sg.getGrade();
                model.addRow(new Object[]{enrollmentID, courseID, title, studentID, grade});
            }
        } else {
            studentGrades = SGbll.findGrades(index);
            for (int i = 0; i < studentGrades.size(); i++) {
                StudentGrade sg = studentGrades.get(i);
                int enrollmentID = sg.getEnrollmentID();
                int courseID = sg.getCourseID();
                cID = Cbll.findCourse(String.valueOf(courseID));
                String title = cID.get(0).getTitle();
                int studentID = sg.getStudentID();
                double grade = sg.getGrade();
                model.addRow(new Object[]{enrollmentID, courseID, title, studentID, grade});
            }
        }
    }

    public void LoadCbbCourse() throws SQLException {
        courses = Cbll.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            String item = c.getCourseID() + " - " + c.getTitle();
            cbbChooseCourse.addItem(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableManageGrade = new javax.swing.JTable();
        cbbChooseCourse = new javax.swing.JComboBox<>();
        btnFindCourse = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        jTableManageGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EnrollmentID", "CourseID", "Title", "StudentID", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableManageGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManageGradeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableManageGradeMouseEntered(evt);
            }
        });
        jTableManageGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableManageGradeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableManageGrade);

        cbbChooseCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not select" }));
        cbbChooseCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn khóa học"));
        cbbChooseCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChooseCourseMouseClicked(evt);
            }
        });

        btnFindCourse.setText("Find");
        btnFindCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCourseActionPerformed(evt);
            }
        });

        txtFind.setBorder(javax.swing.BorderFactory.createTitledBorder("Find by StudentID"));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbbChooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbChooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String findById = txtFind.getText();
        if (findById.isEmpty()) {
            try {
                LoadData(0);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        DefaultTableModel model = (DefaultTableModel) jTableManageGrade.getModel();
        model.setRowCount(0);
        int studentID = Integer.parseInt(txtFind.getText());

        try {
            studentGrades = SGbll.findGradesByStudentID(studentID);
            for (int i = 0; i < studentGrades.size(); i++) {
                StudentGrade sg = studentGrades.get(i);
                int enrollmentID = sg.getEnrollmentID();
                int courseID = sg.getCourseID();
                String title = "abc";
                int sID = sg.getStudentID();
                double grade = sg.getGrade();
                model.addRow(new Object[]{enrollmentID, courseID, title, sID, grade});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnFindActionPerformed

    private void cbbChooseCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChooseCourseMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbChooseCourseMouseClicked

    private void btnFindCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCourseActionPerformed
        // TODO add your handling code here:
        String selectedCourseID = (String) cbbChooseCourse.getSelectedItem();
        String[] parts = selectedCourseID.split("[\\s-]+");
        String courseID = parts[0];
        if (courseID.equals("Not")) {
            try {
                LoadData(0);
            } catch (SQLException ex) {
                Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                LoadData(Integer.parseInt(courseID));
            } catch (SQLException ex) {
                Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnFindCourseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableManageGrade.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int enrollmentID = (int) jTableManageGrade.getValueAt(i, 0);
            int courseId = (int) jTableManageGrade.getValueAt(i, 1);
            int studentID = (int) jTableManageGrade.getValueAt(i, 3);
            double grade = (double) jTableManageGrade.getValueAt(i, 4);
            StudentGrade sg = new StudentGrade(enrollmentID, courseId, studentID, grade);
            try {
                SGbll.updateGrade(sg);
            } catch (SQLException ex) {
                Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Update grade to success!");

        try {
            LoadData(0);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(ManageGrade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void jTableManageGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManageGradeMouseClicked
        // TODO add your handling code here:
//        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
//            int selectedRow = jTableManageGrade.getSelectedRow();
//            if (selectedRow != -1) {
//                int enrollmentID = (int) jTableManageGrade.getValueAt(selectedRow, 0);
//                int courseId = (int) jTableManageGrade.getValueAt(selectedRow, 1);
//                int studentID = (int) jTableManageGrade.getValueAt(selectedRow, 3);
//                double grade = (double) jTableManageGrade.getValueAt(selectedRow, 4);
//                StudentGrade sg = new StudentGrade(enrollmentID, courseId, studentID, grade);
//                updateGrades.add(sg);
//                System.out.println(updateGrades);
//                System.out.println("----------------------------");
//            }
//        }
    }//GEN-LAST:event_jTableManageGradeMouseClicked

    private void jTableManageGradeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManageGradeMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableManageGradeMouseEntered

    private void jTableManageGradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableManageGradeKeyPressed
        // TODO add your handling code here:
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
//            int selectedRow = jTableManageGrade.getSelectedRow();
//            if (selectedRow != -1) {
//                int enrollmentID = (int) jTableManageGrade.getValueAt(selectedRow, 0);
//                int courseId = (int) jTableManageGrade.getValueAt(selectedRow, 1);
//                int studentID = (int) jTableManageGrade.getValueAt(selectedRow, 3);
//                double grade = (double) jTableManageGrade.getValueAt(selectedRow, 4);
//                StudentGrade sg = new StudentGrade(enrollmentID, courseId, studentID, grade);
//                updateGrades.add(sg);
//                System.out.println(updateGrades);
//                System.out.println("----------------------------");
//            }
//        }
    }//GEN-LAST:event_jTableManageGradeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFindCourse;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbChooseCourse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableManageGrade;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}

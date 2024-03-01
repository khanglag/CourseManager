/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.StudentGrade;

import BLL.StudentGradeBLL;
import BLL.DTO.StudentGrade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public ManageGrade() throws SQLException {
        initComponents();
        LoadData(0);
    }

    public void LoadData(int index) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTableManageGrade.getModel();
        model.setRowCount(0);
        studentGrades = SGbll.gettAllGrade();
        for (int i = 0; i < studentGrades.size(); i++) {
            StudentGrade sg = studentGrades.get(i);
            int enrollmentID = sg.getEnrollmentID();
            int courseID = sg.getCourseID();
            String title = "abc";
            int studentID = sg.getStudentID();
            double grade = sg.getGrade();
            model.addRow(new Object[]{enrollmentID, courseID, title, studentID, grade});
        }
    }
    public void LoadCbbCourse(){
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableManageGrade = new javax.swing.JTable();
        cbbChooseCourse = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTableManageGrade);

        cbbChooseCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChooseCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn khóa học"));

        jButton1.setText("Lưu");

        txtFind.setBorder(javax.swing.BorderFactory.createTitledBorder("Find by StudentID"));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbbChooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbbChooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> cbbChooseCourse;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableManageGrade;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}

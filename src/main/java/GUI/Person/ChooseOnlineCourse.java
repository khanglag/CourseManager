/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Person;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.StudentGradeBLL;
import DTO.OnlineCourse;
import DTO.Person;
import DTO.StudentGrade;
import GUI.forms.course.CourseOnsite;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ChooseOnlineCourse extends javax.swing.JPanel {

    CourseBLL courseBLL = new CourseBLL();
    ArrayList<OnlineCourse> list = new ArrayList<OnlineCourse>();

    PersonBLL Pbll = new PersonBLL();
    ArrayList<Person> person = new ArrayList<Person>();

    StudentGradeBLL SGbll = new StudentGradeBLL();

    DefaultTableModel model;

    public ChooseOnlineCourse() throws SQLException {
        initComponents();
        LoadData();
    }

    public void LoadData() throws SQLException {

        model = (DefaultTableModel) jtableCourses.getModel();
        model.setRowCount(0);
        list = courseBLL.getOnlineCourses();

        for (OnlineCourse on : list) {
            model.addRow(new Object[]{
                on.getCourseID(), on.getTitle(), on.getCredits(), on.getDepartmentId(), on.getUrl()
            });
            jtableCourses.setModel(model);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableCourses = new javax.swing.JTable();
        jtfFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtStudentID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();

        jtableCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Title ", "Credits", "Department ID", "URL"
            }
        ));
        jtableCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableCoursesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableCourses);

        jtfFind.setBorder(javax.swing.BorderFactory.createTitledBorder("Find courses"));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtStudentID.setBorder(javax.swing.BorderFactory.createTitledBorder("Fill studentID"));

        jButton1.setText("Join course");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtCourseID.setBorder(javax.swing.BorderFactory.createTitledBorder("Fill courseID"));
        txtCourseID.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addGap(88, 88, 88)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        model = (DefaultTableModel) jtableCourses.getModel();
        model.setRowCount(0);
        try {
            list = courseBLL.findCourseOnline(jtfFind.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CourseOnsite.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (OnlineCourse on : list) {
            model.addRow(new Object[]{
                on.getCourseID(), on.getTitle(), on.getCredits(), on.getDepartmentId(), on.getUrl()
            });
            jtableCourses.setModel(model);
        }

    }//GEN-LAST:event_btnFindActionPerformed

    private void jtableCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableCoursesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = jtableCourses.getSelectedRow();
            if (selectedRow != -1) {
                Object courseID = jtableCourses.getValueAt(selectedRow, 0);

                txtCourseID.setText(String.valueOf(courseID));

            }
        }
    }//GEN-LAST:event_jtableCoursesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String studentID = txtStudentID.getText();
        String courseID = txtCourseID.getText();
        if (studentID.equals("") || courseID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all infomation!!!!");
            return;
        } else {
            try {
                person = Pbll.findPerson(studentID);

                if (person.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "StudentID is not exist!!");
                    return;
                }
                if (person.get(0).getEnrollmentDate() == null) {
                    JOptionPane.showMessageDialog(null, "StudentID is not exist!!");
                    return;
                } else {
                    StudentGrade sg = new StudentGrade(1, Integer.parseInt(courseID), Integer.parseInt(studentID), 0.0);
                    JOptionPane.showMessageDialog(null, "Join course success!!");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChooseOnlineCourse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableCourses;
    private javax.swing.JTextField jtfFind;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}

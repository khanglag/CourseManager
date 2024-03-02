/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Person;

import BLL.CourseBLL;
import BLL.PersonBLL;
import BLL.StudentGradeBLL;
import BLL.DTO.OnsiteCourse;
import BLL.DTO.Person;
import BLL.DTO.StudentGrade;
import GUI.course.CourseOnsite;
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
public class ChooseOnsiteCourse extends javax.swing.JPanel {

    CourseBLL courseBLL = new CourseBLL();
    ArrayList<OnsiteCourse> list = new ArrayList<OnsiteCourse>();
    PersonBLL Pbll = new PersonBLL();
    ArrayList<Person> person = new ArrayList<Person>();
    StudentGradeBLL SGbll = new StudentGradeBLL();
    ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
    DefaultTableModel model;

    public ChooseOnsiteCourse() throws SQLException {
        initComponents();
        LoadData();
    }

    public void LoadData() throws SQLException {
        model = (DefaultTableModel) jTableOnsiteCourses.getModel();
        model.setRowCount(0);
        list = courseBLL.getOnsiteCourses();
        for (OnsiteCourse on : list) {
            model.addRow(new Object[]{
                on.getCourseID(), on.getTitle(), on.getCredits(), on.getDepartmentId(), on.getLocation(), on.getDays(), on.getTime()
            });
            jTableOnsiteCourses.setModel(model);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtStudentID = new javax.swing.JTextField();
        btnJoin = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOnsiteCourses = new javax.swing.JTable();

        jtfFind.setBorder(javax.swing.BorderFactory.createTitledBorder("Find courses"));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtStudentID.setBorder(javax.swing.BorderFactory.createTitledBorder("Fill studentID"));

        btnJoin.setText("Join course");
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
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
                .addComponent(btnJoin)
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
                    .addComponent(btnJoin))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTableOnsiteCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Title ", "Credits", "Department ID", "Location", "Days", "Time"
            }
        ));
        jTableOnsiteCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOnsiteCoursesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOnsiteCourses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addGap(183, 183, 183)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        model = (DefaultTableModel) jTableOnsiteCourses.getModel();
        model.setRowCount(0);
        try {
            list = courseBLL.findCourseOnsite(jtfFind.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CourseOnsite.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (OnsiteCourse on : list) {
            model.addRow(new Object[]{
                on.getCourseID(), on.getTitle(), on.getCredits(), on.getDepartmentId(), on.getLocation(), on.getDays(), on.getTime()
            });
            jTableOnsiteCourses.setModel(model);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        // TODO add your handling code here:
        String studentID = txtStudentID.getText();
        String courseID = txtCourseID.getText();
        if (studentID.equals("") || courseID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all infomation!!!!");
            return;
        }
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
                studentGrades = SGbll.findGrades(Integer.parseInt(courseID));
                for (int i = 0; i < studentGrades.size(); i++) {
                    StudentGrade s = studentGrades.get(i);
                    if ((sg.getCourseID() == s.getCourseID()) && (sg.getStudentID() == s.getStudentID())) {
                        JOptionPane.showMessageDialog(null, "Fail! Student joined class before");
                        return;
                    }
                }
                SGbll.addGrade(sg);
                JOptionPane.showMessageDialog(null, "Join course success!!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChooseOnlineCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnJoinActionPerformed

    private void jTableOnsiteCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOnsiteCoursesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = jTableOnsiteCourses.getSelectedRow();
            if (selectedRow != -1) {
                Object courseID = jTableOnsiteCourses.getValueAt(selectedRow, 0);

                txtCourseID.setText(String.valueOf(courseID));
            }
        }
    }//GEN-LAST:event_jTableOnsiteCoursesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnJoin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOnsiteCourses;
    private javax.swing.JTextField jtfFind;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}

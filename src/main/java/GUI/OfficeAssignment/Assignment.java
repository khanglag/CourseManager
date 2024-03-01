/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.OfficeAssignment;

import BLL.CourseBLL;
import BLL.CourseInstructorBLL;
import BLL.OfficeAssignmentBLL;
import BLL.PersonBLL;
import DTO.Course;
import DTO.CourseInstructor;
import DTO.OfficeAssignment;
import DTO.Person;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Assignment extends javax.swing.JPanel {

    CourseBLL Cbll = new CourseBLL();
    PersonBLL Pbll = new PersonBLL();
    OfficeAssignmentBLL OAbll = new OfficeAssignmentBLL();
    CourseInstructorBLL CIbll = new CourseInstructorBLL();
    ArrayList<Course> listCourses = new ArrayList<Course>();
    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayList<OfficeAssignment> officeAssignments = new ArrayList<OfficeAssignment>();
    ArrayList<CourseInstructor> courseInstructors = new ArrayList<CourseInstructor>();
    private int selectedRowOfTableListCourses = -1;
    private int selectedRowOfTableListInstructors = -1;

    public Assignment() throws SQLException {
        initComponents();
        loadDataListCourses();
        loadDataListInstructor();
        loadDataAssignment();
    }

    public void loadDataListCourses() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTableListCourse.getModel();
        model.setRowCount(0);
        listCourses = Cbll.getCourses();
        for (int i = 0; i < listCourses.size(); i++) {
            Course course = listCourses.get(i);
            int courseID = course.getCourseID();
            String title = course.getTitle();
            int credits = course.getCredits();
            int deparmentID = course.getDepartmentId();
            model.addRow(new Object[]{i + 1, courseID, title, credits, deparmentID});
        }
    }

    public void loadDataListInstructor() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTableListInstructor.getModel();
        model.setRowCount(0);
        persons = Pbll.getAllPerson();
        int count = 1;
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getHireDate() != null) {
                int instructorID = person.getPersonID();
                String firstName = person.getFirstName();
                String lastName = person.getLastName();
                Date hiDate = person.getHireDate();
                model.addRow(new Object[]{count, instructorID, firstName, lastName, hiDate});
                count++;
            }
        }
    }

    public void loadDataAssignment() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jtableAssignment.getModel();
        model.setRowCount(0);
        officeAssignments = OAbll.getAllAssignment();
        String firstName = "";
        for (int i = 0; i < officeAssignments.size(); i++) {
            OfficeAssignment oa = officeAssignments.get(i);
            int courseID = CIbll.findByPersonID(oa.getInstructorID()).get(0).getCourseID();
            String title = Cbll.findCourse(String.valueOf(courseID)).get(0).getTitle();
            model.addRow(new Object[]{courseID, title, oa.getInstructorID(), Pbll.findPerson(String.valueOf(oa.getInstructorID())).get(0).getFirstName(), oa.getLocation(), oa.getTimeStamp()});

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAssignment = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTimestamp = new javax.swing.JTextField();
        txtInstructorID = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtCourseID = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListInstructor = new javax.swing.JTable();
        btnChooseInstructorID = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableListCourse = new javax.swing.JTable();
        btnChooseCourseID = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jtableAssignment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CourseId", "Title", "InstructorID", "FirstName", "Location", "Timestamp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableAssignmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableAssignment);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Assignment"));

        txtTimestamp.setText("yyyy-mm-dd hh:mm:ss");
        txtTimestamp.setBorder(javax.swing.BorderFactory.createTitledBorder("Timestamp"));
        txtTimestamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimestampActionPerformed(evt);
            }
        });

        txtInstructorID.setBorder(javax.swing.BorderFactory.createTitledBorder("InstructorID"));
        txtInstructorID.setEnabled(false);

        txtLocation.setBorder(javax.swing.BorderFactory.createTitledBorder("Location"));

        btnAdd.setText("Add ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtCourseID.setBorder(javax.swing.BorderFactory.createTitledBorder("CourseID"));
        txtCourseID.setEnabled(false);
        txtCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(txtLocation))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInstructorID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstructorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimestamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose InstructorID"));

        jTableListInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Number", "InstructorID", "FirstName", "LastName", "HireDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListInstructorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableListInstructor);

        btnChooseInstructorID.setText("Choose");
        btnChooseInstructorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseInstructorIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChooseInstructorID)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseInstructorID))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose CourseID"));

        jTableListCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Number", "CourseID", "Title", "Credits", "DeparmentID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableListCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListCourseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableListCourse);

        btnChooseCourseID.setText("Choose");
        btnChooseCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCourseIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChooseCourseID)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseCourseID)
                .addGap(0, 0, 0))
        );

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimestampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimestampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimestampActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtInstructorID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select row to delete assignment");
            return;
        }
        try {
            // TODO add your handling code here:
            CourseInstructor CI = new CourseInstructor(Integer.parseInt(txtCourseID.getText()), Integer.parseInt(txtInstructorID.getText()));
            OAbll.deleteAssignment(Integer.parseInt(txtInstructorID.getText()));
            CIbll.deleteInstructor(CI);
            JOptionPane.showMessageDialog(null, "Delete success instructor id = " + txtInstructorID.getText());
            loadDataAssignment();
            return;
        } catch (SQLException ex) {
            Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIDActionPerformed

    private void jTableListCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListCourseMouseClicked

        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            selectedRowOfTableListCourses = jTableListCourse.getSelectedRow();
        }
    }//GEN-LAST:event_jTableListCourseMouseClicked

    private void btnChooseCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCourseIDActionPerformed
        // TODO add your handling code here:
        if (selectedRowOfTableListCourses != -1) {
            Object courseIDObject = jTableListCourse.getValueAt(selectedRowOfTableListCourses, 1);
            if (courseIDObject != null) {
                int courseID = Integer.parseInt(courseIDObject.toString());
                txtCourseID.setText(String.valueOf(courseID));
            }
        } else {
            Object courseIDObject = jTableListCourse.getValueAt(selectedRowOfTableListCourses, 1);
        }
    }//GEN-LAST:event_btnChooseCourseIDActionPerformed

    private void btnChooseInstructorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseInstructorIDActionPerformed
        // TODO add your handling code here:
        if (selectedRowOfTableListInstructors != -1) {
            Object instructorIDObject = jTableListInstructor.getValueAt(selectedRowOfTableListInstructors, 1);
            if (instructorIDObject != null) {
                int courseID = Integer.parseInt(instructorIDObject.toString());
                txtInstructorID.setText(String.valueOf(courseID));
            }
        } else {
            Object courseIDObject = jTableListInstructor.getValueAt(selectedRowOfTableListInstructors, 1);
        }
    }//GEN-LAST:event_btnChooseInstructorIDActionPerformed

    private void jTableListInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListInstructorMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            selectedRowOfTableListInstructors = jTableListInstructor.getSelectedRow();
        }
    }//GEN-LAST:event_jTableListInstructorMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String courseIDStr = txtCourseID.getText();
        String instructorIDStr = txtInstructorID.getText();
        String location = txtLocation.getText();
        String ts = txtTimestamp.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (courseIDStr.isEmpty() || instructorIDStr.isEmpty() || location.isEmpty() || ts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
            return;
        }
        try {
            Date date = dateFormat.parse(ts);
            Timestamp timestamp = new Timestamp(date.getTime());
            try {
                int courseID = Integer.parseInt(courseIDStr);
                int instructorID = Integer.parseInt(instructorIDStr);
                OfficeAssignment oa = new OfficeAssignment(instructorID, location, timestamp);
                CourseInstructor ci = new CourseInstructor(courseID, instructorID);
                System.out.println("Du lieu moi:   " + oa);
                officeAssignments = OAbll.findAssignments(instructorID);
                if (officeAssignments.isEmpty()) {
                    OAbll.addAssignment(oa);
                    CIbll.addInstructor(ci);
                    JOptionPane.showMessageDialog(null, "Success!");
                    loadDataAssignment();
                } else {
                    JOptionPane.showMessageDialog(null, "Fail! Instructor assigned before");
                    return;
                }

            } catch (NumberFormatException e) {
                // Handle the case when parsing fails
                System.out.println("Invalid input for Course ID or Instructor ID. Please enter valid integers.");
            } catch (SQLException ex) {
                Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Please fill yyyy-MM-dd HH:mm:ss");
            return;
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        this.txtCourseID.setText("");
        this.txtInstructorID.setText("");
        this.txtLocation.setText("");
        this.txtTimestamp.setText("yyyy-mm-dd hh:mm:ss");

    }//GEN-LAST:event_btnResetActionPerformed

    private void jtableAssignmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableAssignmentMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Đảm bảo rằng đó là một lần click đơn, bạn có thể thay đổi số click cần thiết
            int selectedRow = jtableAssignment.getSelectedRow();
            if (selectedRow != -1) {
                Object courseID = jtableAssignment.getValueAt(selectedRow, 0);
                Object instructorID = jtableAssignment.getValueAt(selectedRow, 2);
                Object location = jtableAssignment.getValueAt(selectedRow, 4);
                Object timestamp = jtableAssignment.getValueAt(selectedRow, 5);
                txtInstructorID.setText(String.valueOf(instructorID));
                txtCourseID.setText(String.valueOf(courseID));
                txtLocation.setText(String.valueOf(location));
                txtTimestamp.setText(String.valueOf(timestamp));

            }
        }
    }//GEN-LAST:event_jtableAssignmentMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String courseIDStr = txtCourseID.getText();
        String instructorIDStr = txtInstructorID.getText();
        String location = txtLocation.getText();
        String ts = txtTimestamp.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (courseIDStr.isEmpty() || instructorIDStr.isEmpty() || location.isEmpty() || ts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all information");
            return;
        }
        try {
            Date date = dateFormat.parse(ts);
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);
            try {
                int courseID = Integer.parseInt(courseIDStr);
                int instructorID = Integer.parseInt(instructorIDStr);
               
                OfficeAssignment oa = new OfficeAssignment(instructorID, location, timestamp);
                CourseInstructor ci = new CourseInstructor(courseID, instructorID);
                    
                System.out.println(oa);
                OAbll.updateAssignment(oa);
//                CIbll.up(ci);

                JOptionPane.showMessageDialog(null, "Success!");
                loadDataAssignment();
            } catch (NumberFormatException e) {
                // Handle the case when parsing fails
                System.out.println("Invalid input for Course ID or Instructor ID. Please enter valid integers.");
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Please fill yyyy-MM-dd HH:mm:ss");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseCourseID;
    private javax.swing.JButton btnChooseInstructorID;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableListCourse;
    private javax.swing.JTable jTableListInstructor;
    private javax.swing.JTable jtableAssignment;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtInstructorID;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtTimestamp;
    // End of variables declaration//GEN-END:variables
}

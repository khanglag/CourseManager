/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import GUI.course.CourseManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khang
 */
public class MainFrame extends javax.swing.JFrame {

   

    public MainFrame() {
        initComponents();
        TrinhDieuKhien();
        
    }
    private void TrinhDieuKhien() {
        Controller controller = new Controller(jpnView);
        List<DanhMucBean> listItem = new ArrayList<>();

        // listItem.add(new DanhMucBean("TrangChinh",jpnTrangChu,jlbTrangChu));
        // listItem.add(new
        // DanhMucBean("PhieuNhapHang",panelPhieuNhap,jLabelPhieuNhap));
        listItem.add(new DanhMucBean("Course", panelCourse, jLabelCourse));
        listItem.add(new DanhMucBean("Person", panelPersion, jLabelPersion));
        listItem.add(new DanhMucBean("Department", panelDepartment, jLabelDepartment));
        listItem.add(new DanhMucBean("StudentGrade", panelGrade, jLabelGrade));
        listItem.add(new DanhMucBean("OfficeAssignment", panelOfficeAssignment, jLabelOfficeAssignment));

        controller.setEvent(listItem);
        try {
            controller.setView(panelCourse, jLabelCourse);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        panelGrade = new javax.swing.JPanel();
        jLabelGrade = new javax.swing.JLabel();
        panelCourse = new javax.swing.JPanel();
        jLabelCourse = new javax.swing.JLabel();
        panelPersion = new javax.swing.JPanel();
        jLabelPersion = new javax.swing.JLabel();
        panelDepartment = new javax.swing.JPanel();
        jLabelDepartment = new javax.swing.JLabel();
        panelOfficeAssignment = new javax.swing.JPanel();
        jLabelOfficeAssignment = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane10.setBackground(new java.awt.Color(189, 205, 214));
        jScrollPane10.setForeground(new java.awt.Color(189, 205, 214));
        jScrollPane10.setHorizontalScrollBar(null);

        panelMenu.setBackground(new java.awt.Color(160, 191, 213));

        panelGrade.setBackground(new java.awt.Color(67, 138, 174));
        panelGrade.setForeground(new java.awt.Color(255, 255, 255));

        jLabelGrade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelGrade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGrade.setText("Grade");

        javax.swing.GroupLayout panelGradeLayout = new javax.swing.GroupLayout(panelGrade);
        panelGrade.setLayout(panelGradeLayout);
        panelGradeLayout.setHorizontalGroup(
            panelGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGradeLayout.setVerticalGroup(
            panelGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCourse.setBackground(new java.awt.Color(67, 138, 174));

        jLabelCourse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelCourse.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCourse.setText("Course");

        javax.swing.GroupLayout panelCourseLayout = new javax.swing.GroupLayout(panelCourse);
        panelCourse.setLayout(panelCourseLayout);
        panelCourseLayout.setHorizontalGroup(
            panelCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCourseLayout.setVerticalGroup(
            panelCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPersion.setBackground(new java.awt.Color(67, 138, 174));
        panelPersion.setForeground(new java.awt.Color(255, 255, 255));

        jLabelPersion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelPersion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPersion.setText("Person");

        javax.swing.GroupLayout panelPersionLayout = new javax.swing.GroupLayout(panelPersion);
        panelPersion.setLayout(panelPersionLayout);
        panelPersionLayout.setHorizontalGroup(
            panelPersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPersionLayout.setVerticalGroup(
            panelPersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPersion, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelDepartment.setBackground(new java.awt.Color(67, 138, 174));
        panelDepartment.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDepartment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDepartment.setText("Department");

        javax.swing.GroupLayout panelDepartmentLayout = new javax.swing.GroupLayout(panelDepartment);
        panelDepartment.setLayout(panelDepartmentLayout);
        panelDepartmentLayout.setHorizontalGroup(
            panelDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepartmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDepartmentLayout.setVerticalGroup(
            panelDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepartmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelOfficeAssignment.setBackground(new java.awt.Color(67, 138, 174));
        panelOfficeAssignment.setForeground(new java.awt.Color(255, 255, 255));

        jLabelOfficeAssignment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelOfficeAssignment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOfficeAssignment.setText("Office Assignment");

        javax.swing.GroupLayout panelOfficeAssignmentLayout = new javax.swing.GroupLayout(panelOfficeAssignment);
        panelOfficeAssignment.setLayout(panelOfficeAssignmentLayout);
        panelOfficeAssignmentLayout.setHorizontalGroup(
            panelOfficeAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOfficeAssignmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOfficeAssignment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOfficeAssignmentLayout.setVerticalGroup(
            panelOfficeAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOfficeAssignmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOfficeAssignment, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelPersion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelOfficeAssignment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOfficeAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(panelMenu);

        jpnView.setBackground(new java.awt.Color(176, 206, 221));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(160, 191, 213));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCourse;
    private javax.swing.JLabel jLabelDepartment;
    private javax.swing.JLabel jLabelGrade;
    private javax.swing.JLabel jLabelOfficeAssignment;
    private javax.swing.JLabel jLabelPersion;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel panelCourse;
    private javax.swing.JPanel panelDepartment;
    private javax.swing.JPanel panelGrade;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelOfficeAssignment;
    private javax.swing.JPanel panelPersion;
    // End of variables declaration//GEN-END:variables
}

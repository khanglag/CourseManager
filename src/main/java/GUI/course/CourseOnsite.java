/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.course;

import BLL.CourseBLL;
import BLL.DTO.OnsiteCourse;
import GUI.Hander.StringToLocalTimeConverter;
import GUI.MainFrame;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khang
 */
public class CourseOnsite extends javax.swing.JPanel {

    /**
     * Creates new form CourseOnsite
     */
    CourseBLL courseBLL = new CourseBLL();
    DefaultTableModel model;
    ArrayList<OnsiteCourse> list = new ArrayList<OnsiteCourse>();

    public CourseOnsite() throws SQLException {
        initComponents();
        LoadData();
        button();
    }

    public void button(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int i) {
                int id = Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());
                String title = jTable1.getModel().getValueAt(i, 1).toString();
                int credit = Integer.parseInt(jTable1.getModel().getValueAt(i, 2).toString());
                int deid = Integer.parseInt(jTable1.getModel().getValueAt(i, 3).toString());
                String location = jTable1.getModel().getValueAt(i, 4).toString();
                String day = jTable1.getModel().getValueAt(i, 5).toString();

                LocalTime t = StringToLocalTimeConverter.stringToLocalTime(jTable1.getModel().getValueAt(i, 6).toString());

                OnsiteCourse o = new OnsiteCourse(id,title,credit,deid,location,day,t);
                System.out.print(o);
                EditOnsite edit = new EditOnsite(new MainFrame(),o);
                edit.setVisible(true);
                courseBLL = new CourseBLL();
                try {
                    LoadData();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseOnline.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                int choice = JOptionPane.showConfirmDialog(new MainFrame(), "Are you sure you want to delete?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                // Perform delete operation
                
                    int id = Integer.parseInt(jTable1.getModel().getValueAt(row, 0).toString());
                     try {
                         if(courseBLL.deleteCourseOnsite(id)==1){
                             JOptionPane.showMessageDialog(jPanel1, "Success");
                         }else
                             JOptionPane.showMessageDialog(jPanel1, "Fail");
                     } catch (SQLException ex) {
                         Logger.getLogger(CourseOnline.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     courseBLL = new CourseBLL();
                     try {
                         LoadData();
                     } catch (SQLException ex) {
                         Logger.getLogger(CourseOnline.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
            }

            @Override
            public void onView(int i) {
                int id = Integer.parseInt(jTable1.getModel().getValueAt(i, 0).toString());
                String title = jTable1.getModel().getValueAt(i, 1).toString();
                int credit = Integer.parseInt(jTable1.getModel().getValueAt(i, 2).toString());
                int deid = Integer.parseInt(jTable1.getModel().getValueAt(i, 3).toString());
                String location = jTable1.getModel().getValueAt(i, 4).toString();
                String day = jTable1.getModel().getValueAt(i, 5).toString();

                LocalTime t = StringToLocalTimeConverter.stringToLocalTime(jTable1.getModel().getValueAt(i, 6).toString());

                OnsiteCourse o = new OnsiteCourse(id,title,credit,deid,location,day,t);
                
               CourseOnsiteRead r;
                try {
                    r = new CourseOnsiteRead(new javax.swing.JFrame(), o);
                    r.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CourseOnsite.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        };
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
        
    }
    
    public void LoadData() throws SQLException {
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        list = courseBLL.getOnsiteCourses();

        for (OnsiteCourse on : list) {
            model.addRow(new Object[] {
                      on.getCourseID(),on.getTitle(),on.getCredits(),on.getDepartmentId(),on.getLocation(),on.getDays(),on.getTime()
                });
                jTable1.setModel(model);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jtfFind.setBorder(javax.swing.BorderFactory.createTitledBorder("Find:"));

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Title ", "Credits", "Department ID", "Location", "Days", "Time", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(7).setMinWidth(160);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(160);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jtfFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addGap(209, 209, 209))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            list = courseBLL.findCourseOnsite(jtfFind.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CourseOnsite.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (OnsiteCourse on : list) {
            model.addRow(new Object[] {
                      on.getCourseID(),on.getTitle(),on.getCredits(),on.getDepartmentId(),on.getLocation(),on.getDays(),on.getTime()
                });
                jTable1.setModel(model);
        }

    }//GEN-LAST:event_btnFindActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfFind;
    // End of variables declaration//GEN-END:variables
}

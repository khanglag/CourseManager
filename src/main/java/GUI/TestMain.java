/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.forms.course.Course;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author khang
 */
public class TestMain {
    public static void main(String[] args){
        JFrame frame = new JFrame("Tabbed Pane Example");

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tạo các panel con
        JPanel panel1 = new Course();
        panel1.add(new JLabel("This is Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("This is Panel 3"));

        // Thêm các panel vào JTabbedPane với tiêu đề tương ứng
        tabbedPane.addTab("Tab 1", panel1);
        tabbedPane.addTab("Tab 2", panel2);
        tabbedPane.addTab("Tab 3", panel3);

        // Thêm JTabbedPane vào JFrame
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Cấu hình JFrame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}

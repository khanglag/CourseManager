/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author khang
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // Đảm bảo không có màu nền được vẽ
        setFocusPainted(false); // Không vẽ khung khi focus vào nút
        setBorderPainted(false); // Không vẽ viền của nút
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Không vẽ viền
    }

    // Tạo một hình tròn với kích thước nhỏ hơn kích thước của nút
    Shape shape;

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Round Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new RoundButton("Round Button");

        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

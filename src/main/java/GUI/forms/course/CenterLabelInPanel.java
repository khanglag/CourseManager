/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.forms.course;

import javax.swing.*;
import java.awt.*;

public class CenterLabelInPanel extends JFrame {
    public CenterLabelInPanel() {
        setTitle("Center Label with Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Cách lề

        JLabel label = new JLabel("Centered Label");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn giữa cho label

        JButton button = new JButton("Button");

        // Đặt label ở giữa
        gbc.gridx = 0; // Đặt vị trí theo cột
        gbc.gridy = 0; // Đặt vị trí theo hàng
        gbc.gridwidth = 1; // Sét chiều rộng của thành phần
        gbc.anchor = GridBagConstraints.CENTER; // Đặt vị trí theo giữa
        panel.add(label, gbc);

        // // Đặt nút ở phía bên phải
        // gbc.gridx = 1; // Đặt vị trí theo cột
        // gbc.anchor = GridBagConstraints.LINE_END; // Đặt vị trí theo phía cuối
        // gbc.weightx = 1.0; // Cho phép nút chiếm hết phần trống bên phải của JPanel
        // panel.add(button, gbc);

        add(panel);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hìnhHiển thị cửa sổ ở giữa màn hình
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CenterLabelInPanel example = new CenterLabelInPanel();
            example.setVisible(true);
        });
    }
}

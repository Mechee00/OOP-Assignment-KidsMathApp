package gui;

import javax.swing.*;
import java.awt.*;

public class GUI_Util extends JFrame {
    // protected static final int SWIDTH = 1280, SHEIGHT = 720; // 1366 x 768
    protected static final int SWIDTH = 1366, SHEIGHT = 768; // 1366 x 768
    // protected static final int SWIDTH = 1920, SHEIGHT = 1080; // 1920 x 1080

    static void cInit(JFrame frame) {
        // Set frame size
        // frame.setMinimumSize(new Dimension(SWIDTH, SHEIGHT));
        frame.setPreferredSize(new Dimension(SWIDTH, SHEIGHT));
        // frame.setMaximumSize(new Dimension(SWIDTH, SHEIGHT));
        frame.setSize(SWIDTH, SHEIGHT);
        frame.setResizable(false);

        // Set decoration
        frame.setUndecorated(true);
        // Set Tittle
        frame.setTitle("Maths Fever V0.1 by Cheah Pin Chee");
        // Set Close Action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pack GUI
        frame.pack();
        // Set location relative
        frame.setLocationRelativeTo(null);
        // Set Visible
        frame.setVisible(true);
    }

    static void setPane(JFrame frame, JPanel panel, boolean visible) {
        frame.pack();
        frame.setContentPane(panel);
        frame.setVisible(visible);
    }

    static void setContentPane(JPanel parentPanel, JPanel contentPanel) {
        parentPanel.removeAll();
        parentPanel.add(contentPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    static void setComptIcon(JComponent component, double scaleFactor, String imgSource) {

        component.setBorder(null);
        component.setOpaque(false);

        ImageIcon imageIcon = new ImageIcon(imgSource);
        Image newimg = imageIcon.getImage().getScaledInstance((int)(imageIcon.getIconWidth() * scaleFactor),
                (int)(imageIcon.getIconHeight() * scaleFactor), java.awt.Image.SCALE_SMOOTH);

        imageIcon = new ImageIcon(newimg); // transform it back to an icon
        if (component instanceof JLabel) {
            JLabel lbl = (JLabel)component;
            lbl.setIcon(imageIcon);
        } else if (component instanceof JButton) {
            JButton btn = (JButton)component;
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setIcon(imageIcon);
        }
    }

    static void makeTransparent(JComponent component) {
        component.setBorder(null);
        component.setOpaque(false);
    }

}

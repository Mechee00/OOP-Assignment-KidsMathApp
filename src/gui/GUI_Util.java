package gui;

import javax.swing.*;
import java.awt.*;

public class GUI_Util extends JFrame {
    // protected static final int SWIDTH = 1280, SHEIGHT = 720; // 1366 x 768
    protected static final int SWIDTH = 1366, SHEIGHT = 768; // 1366 x 768
    // protected static final int SWIDTH = 1920, SHEIGHT = 1080; // 1920 x 1080

    static void cInit(JFrame frame, JPanel panel) {
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
        // Set Panel to show
        frame.setContentPane(panel);
        // Pack GUI
        frame.pack();
        // Set location relative
        frame.setLocationRelativeTo(null);
        // Set Visible
        frame.setVisible(true);
    }

    // Set or change panel or precisely siwtch card of a panel in card layout
    static void setContentPane(JPanel parentPanel, JPanel contentPanel) {
        parentPanel.removeAll(); // Remove every panel or component
        parentPanel.add(contentPanel); // Add new panel panel to show
        parentPanel.repaint(); // Repaint the panel
        parentPanel.revalidate(); // Validate the panel
    }

    // Set the graphics for the jcomponent mostly for lbl and btn
    static void setComptIcon(JComponent component, double scaleFactor, String imgSource) {

        // Remove the border and set it to transparent
        makeTransparent(component);

        // Get the image as icon and apply scale to size the graphcis
        ImageIcon imageIcon = new ImageIcon(imgSource);
        Image newimg = imageIcon.getImage().getScaledInstance((int)(imageIcon.getIconWidth() * scaleFactor),
                (int)(imageIcon.getIconHeight() * scaleFactor), java.awt.Image.SCALE_SMOOTH);

        imageIcon = new ImageIcon(newimg); // transform it back to an icon
        // Set the icon base on the component
        if (component instanceof JLabel) {
            // Set the graphics for labels
            JLabel lbl = (JLabel)component; // Convert JComponent to JLabel
            lbl.setIcon(imageIcon);
        } else if (component instanceof JButton) {
            // Set the graphics for buttons
            JButton btn = (JButton)component; // Convert JComponent to JButton
            btn.setContentAreaFilled(false);
            btn.setFocusPainted(false);
            btn.setIcon(imageIcon);
        }
    }

    // Set the component to be transparent
    // Special use case for text fields w
    static void makeTransparent(JComponent component) {
        component.setBorder(null);
        component.setOpaque(false);
    }

}

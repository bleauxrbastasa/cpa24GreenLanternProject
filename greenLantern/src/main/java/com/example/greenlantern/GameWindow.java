package com.example.greenlantern;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
    private JPanel currentPanel;

    public GameWindow() {
        setTitle("ComplianceChecker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        currentPanel = new JPanel(); // Placeholder for actual game panels
        add(currentPanel);
    }

    public void setPanel(JPanel panel) {
        remove(currentPanel);
        currentPanel = panel;
        add(currentPanel);
        validate();
        repaint();
    }
}

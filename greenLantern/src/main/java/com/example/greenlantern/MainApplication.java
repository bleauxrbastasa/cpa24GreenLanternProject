package com.example.greenlantern;

import com.example.greenlantern.GameStateManager;
import com.example.greenlantern.GameWindow;
import javax.swing.*;

public class MainApplication {
    private JFrame mainFrame;
    private GameStateManager gameStateManager;

    public MainApplication() {
        initialize();
    }

    private void initialize() {
        mainFrame = new JFrame("ComplianceChecker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        gameStateManager = new GameStateManager(mainFrame);
        gameStateManager.showMainMenu(); // Transition to main menu

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainApplication();
    }
}



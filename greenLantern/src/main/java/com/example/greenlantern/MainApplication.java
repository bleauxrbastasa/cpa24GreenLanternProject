package com.example.greenlantern;

import com.example.greenlantern.GameStateManager;
import com.example.greenlantern.GameWindow;
import javax.swing.*;

public class MainApplication {
    private GameWindow gameWindow;
    private GameStateManager gameStateManager;

    public MainApplication() {
        initialize();
    }

    private void initialize() {
        gameWindow = new GameWindow();
        gameStateManager = new GameStateManager(gameWindow);
        gameStateManager.showMainMenu(); // Transition to main menu
    }

    public static void main(String[] args) {
        new MainApplication();
    }
}

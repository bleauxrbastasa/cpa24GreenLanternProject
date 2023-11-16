package com.example.greenlantern;

import com.example.greenlantern.GameStateManager;
import com.example.greenlantern.GameWindow;

public class MainApplication {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameStateManager gameStateManager = new GameStateManager(gameWindow);
        gameStateManager.startGame();
    }
}

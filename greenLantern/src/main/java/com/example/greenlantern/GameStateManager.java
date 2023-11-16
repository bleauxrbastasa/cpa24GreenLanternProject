package com.example.greenlantern;
import javax.swing.*;

public class GameStateManager {
    private JFrame mainFrame;

    public GameStateManager(JFrame frame) {
        this.mainFrame = frame;
    }

    public void showMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(mainMenu);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void startGame() {
        // Logic to start the game
        // Example: mainFrame.getContentPane().add(new GamePanel());
    }
}



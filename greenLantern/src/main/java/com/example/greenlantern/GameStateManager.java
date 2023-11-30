package com.example.greenlantern;

public class GameStateManager {
    private GameWindow gameWindow;
    private QueueManager queueManager;
    private DecisionEngine decisionEngine;

    public GameStateManager(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.queueManager = new QueueManager();
        this.decisionEngine = new DecisionEngine();
    }

    public void showMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        gameWindow.setPanel(mainMenu);
    }

    public void startGame() {
        GamePanel gamePanel = new GamePanel(queueManager, decisionEngine);
        gameWindow.setPanel(gamePanel);
    }
}

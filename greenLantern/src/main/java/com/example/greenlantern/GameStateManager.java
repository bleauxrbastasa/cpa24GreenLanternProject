package com.example.greenlantern;

public class GameStateManager {
    private GameWindow gameWindow;

    public GameStateManager(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void showMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        gameWindow.setPanel(mainMenu);
    }

    public void startGame() {
        GamePanel gamePanel = new GamePanel();
        gameWindow.setPanel(gamePanel);
    }
}

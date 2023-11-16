package com.example.greenlantern;

public class GameStateManager {
    private GameWindow gameWindow;
    private GameState currentState;

    public GameStateManager(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.currentState = GameState.START_SCREEN; // Assuming an enum for game states
    }

    public void startGame() {
        switch (currentState) {
            case START_SCREEN:
                // Initialize start screen
                break;
            case IN_GAME:
                // Initialize game environment
                break;
            case GAME_OVER:
                // Handle game over logic
                break;
        }
    }

    public void changeState(GameState newState) {
        this.currentState = newState;
        startGame();
    }
}




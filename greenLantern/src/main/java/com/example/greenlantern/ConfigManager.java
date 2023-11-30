package com.example.greenlantern;

public class ConfigManager {
    private String playerName;
    private String difficulty;

    // Methods to manage game configuration settings
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}


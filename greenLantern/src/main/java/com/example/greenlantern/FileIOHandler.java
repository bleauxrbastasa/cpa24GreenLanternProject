package com.example.greenlantern;

import java.io.File;

import java.io.*;

public class FileIOHandler {
    public void saveGameState(File file, GameState gameState) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameState loadGameState(File file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (GameState) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}


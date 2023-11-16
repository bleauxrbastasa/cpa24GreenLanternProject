package com.example.greenlantern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    private JButton startButton;
    private JButton exitButton;
    private GameStateManager gameStateManager;

    public MainMenu(GameStateManager manager) {
        this.gameStateManager = manager;
        initializeComponents();
        layoutComponents();
        initializeEventListeners();
    }

    private void initializeComponents() {
        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");
    }

    private void layoutComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(startButton);
        add(exitButton);
    }

    private void initializeEventListeners() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStateManager.startGame();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

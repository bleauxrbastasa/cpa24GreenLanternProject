package com.example.greenlantern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private DocumentPanel documentPanel;
    private QueueManager queueManager;
    private JLabel scoreLabel;
    private JButton nextCharacterButton;
    private RuleSetDisplay ruleSetDisplay;
    private int score = 0;

    public GamePanel() {
        setLayout(new BorderLayout());
        queueManager = new QueueManager(); // Assume queueManager is already populated
        documentPanel = new DocumentPanel(new DecisionEngine());
        ruleSetDisplay = new RuleSetDisplay();

        JPanel topPanel = new JPanel(new BorderLayout());
        scoreLabel = new JLabel("Score: " + score);
        topPanel.add(scoreLabel, BorderLayout.NORTH);
        topPanel.add(ruleSetDisplay, BorderLayout.CENTER);

        nextCharacterButton = new JButton("Next Character");
        nextCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNextCharacter();
            }
        });

        add(topPanel, BorderLayout.NORTH);
        add(documentPanel, BorderLayout.CENTER);
        add(nextCharacterButton, BorderLayout.SOUTH);
    }

    private void loadNextCharacter() {
        CharacterProfile nextCharacter = queueManager.removeFromQueue();
        if (nextCharacter != null) {
            Document nextDocument = nextCharacter.getDocuments()[0]; // Assume one document per character for simplicity
            documentPanel.displayDocument(nextDocument);
        } else {
            // Handle the case when the queue is empty
            JOptionPane.showMessageDialog(this, "No more characters in the queue.");
        }
    }

    public void updateScore(boolean decisionMadeCorrectly) {
        if (decisionMadeCorrectly) {
            score++;
        } else {
            score--;
        }
        scoreLabel.setText("Score: " + score);
    }
}

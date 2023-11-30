package com.example.greenlantern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private DocumentPanel documentPanel;
    private QueueManager queueManager;
    private RuleSetDisplay ruleSetDisplay;
    private JLabel scoreLabel;
    private JButton nextCharacterButton;
    private DecisionEngine decisionEngine;

    public GamePanel(QueueManager queueManager, DecisionEngine decisionEngine) {
        this.queueManager = queueManager;
        this.decisionEngine = decisionEngine;
        setLayout(new BorderLayout());

        documentPanel = new DocumentPanel(decisionEngine, this);

        ruleSetDisplay = new RuleSetDisplay();
        scoreLabel = new JLabel("Score: " + decisionEngine.getScore());

        nextCharacterButton = new JButton("Next Character");
        nextCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNextCharacter();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(ruleSetDisplay);
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);
        add(documentPanel, BorderLayout.CENTER);
        add(nextCharacterButton, BorderLayout.SOUTH);

        // Load the first character upon initialization
        loadNextCharacter();
    }

    public void loadNextCharacter() {
        if (queueManager.getQueueSize() > 0) {
            CharacterProfile nextCharacter = queueManager.removeFromQueue();
            Document nextDocument = nextCharacter.getDocuments()[0]; // Assuming one document per character
            documentPanel.displayDocument(nextDocument, nextCharacter); // Pass both document and character

            // Removed the JOptionPane to make the character details appear in the document panel
        } else {
            JOptionPane.showMessageDialog(this, "No more characters in the queue.");
        }
        updateScore();
    }

    public void updateScore() {
        scoreLabel.setText("Score: " + decisionEngine.getScore());
    }
}

package com.example.greenlantern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentPanel extends JPanel {
    private JLabel documentLabel;
    private JLabel characterLabel;
    private JButton approveButton;
    private JButton rejectButton;
    private DecisionEngine decisionEngine;
    private Document currentDocument;
    private CharacterProfile currentCharacter; // Added field for current character
    private GamePanel gamePanel;

    public DocumentPanel(DecisionEngine decisionEngine, GamePanel gamePanel) {
        this.decisionEngine = decisionEngine;
        this.gamePanel = gamePanel;
        setLayout(new BorderLayout());

        characterLabel = new JLabel();
        documentLabel = new JLabel();
        add(characterLabel, BorderLayout.NORTH);
        add(documentLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        approveButton = new JButton("Approve");
        rejectButton = new JButton("Reject");
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        add(buttonPanel, BorderLayout.SOUTH);

        initializeEventListeners();
    }


    public String getDocumentLabelText() {
        return documentLabel.getText();
    }



    public void displayDocument(Document document, CharacterProfile character) {
        this.currentDocument = document;
        this.currentCharacter = character; // Set the current character

        // Displaying document details
        String discrepancyInfo = document.hasDiscrepancy() ? "Yes" : "No";
        documentLabel.setText("<html>Document Type: " + document.getDocumentType() +
                "<br>Issue Date: " + Utils.formatDate(document.getIssueDate()) +
                "<br>Expiry Date: " + Utils.formatDate(document.getExpiryDate()) +
                "<br>(FOR TESTING ONLY, TO BE REMOVED) Discrepancy: " + discrepancyInfo + "</html>");

        // Displaying character details
        characterLabel.setText(formatCharacterInfo(character));
    }

    private String formatCharacterInfo(CharacterProfile character) {
        // Format the character information
        return "<html>Name: " + character.getName() + "<br>Description: " + character.getCharacterDescription() +
                "<br>ASCII Art:<br>" + character.getAsciiArt() + "</html>";
    }

    private void initializeEventListeners() {
        approveButton.addActionListener(e -> processDecision(true));
        rejectButton.addActionListener(e -> processDecision(false));
    }

    private void processDecision(boolean approved) {
        if (currentDocument != null) {
            decisionEngine.processDecision(currentDocument, approved);
            gamePanel.loadNextCharacter(); // Load next character after decision
        }
    }
}

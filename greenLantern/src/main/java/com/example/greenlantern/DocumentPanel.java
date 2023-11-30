package com.example.greenlantern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentPanel extends JPanel {
    private JLabel documentLabel;
    private JButton approveButton;
    private JButton rejectButton;
    private DecisionEngine decisionEngine;
    private Document currentDocument; // Variable to hold the current document

    public DocumentPanel(DecisionEngine decisionEngine) {
        this.decisionEngine = decisionEngine;
        setLayout(new BorderLayout());

        documentLabel = new JLabel();
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


    public void displayDocument(Document document) {
        this.currentDocument = document; // Update the current document
        documentLabel.setText("<html>Document Type: " + document.getDocumentType() + "<br>Issue Date: " +
                Utils.formatDate(document.getIssueDate()) + "<br>Expiry Date: " +
                Utils.formatDate(document.getExpiryDate()) + "</html>");
    }

    private void initializeEventListeners() {
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decisionEngine.processDecision(currentDocument, true); // Use currentDocument
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decisionEngine.processDecision(currentDocument, false); // Use currentDocument
            }
        });
    }
}

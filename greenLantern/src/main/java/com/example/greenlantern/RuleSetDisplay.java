package com.example.greenlantern;

import javax.swing.*;

public class RuleSetDisplay extends JPanel {
    // Code to display the current set of rules

    private JTextArea rulesTextArea;

    public RuleSetDisplay() {
        initializeComponents();
        layoutComponents();
        // Load rules into the text area
        loadRules();
    }

    private void initializeComponents() {
        rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(rulesTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private void layoutComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Rules:"));
        add(rulesTextArea);
    }

    private void loadRules() {
        // Place your rules here
        String rules = "1. Process as many documents as possible\n"
                + "2. Do not accept discreptancies in documents\n"
                + "3. Verify the document's dates are valid\n"
                + "4. Verify the document's name is correct\n";
        rulesTextArea.setText(rules);
    }
}

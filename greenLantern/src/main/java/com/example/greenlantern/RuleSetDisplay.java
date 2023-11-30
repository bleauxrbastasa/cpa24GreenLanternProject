package com.example.greenlantern;

import javax.swing.*;

public class RuleSetDisplay extends JPanel {
    private JTextArea rulesTextArea;

    public RuleSetDisplay() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        rulesTextArea = new JTextArea(10, 30);
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(rulesTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(new JLabel("Game Rules:"));
        add(scrollPane);

        loadRules();
    }

    private void loadRules() {
        // Placeholder for game rules - these should be updated according to your game's specific rules
        String rules = "1. Verify document expiry dates are valid.\n" +
                "2. Check the issue date is not in the future.\n" +
                "3. Ensure the document type matches required criteria.\n" +
                "4. Approve valid documents and reject invalid ones.";
        rulesTextArea.setText(rules);
    }
}

package com.example.greenlantern;

public class DecisionEngine {
    private DocumentVerifier documentVerifier;
    private int score;

    public DecisionEngine() {
        this.documentVerifier = new DocumentVerifier();
        this.score = 0;
    }

    public void processDecision(Document document, boolean isApproved) {
        boolean isCorrect = documentVerifier.verifyDocument(document) == isApproved;

        if (isCorrect) {
            score++;
        } else {
            score--;
        }
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        this.score = 0;
    }
}

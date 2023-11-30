package com.example.greenlantern;

import java.time.LocalDate;

public class IntegrationTestSuite {
    private GameWindow gameWindow;
    private QueueManager queueManager;
    private DocumentPanel documentPanel;
    private DocumentVerifier documentVerifier;

    public IntegrationTestSuite() {
        gameWindow = new GameWindow();
        queueManager = new QueueManager();
        documentVerifier = new DocumentVerifier();
        documentPanel = new DocumentPanel(new DecisionEngine());
    }

    public void runTests() {
        testQueueManager();
        testDocumentPanel();
        testDocumentVerifier();
    }

    private void testQueueManager() {
        // Example test for QueueManager
        CharacterProfile character = new CharacterProfile("Test Character", new Document[]{});
        queueManager.addToQueue(character);
        assert queueManager.removeFromQueue().equals(character);
    }

    private void testDocumentPanel() {
        Document testDocument = new Document("Test Document", LocalDate.now(), LocalDate.now().plusDays(1));
        documentPanel.displayDocument(testDocument);
        String expectedLabelText = "<html>Document Type: Test Document<br>Issue Date: " +
                Utils.formatDate(testDocument.getIssueDate()) +
                "<br>Expiry Date: " + Utils.formatDate(testDocument.getExpiryDate()) + "</html>";
        assert documentPanel.getDocumentLabelText().equals(expectedLabelText);
    }


    private void testDocumentVerifier() {
        // Example test for DocumentVerifier
        Document validDocument = new Document("Valid Document", LocalDate.now(), LocalDate.now().plusDays(1));
        Document expiredDocument = new Document("Expired Document", LocalDate.now().minusDays(5), LocalDate.now().minusDays(1));
        assert documentVerifier.verifyDocument(validDocument);
        assert !documentVerifier.verifyDocument(expiredDocument);
    }
}

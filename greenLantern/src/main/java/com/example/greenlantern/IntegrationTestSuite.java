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
        DecisionEngine decisionEngine = new DecisionEngine();
        GamePanel gamePanel = new GamePanel(queueManager, decisionEngine); // Needed for DocumentPanel
        documentPanel = new DocumentPanel(decisionEngine, gamePanel);
    }

    public void runTests() {
        testQueueManager();
        testDocumentPanel();
        testDocumentVerifier();
    }

    private void testQueueManager() {
        // Updated to include all required parameters
        Document[] documents = new Document[]{new Document("Test Document", LocalDate.now(), LocalDate.now().plusDays(1))};
        String dummyDescription = "Test description";
        String dummyAsciiArt = ":-)";
        CharacterProfile character = new CharacterProfile("Test Character", documents, dummyDescription, dummyAsciiArt);
        queueManager.addToQueue(character);
        assert queueManager.removeFromQueue().equals(character);
    }

    private void testDocumentPanel() {
        Document testDocument = new Document("Test Document", LocalDate.now(), LocalDate.now().plusDays(1));
        // Create a dummy character profile
        CharacterProfile dummyCharacter = new CharacterProfile("Dummy Character", new Document[]{testDocument}, "Test description", ":-)");

        documentPanel.displayDocument(testDocument, dummyCharacter);
        String expectedLabelText = "<html>Document Type: Test Document<br>Issue Date: " +
                Utils.formatDate(testDocument.getIssueDate()) +
                "<br>Expiry Date: " + Utils.formatDate(testDocument.getExpiryDate()) +
                "<br>Discrepancy: No</html>"; // Update this based on the actual discrepancy logic
        assert documentPanel.getDocumentLabelText().equals(expectedLabelText);
    }


    private void testDocumentVerifier() {
        Document validDocument = new Document("Valid Document", LocalDate.now(), LocalDate.now().plusDays(1));
        Document expiredDocument = new Document("Expired Document", LocalDate.now().minusDays(5), LocalDate.now().minusDays(1));
        assert documentVerifier.verifyDocument(validDocument);
        assert !documentVerifier.verifyDocument(expiredDocument);
    }
}

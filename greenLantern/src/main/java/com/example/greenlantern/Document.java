package com.example.greenlantern;

import java.time.LocalDate;
import java.util.Random;

public class Document {
    private String documentType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private boolean hasDiscrepancy; // Indicates if the document has a discrepancy

    public Document(String documentType, LocalDate issueDate, LocalDate expiryDate) {
        this.documentType = documentType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.hasDiscrepancy = generateRandomDiscrepancy(); // Randomly assign a discrepancy
    }

    private boolean generateRandomDiscrepancy() {
        Random random = new Random();
        return random.nextBoolean(); // 50% chance of having a discrepancy
    }

    // Getters
    public String getDocumentType() {
        return documentType;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean hasDiscrepancy() {
        return hasDiscrepancy;
    }
}

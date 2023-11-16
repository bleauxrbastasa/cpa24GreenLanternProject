package com.example.greenlantern;

import java.time.LocalDate;

public class Document {
    private String documentType;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public Document(String documentType, LocalDate issueDate, LocalDate expiryDate) {
        this.documentType = documentType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
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
}


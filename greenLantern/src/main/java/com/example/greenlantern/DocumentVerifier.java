package com.example.greenlantern;

import java.time.LocalDate;

public class DocumentVerifier {
    public boolean verifyDocument(Document document) {
        return !document.hasDiscrepancy() && !isDocumentExpired(document) && isIssueDateValid(document);
    }

    private boolean isDocumentExpired(Document document) {
        return document.getExpiryDate().isBefore(LocalDate.now());
    }

    private boolean isIssueDateValid(Document document) {
        return !document.getIssueDate().isAfter(LocalDate.now());
    }
}

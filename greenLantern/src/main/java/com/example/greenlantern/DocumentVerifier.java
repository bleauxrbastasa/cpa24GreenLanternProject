package com.example.greenlantern;

import java.time.LocalDate;

public class DocumentVerifier {
    public boolean verifyDocument(Document document) {
        // Example verification logic
        if (document.getExpiryDate().isBefore(LocalDate.now())) {
            return false; // Document is expired
        }
        return true; // Document is valid
    }
}


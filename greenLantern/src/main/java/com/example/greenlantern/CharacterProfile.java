package com.example.greenlantern;

public class CharacterProfile {
    private String name;
    private Document[] documents;

    public CharacterProfile(String name, Document[] documents) {
        this.name = name;
        this.documents = documents;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public Document[] getDocuments() {
        return documents;
    }
}


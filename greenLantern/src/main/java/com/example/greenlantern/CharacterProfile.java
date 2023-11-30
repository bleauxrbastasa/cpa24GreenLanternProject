package com.example.greenlantern;

public class CharacterProfile {
    private String name;
    private Document[] documents;
    private String characterDescription;
    private String asciiArt; // ASCII Art representation of the character

    public CharacterProfile(String name, Document[] documents, String characterDescription, String asciiArt) {
        this.name = name;
        this.documents = documents;
        this.characterDescription = characterDescription;
        this.asciiArt = asciiArt;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public String getAsciiArt() {
        return asciiArt;
    }
}

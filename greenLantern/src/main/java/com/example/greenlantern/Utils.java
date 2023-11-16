package com.example.greenlantern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    // Additional utility methods
}


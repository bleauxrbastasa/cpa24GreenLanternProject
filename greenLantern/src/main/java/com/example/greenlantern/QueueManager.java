package com.example.greenlantern;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private Queue<CharacterProfile> queue = new LinkedList<>();

    public QueueManager() {
        populateQueue();
    }
    private void populateQueue() {
        String[] asciiArts = new String[]{
                // John Doe
                "   ____   \n" +
                        "  /    \\ \n" +
                        " |  0 0  |\n" +
                        "  \\  -- / \n" +
                        "   \\__/\n",

                // Jane Smith
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | -  - |\n" +
                        " |  __  | \n" +
                        "  \\____/\n",

                // Alex Johnson
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | >  < |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Maria Garcia
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | ~  ~ |\n" +
                        " |  __  | \n" +
                        "  \\____/\n",

                // David Brown
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | ^  ^ |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Linda Miller
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | @  @ |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Michael Wilson
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | *  * |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Sarah Moore
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | $_$ |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // James Taylor
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | +  + |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Jessica Anderson
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | O  O |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // William Jackson
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | [] [] |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Emily Harris
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | {} {} |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Daniel Martin
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | \\  / |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Emma Thompson
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | <=  => |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",

                // Christopher Garcia
                "   ____   \n" +
                        "  /    \\ \n" +
                        " | <-> |\n" +
                        " |  --  | \n" +
                        "  \\____/\n",
        };


        String[] names = {
                "John Doe", "Jane Smith", "Alex Johnson", "Maria Garcia", "David Brown",
                "Linda Miller", "Michael Wilson", "Sarah Moore", "James Taylor", "Jessica Anderson",
                "William Jackson", "Emily Harris", "Daniel Martin", "Emma Thompson", "Christopher Garcia"
        };

        String[] descriptions = {
                "A friendly face with a common name.", "Travels frequently for work.",
                "An aspiring artist with dreams of making it big.", "A seasoned taxi driver with stories to tell.",
                "A bookworm and aspiring writer.", "Loves early mornings by the lake.",
                "A tech enthusiast and avid gamer.", "A dedicated teacher and history buff.",
                "A culinary wizard and aspiring chef.", "An avid gardener with a green thumb.",
                "A young entrepreneur with innovative ideas.", "A passionate environmental activist.",
                "A skilled carpenter with a love for craftsmanship.", "A talented musician and songwriter.",
                "A fitness trainer with a focus on healthy living."
        };

        for (int i = 0; i < names.length; i++) {
            Document[] documents = {new Document("Document Type", LocalDate.now().minusYears(1), LocalDate.now().plusYears(1))};
            queue.add(new CharacterProfile(names[i], documents, descriptions[i], asciiArts[i]));
        }
    }




    public void addToQueue(CharacterProfile character) {
        queue.add(character);
    }

    public CharacterProfile removeFromQueue() {
        return queue.poll();
    }

    public int getQueueSize() {
        return queue.size();
    }
}

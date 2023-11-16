package com.example.greenlantern;

import java.util.LinkedList;
import java.util.Queue;

    public class QueueManager {
        private Queue<CharacterProfile> queue = new LinkedList<>();

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



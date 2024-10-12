package implementacao.modularizacao1;

import java.util.ArrayList;
import java.util.List;

public class CircularShifter {

    public static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Pair<Integer, String>> generateCircularShifts(String[] lines) {
        List<Pair<Integer, String>> circularShifts = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] words = line.split(" ");
            int wordCount = words.length;

            for (int j = 0; j < wordCount; j++) {
                StringBuilder shiftedLine = new StringBuilder();
                
                for (int k = 0; k < wordCount; k++) {
                    shiftedLine.append(words[(j + k) % wordCount]).append(" ");
                }

                circularShifts.add(new Pair<>(i, shiftedLine.toString().trim()));
            }
        }

        return circularShifts;
    }
}
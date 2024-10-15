package implementacao.modularizacao2;

import java.util.ArrayList;

public class CircularShifter {

    private LineStorage lineStorage;
    private ArrayList<String> circularShifts;

    public CircularShifter(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
        this.circularShifts = new ArrayList<>();
    }

    public void setup() {
        circularShifts.clear();
        int numberOfLines = lineStorage.getNumberOfLines();
        for (int i = 0; i < numberOfLines; i++) {
            generateShiftsForLine(i);
        }
    }

    private void generateShiftsForLine(int lineIndex) {
        int wordCount = lineStorage.getNumberOfWords(lineIndex);
        ArrayList<String> words = lineStorage.getAllLines().get(lineIndex);
        for (int shiftIndex = 0; shiftIndex < wordCount; shiftIndex++) {
            StringBuilder shiftedLine = new StringBuilder();
            for (int j = 0; j < wordCount; j++) {
                int wordPosition = (shiftIndex + j) % wordCount;
                shiftedLine.append(words.get(wordPosition)).append(" ");
            }
            circularShifts.add(shiftedLine.toString().trim());
        }
    }

    public char csChar(int shiftIndex, int wordIndex, int charIndex) {
        if (shiftIndex < circularShifts.size()) {
            String[] words = circularShifts.get(shiftIndex).split(" ");
            if (wordIndex < words.length && charIndex < words[wordIndex].length()) {
                return words[wordIndex].charAt(charIndex);
            }
        }
        return '\0';
    }

    public int getTotalShifts() {
        return circularShifts.size();
    }

    public int getTotalWordsInShift(int shiftIndex) {
        if (shiftIndex < circularShifts.size()) {
            return circularShifts.get(shiftIndex).split(" ").length;
        }
        return 0;
    }

    public String getWordInShift(int shiftIndex, int wordIndex) {
        if (shiftIndex < circularShifts.size()) {
            String[] words = circularShifts.get(shiftIndex).split(" ");
            if (wordIndex < words.length) {
                return words[wordIndex];
            }
        }
        return null;
    }
}
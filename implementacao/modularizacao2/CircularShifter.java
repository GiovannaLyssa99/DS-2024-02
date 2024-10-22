package implementacao.modularizacao2;

import java.util.ArrayList;
import java.util.HashSet;

public class CircularShifter {

    private LineStorage lineStorage;

    public CircularShifter(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    public void setup() {
        int numberOfLines = lineStorage.getNumberOfLines();
        for (int i = 0; i < numberOfLines; i++) {
            generateShiftsForLine(i);
        }
    }

    private void generateShiftsForLine(int lineIndex) {
        int wordCount = lineStorage.getNumberOfWords(lineIndex);
        ArrayList<String> words = lineStorage.getAllLines().get(lineIndex);
        HashSet<String> uniqueShifts = new HashSet<>();
        
        for (int shiftIndex = 0; shiftIndex < wordCount; shiftIndex++) {
            StringBuilder shiftedLine = new StringBuilder();
            for (int j = 0; j < wordCount; j++) {
                int wordPosition = (shiftIndex + j) % wordCount;
                shiftedLine.append(words.get(wordPosition)).append(" ");
            }
            String shiftedLineStr = shiftedLine.toString().trim();
            if (!shiftedLineStr.equals(String.join(" ", words))) {
                uniqueShifts.add(shiftedLineStr);
            }
        }

        for (String uniqueShift : uniqueShifts) {
            lineStorage.addShiftedLine(uniqueShift);
        }
    }

    public char csChar(int shiftIndex, int wordIndex, int charIndex) {
        return lineStorage.getChar(shiftIndex, wordIndex, charIndex);
    }

    public int getTotalShifts() {
        return lineStorage.getNumberOfLines();
    }

    public int getTotalWordsInShift(int shiftIndex) {
        return lineStorage.getNumberOfWords(shiftIndex);
    }

    public String getWordInShift(int shiftIndex, int wordIndex) {
        if (shiftIndex < lineStorage.getNumberOfLines()) {
            return lineStorage.getAllLines().get(shiftIndex).get(wordIndex);
        }
        return null;
    }
}
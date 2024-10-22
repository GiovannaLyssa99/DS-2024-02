package implementacao.modularizacao2;

import java.util.ArrayList;

public class LineStorage {

    private ArrayList<ArrayList<String>> lines;

    public LineStorage() {
        lines = new ArrayList<>();
    }

    public void setChar(int lineIndex, int wordIndex, int charIndex, char character) {
        while (lineIndex >= lines.size()) {
            lines.add(new ArrayList<>());
        }
        while (wordIndex >= lines.get(lineIndex).size()) {
            lines.get(lineIndex).add("");
        }
        StringBuilder word = new StringBuilder(lines.get(lineIndex).get(wordIndex));
        while (charIndex >= word.length()) {
            word.append(' ');
        }
        word.setCharAt(charIndex, character);
        lines.get(lineIndex).set(wordIndex, word.toString());
    }

    public char getChar(int lineIndex, int wordIndex, int charIndex) {
        if (lineIndex < lines.size() && wordIndex < lines.get(lineIndex).size()) {
            String word = lines.get(lineIndex).get(wordIndex);
            if (charIndex < word.length()) {
                return word.charAt(charIndex);
            }
        }
        return '\0';
    }

    public int getNumberOfWords(int lineIndex) {
        if (lineIndex < lines.size()) {
            return lines.get(lineIndex).size();
        }
        return 0;
    }

    public int getNumberOfLines() {
        return lines.size();
    }

    public int getNumberOfCharacters(int lineIndex, int wordIndex) {
        if (lineIndex < lines.size() && wordIndex < lines.get(lineIndex).size()) {
            return lines.get(lineIndex).get(wordIndex).length();
        }
        return 0;
    }

    public void addShiftedLine(String line) {
        ArrayList<String> words = new ArrayList<>();
        for (String word : line.split(" ")) {
            words.add(word);
        }
        lines.add(words);
    }

    public ArrayList<ArrayList<String>> getAllLines() {
        return lines;
    }
}
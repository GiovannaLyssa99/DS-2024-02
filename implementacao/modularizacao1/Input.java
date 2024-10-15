package implementacao.modularizacao1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {

    private ArrayList<char[]> packedLines;
    private ArrayList<int[]> wordStartIndices;
    private final char WORD_END_MARKER = '#';

    public Input() {
        packedLines = new ArrayList<>();
        wordStartIndices = new ArrayList<>();
    }

    public void readInput(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                char[] packedLine = packLine(line);
                packedLines.add(packedLine);
                wordStartIndices.add(indexWords(packedLine));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }
    }

    private char[] packLine(String line) {
        ArrayList<Character> packedLine = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                word.append(currentChar);
            } else {
                if (word.length() > 0) {
                    packedLine.addAll(toCharacterList(word.toString()));
                    packedLine.add(WORD_END_MARKER);
                    word.setLength(0);
                }
            }
        }

        if (word.length() > 0) {
            packedLine.addAll(toCharacterList(word.toString()));
            packedLine.add(WORD_END_MARKER);
        }

        char[] packedArray = new char[packedLine.size()];
        for (int i = 0; i < packedLine.size(); i++) {
            packedArray[i] = packedLine.get(i);
        }
        return packedArray;
    }

    private ArrayList<Character> toCharacterList(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }
        return charList;
    }

    private int[] indexWords(char[] packedLine) {
        ArrayList<Integer> indices = new ArrayList<>();
        boolean inWord = false;

        for (int i = 0; i < packedLine.length; i++) {
            if (packedLine[i] != WORD_END_MARKER) {
                if (!inWord) {
                    indices.add(i);
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        return indices.stream().mapToInt(i -> i).toArray();
    }

    public ArrayList<char[]> getPackedLines() {
        return packedLines;
    }

    public ArrayList<int[]> getWordStartIndices() {
        return wordStartIndices;
    }
}
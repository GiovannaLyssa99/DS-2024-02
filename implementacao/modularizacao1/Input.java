package implementacao.modularizacao1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {

    private ArrayList<char[]> packedLines;
    private ArrayList<Integer> lineStartIndices;

    public Input() {
        packedLines = new ArrayList<>();
        lineStartIndices = new ArrayList<>();
    }

    public void readInput(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
            String line;
            int currentIndex = 0;

            while ((line = reader.readLine()) != null) {
                char[] packedLine = packLine(line);
                packedLines.add(packedLine);
                lineStartIndices.add(currentIndex);
                currentIndex += packedLine.length;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }
    }

    private char[] packLine(String line) {
        StringBuilder packedLine = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                word.append(currentChar);
            } else {
                if (word.length() > 0) {
                    packedLine.append(word);
                    word.setLength(0);
                }
                if (currentChar == ' ') {
                    packedLine.append(' ');
                }
            }
        }

        if (word.length() > 0) {
            packedLine.append(word);
        }

        if (packedLine.length() > 0 && packedLine.charAt(packedLine.length() - 1) != ' ') {
            packedLine.append(' ');
        }

        return packedLine.toString().toCharArray();
    }

    public ArrayList<char[]> getPackedLines() {
        return packedLines;
    }

    public ArrayList<Integer> getLineStartIndices() {
        return lineStartIndices;
    }
}
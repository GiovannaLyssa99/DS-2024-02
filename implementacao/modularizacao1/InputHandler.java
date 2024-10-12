package implementacao.modularizacao1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputHandler {

    private ArrayList<String> lines;
    private ArrayList<int[]> wordIndices;

    public InputHandler() {
        lines = new ArrayList<>();
        wordIndices = new ArrayList<>();
    }

    public String[] readInput(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                wordIndices.add(indexWords(line));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }

        return lines.toArray(new String[0]);
    }

    private int[] indexWords(String line) {
        ArrayList<Integer> indices = new ArrayList<>();
        boolean inWord = false;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetterOrDigit(line.charAt(i))) {
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

    public ArrayList<String> getLines() {
        return lines;
    }

    public ArrayList<int[]> getWordIndices() {
        return wordIndices;
    }
}
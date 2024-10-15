package implementacao.modularizacao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {

    private LineStorage lineStorage;

    public Input(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    public void readLines(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
                    String word = words[wordIndex];
                    for (int charIndex = 0; charIndex < word.length(); charIndex++) {
                        lineStorage.setChar(lineIndex, wordIndex, charIndex, word.charAt(charIndex));
                    }
                    lineStorage.setChar(lineIndex, wordIndex, word.length(), ' ');
                }
                lineIndex++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
        }
    }
}
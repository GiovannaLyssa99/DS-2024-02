package implementacao.modularizacao2;

import java.util.ArrayList;
import java.util.HashSet;

public class CircularShifter {

    public void generateShiftsForLine(LineStorage lineStorage, int lineIndex) {
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

    public void setup(LineStorage lineStorage) {
        int numberOfLines = lineStorage.getNumberOfLines();
        for (int i = 0; i < numberOfLines; i++) {
            generateShiftsForLine(lineStorage, i);
        }
    }
}
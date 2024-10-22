package implementacao.modularizacao2;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabetizer {

    public String[] alphabetize(CircularShifter circularShifter, LineStorage lineStorage) {
        int numberOfShifts = lineStorage.getNumberOfLines();
        ArrayList<String> shiftsList = new ArrayList<>();

        for (int i = 0; i < numberOfShifts; i++) {
            StringBuilder shiftLine = new StringBuilder();
            int wordCount = lineStorage.getNumberOfWords(i);
            for (int j = 0; j < wordCount; j++) {
                shiftLine.append(lineStorage.getAllLines().get(i).get(j)).append(" ");
            }
            shiftsList.add(shiftLine.toString().trim());
        }

        String[] sortedShifts = shiftsList.toArray(new String[0]);
        Arrays.sort(sortedShifts);
        return sortedShifts;
    }
}
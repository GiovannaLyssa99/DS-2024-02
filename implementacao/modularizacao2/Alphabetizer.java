package implementacao.modularizacao2;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabetizer {

    public String[] alphabetize(CircularShifter circularShifter) {
        int numberOfShifts = circularShifter.getTotalShifts();
        ArrayList<String> shiftsList = new ArrayList<>();

        for (int i = 0; i < numberOfShifts; i++) {
            StringBuilder shiftLine = new StringBuilder();
            int wordCount = circularShifter.getTotalWordsInShift(i);
            for (int j = 0; j < wordCount; j++) {
                shiftLine.append(circularShifter.getWordInShift(i, j)).append(" ");
            }
            shiftsList.add(shiftLine.toString().trim());
        }

        String[] sortedShifts = shiftsList.toArray(new String[0]);
        Arrays.sort(sortedShifts);
        return sortedShifts;
    }

    public int ith(String[] sortedShifts, int index) {
        return Arrays.asList(sortedShifts).indexOf(sortedShifts[index]);
    }
}
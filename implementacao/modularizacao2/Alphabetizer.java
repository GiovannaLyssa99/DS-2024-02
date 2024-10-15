package implementacao.modularizacao2;

import java.util.Arrays;

public class Alphabetizer {

    private String[] sortedShifts;

    public void alphabetize(CircularShifter circularShifter) {
        int numberOfShifts = circularShifter.getTotalShifts();
        sortedShifts = new String[numberOfShifts];

        for (int i = 0; i < numberOfShifts; i++) {
            StringBuilder shiftLine = new StringBuilder();
            int wordCount = circularShifter.getTotalWordsInShift(i);
            for (int j = 0; j < wordCount; j++) {
                shiftLine.append(circularShifter.getWordInShift(i, j)).append(" ");
            }
            sortedShifts[i] = shiftLine.toString().trim();
        }

        Arrays.sort(sortedShifts);
    }

    public String[] getSortedShifts() {
        return sortedShifts;
    }

    public int ith(int index) {
        return Arrays.asList(sortedShifts).indexOf(sortedShifts[index]);
    }
}
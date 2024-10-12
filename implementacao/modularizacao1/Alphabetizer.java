package implementacao.modularizacao1;

import java.util.Arrays;

public class Alphabetizer {

    private String[] sortedLines;

    public void alphabetize(String[] shiftedLines) {
        sortedLines = Arrays.copyOf(shiftedLines, shiftedLines.length);
        Arrays.sort(sortedLines);
    }

    public String[] getSortedLines() {
        return sortedLines;
    }
}
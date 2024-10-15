package implementacao.modularizacao1;

import java.util.ArrayList;
import java.util.List;

public class CircularShifter {

    public static class ShiftInfo {
        public int lineIndex;
        public int startIndex;

        public ShiftInfo(int lineIndex, int startIndex) {
            this.lineIndex = lineIndex;
            this.startIndex = startIndex;
        }
    }

    private List<ShiftInfo> shifts;
    private Input input;

    public CircularShifter(Input input) {
        this.input = input;
        this.shifts = new ArrayList<>();
    }

    public void generateCircularShifts() {
        shifts.clear();
        List<char[]> packedLines = input.getPackedLines();
        List<int[]> wordStartIndices = input.getWordStartIndices();

        for (int lineIndex = 0; lineIndex < packedLines.size(); lineIndex++) {
            char[] packedLine = packedLines.get(lineIndex);
            int[] wordIndices = wordStartIndices.get(lineIndex);
            int wordCount = wordIndices.length;

            for (int shiftStartWord = 0; shiftStartWord < wordCount; shiftStartWord++) {
                int startIndex = wordIndices[shiftStartWord];
                shifts.add(new ShiftInfo(lineIndex, startIndex));
            }
        }
    }

    public List<ShiftInfo> getShifts() {
        return shifts;
    }

    public int getTotalShifts() {
        return shifts.size();
    }

    public int getShiftStartIndex(int shiftIndex) {
        if (shiftIndex >= 0 && shiftIndex < shifts.size()) {
            return shifts.get(shiftIndex).startIndex;
        }
        return -1;
    }

    public int getOriginalLineIndex(int shiftIndex) {
        if (shiftIndex >= 0 && shiftIndex < shifts.size()) {
            return shifts.get(shiftIndex).lineIndex;
        }
        return -1;
    }
}
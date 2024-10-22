package implementacao.modularizacao1;

import java.util.ArrayList;
import java.util.List;

public class CircularShifter {

    private List<ShiftInfo> shifts;
    private Input input;

    public static class ShiftInfo {
        public int lineIndex;
        public int startIndex;

        public ShiftInfo(int lineIndex, int startIndex) {
            this.lineIndex = lineIndex;
            this.startIndex = startIndex;
        }
    }

    public CircularShifter(Input input) {
        this.input = input;
        this.shifts = new ArrayList<>();
    }

    public void generateCircularShifts() {
        shifts.clear();
        List<char[]> packedLines = input.getPackedLines();

        for (int lineIndex = 0; lineIndex < packedLines.size(); lineIndex++) {
            char[] packedLine = packedLines.get(lineIndex);
            int wordStart = -1;
            for (int i = 0; i < packedLine.length; i++) {
                if (Character.isLetterOrDigit(packedLine[i])) {
                    if (wordStart == -1) {
                        wordStart = i;
                        shifts.add(new ShiftInfo(lineIndex, wordStart));
                    }
                } else {
                    wordStart = -1;
                }
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
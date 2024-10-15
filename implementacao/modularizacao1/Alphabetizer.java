package implementacao.modularizacao1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Alphabetizer {

    private List<CircularShifter.ShiftInfo> shifts;
    private List<String> sortedShifts;
    private Input input;

    public Alphabetizer(Input input, CircularShifter circularShifter) {
        this.input = input;
        this.shifts = circularShifter.getShifts();
        this.sortedShifts = new ArrayList<>();
    }

    public void alphabetize() {
        sortedShifts.clear();

        for (CircularShifter.ShiftInfo shift : shifts) {
            char[] packedLine = input.getPackedLines().get(shift.lineIndex);
            StringBuilder shiftString = new StringBuilder();

            for (int i = 0; i < packedLine.length; i++) {
                shiftString.append(packedLine[(i + shift.startIndex) % packedLine.length]);
            }

            sortedShifts.add(shiftString.toString());
        }

        sortedShifts.sort(Comparator.naturalOrder());
    }

    public List<String> getSortedShifts() {
        return sortedShifts;
    }

    public int getTotalSortedShifts() {
        return sortedShifts.size();
    }
}
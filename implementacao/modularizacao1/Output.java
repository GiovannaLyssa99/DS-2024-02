package implementacao.modularizacao1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    private List<CircularShifter.ShiftInfo> sortedShifts;
    private Input input;

    public Output(Input input, Alphabetizer alphabetizer) {
        this.input = input;
        this.sortedShifts = alphabetizer.getSortedShifts();
    }

    public void writeOutput(String outputFile) {
        for (CircularShifter.ShiftInfo shift : sortedShifts) {
            String formattedShift = generateShiftString(shift);
            System.out.println(formattedShift);
        }

        if (outputFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (CircularShifter.ShiftInfo shift : sortedShifts) {
                    String formattedShift = generateShiftString(shift);
                    writer.write(formattedShift);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao escrever o arquivo de saída: " + e.getMessage());
            }
        }
    }

    private String generateShiftString(CircularShifter.ShiftInfo shift) {
        char[] packedLine = input.getPackedLines().get(shift.lineIndex);
        StringBuilder shiftString = new StringBuilder();

        for (int i = 0; i < packedLine.length; i++) {
            shiftString.append(packedLine[(i + shift.startIndex) % packedLine.length]);
        }

        return shiftString.toString();
    }
}
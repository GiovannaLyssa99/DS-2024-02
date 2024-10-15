package implementacao.modularizacao1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    private List<String> sortedShifts;
    private Input input;

    public Output(Input input, Alphabetizer alphabetizer) {
        this.input = input;
        this.sortedShifts = alphabetizer.getSortedShifts();
    }

    public void writeOutput(String outputFile) {
        for (String shift : sortedShifts) {
            String formattedShift = shift.replace('#', ' ');
            System.out.println(formattedShift);
        }

        if (outputFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String shift : sortedShifts) {
                    String formattedShift = shift.replace('#', ' ');
                    writer.write(formattedShift);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao escrever o arquivo de saída: " + e.getMessage());
            }
        }
    }
}
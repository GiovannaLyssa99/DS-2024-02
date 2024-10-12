package implementacao.modularizacao1;

public class OutputHandler {

    public void printOutput(String[] sortedLines) {
        System.out.println("KWIC Output:");
        for (String line : sortedLines) {
            System.out.println(line);
        }
    }

    public void saveToFile(String[] sortedLines, String fileName) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.File(fileName))) {
            for (String line : sortedLines) {
                writer.println(line);
            }
            System.out.println("Output saved to file: " + fileName);
        } catch (java.io.IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
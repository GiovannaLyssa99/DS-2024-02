package implementacao.modularizacao2;

public class Output {

    public void printOutput(String[] sortedLines) {
        System.out.println("Saida KWIC:");
        for (String line : sortedLines) {
            System.out.println(line);
        }
    }

    public void saveToFile(String[] sortedLines, String fileName) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.File(fileName))) {
            for (String line : sortedLines) {
                writer.println(line);
            }
            System.out.println("Saida salva no arquivo: " + fileName);
        } catch (java.io.IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

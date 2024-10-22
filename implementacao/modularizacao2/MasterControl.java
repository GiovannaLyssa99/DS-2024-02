package implementacao.modularizacao2;

public class MasterControl {

    private LineStorage lineStorage;
    private Input input;
    private CircularShifter circularShifter;
    private Alphabetizer alphabetizer;
    private Output output;

    public MasterControl() {
        lineStorage = new LineStorage();
        input = new Input(lineStorage);
        circularShifter = new CircularShifter(lineStorage);
        alphabetizer = new Alphabetizer();
        output = new Output();
    }

    public void run(String inputFile, String outputFile) {
        input.readLines(inputFile);
        circularShifter.setup();
        String[] sortedShifts = alphabetizer.alphabetize(circularShifter);

        output.printOutput(sortedShifts);

        if (outputFile != null && !outputFile.isEmpty()) {
            output.saveToFile(sortedShifts, outputFile);
        }
    }

    public static void main(String[] args) {
        MasterControl controller = new MasterControl();

        if (args.length > 0) {
            String inputFile = args[0];
            String outputFile = args.length > 1 ? args[1] : null;

            controller.run(inputFile, outputFile);
        } else {
            System.out.println("Uso: java MasterControl <arquivoEntrada> [arquivoSaida]");
        }
    }
}
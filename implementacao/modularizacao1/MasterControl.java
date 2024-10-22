package implementacao.modularizacao1;

public class MasterControl {

    private Input input;
    private CircularShifter circularShifter;
    private Alphabetizer alphabetizer;
    private Output output;
    private String outputFile;

    public MasterControl(String inputFile, String outputFile) {
        this.input = new Input();
        this.input.readInput(inputFile);
        this.circularShifter = new CircularShifter(input);
        this.circularShifter.generateCircularShifts();
        this.alphabetizer = new Alphabetizer(input, circularShifter);
        this.output = new Output(input, alphabetizer);
        this.outputFile = outputFile;
    }

    public void process() {
        try {
            alphabetizer.alphabetize();
            output.writeOutput(outputFile);
        } catch (Exception e) {
            System.out.println("Erro durante o processamento: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java implementacao.modularizacao1.MasterControl <inputFile> [outputFile]");
            return;
        }
        String inputFile = args[0];
        String outputFile = args.length >= 2 ? args[1] : null;
        MasterControl masterControl = new MasterControl(inputFile, outputFile);
        masterControl.process();
    }
}
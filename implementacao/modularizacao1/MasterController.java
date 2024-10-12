package implementacao.modularizacao1;

import java.util.List;

public class MasterController {

    private InputHandler inputHandler;
    private CircularShifter circularShifter;
    private Alphabetizer alphabetizer;
    private OutputHandler outputHandler;

    public MasterController() {
        inputHandler = new InputHandler();
        circularShifter = new CircularShifter();
        alphabetizer = new Alphabetizer();
        outputHandler = new OutputHandler();
    }

    public void run(String inputFile, String outputFile) {
        String[] lines = inputHandler.readInput(inputFile);

        List<CircularShifter.Pair<Integer, String>> shiftedLines = circularShifter.generateCircularShifts(lines);

        String[] shiftedLinesOnly = new String[shiftedLines.size()];
        for (int i = 0; i < shiftedLines.size(); i++) {
            shiftedLinesOnly[i] = shiftedLines.get(i).second;
        }

        alphabetizer.alphabetize(shiftedLinesOnly);

        outputHandler.printOutput(alphabetizer.getSortedLines());

        if (outputFile != null && !outputFile.isEmpty()) {
            outputHandler.saveToFile(alphabetizer.getSortedLines(), outputFile);
        }
    }

    public static void main(String[] args) {
        MasterController controller = new MasterController();

        if (args.length > 0) {
            String inputFile = args[0];
            String outputFile = args.length > 1 ? args[1] : null;

            controller.run(inputFile, outputFile);
        } else {
            System.out.println("Usage: java MasterController <inputFile> [outputFile]");
        }
    }
}
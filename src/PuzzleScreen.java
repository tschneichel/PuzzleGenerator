import javax.swing.*;

public class PuzzleScreen {



    // GUI Variables
    private JFrame mainFrame = new JFrame("Puzzle Frame");
    private JPanel rootPanel;
    private JButton generateNewPuzzleButton;
    private JComboBox dimensionDropdown;
    private JPanel SudokuFieldPanel;
    private JLabel dimensionLabel;
    private JComboBox puzzleTypeDropdown;
    private JLabel setPuzzleTypeLabel;
    private JPanel[][] minisquarePanels;

    // SUDOKUFIELD Variables
    private int dimension;
    private Puzzle puzzle;

    public PuzzleScreen() {
        generateNewPuzzleButton.addActionListener(actionEvent -> generateGrid());
    }

    private void generateGrid() {
        dimension = ((int) dimensionDropdown.getSelectedItem());
        GUIGenerator generator = new GUIGenerator(dimension);
        JPanel[] rows = generator.generateJLabels();
        rootPanel = generator.generateRootPanel(rows);
        generator.initializeMainFrame(mainFrame);
        mainFrame.getContentPane().add(rootPanel);
        //create frame and add main panel

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleScreen");
        frame.setContentPane(new PuzzleScreen().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // create dimension dropdown list and set standard value
        dimensionDropdown = new JComboBox();
        for (int i = 2; i <= 9; i++){
            dimensionDropdown.addItem(i);
        }
        dimensionDropdown.setSelectedItem(8);

        // create puzzle type dropdown list and set standard value
        puzzleTypeDropdown = new JComboBox();
        puzzleTypeDropdown.addItem("Skyscraper");
        dimensionDropdown.setSelectedItem("Skyscraper");
    }
}

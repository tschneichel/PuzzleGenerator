import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PuzzleScreen {
    private static final Font FONT = new Font("Verdana", Font.CENTER_BASELINE, 20);
    private JPanel rootPanel;
    private JButton generateNewPuzzleButton;
    private JComboBox dimensionDropdown;
    private JTextField labelTextField1;
    private JPanel SudokuFieldPanel;
    private JLabel dimensionLabel;
    private JTextField[][] grid;
    private JPanel[][] minisquarePanels;

    public PuzzleScreen() {
        generateNewPuzzleButton.addActionListener(actionEvent -> generateGrid());
    }

    private void generateGrid() {
        int dimension = ((int) dimensionDropdown.getSelectedItem());
        this.grid = new JTextField[dimension][dimension];
        this.SudokuFieldPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Dimension fieldDimension = new Dimension(30, 30);
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                JTextField field = new JTextField();
                field.setBorder(border);
                field.setFont(new Font("i",3,4));
                field.setPreferredSize(fieldDimension);
                grid[x][y] = field;
                this.SudokuFieldPanel.add(field);
            }
        }
        this.SudokuFieldPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        SudokuFieldPanel.updateUI();
        SudokuFieldPanel.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleScreen");
        frame.setContentPane(new PuzzleScreen().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        dimensionDropdown = new JComboBox();
        for (int i = 2; i <= 9; i++){
            dimensionDropdown.addItem(i);
        }
        dimensionDropdown.setSelectedItem(8);
    }
}

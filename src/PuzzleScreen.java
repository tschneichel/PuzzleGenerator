import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleScreen {

    private JPanel rootPanel;
    private JButton generateNewPuzzleButton;
    private JTextField labelTextField;
    private JTextField labelTextField1;
    private JTextField[][] grid;

    public PuzzleScreen() {
        generateNewPuzzleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                generateGrid();
            }
        });
    }

    private void generateGrid() {
        this.grid = new JTextField[9][9];
        for (int x = 0; x < 9; x++)
            for (int y = 0; y < 9; y++){
                JTextField field = new JTextField();
                grid[x][y] = field;
            }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleScreen");
        frame.setContentPane(new PuzzleScreen().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

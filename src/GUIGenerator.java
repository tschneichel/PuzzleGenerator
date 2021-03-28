import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUIGenerator {

    // FONT Variables
    private static final Font font = new Font("Verdana", Font.CENTER_BASELINE, 16);

    // DIMENSION Variables
    private int overallFieldDimension;
    private int sudokuGridFieldDimensionXBase = 12;
    private int sudokuGridFieldDimensionYBase = 12;
    private int mainFrameDimensionXBase = 120;
    private int mainFrameDimensionYBase = 120;
    private int minimumSizeXBase = 100;
    private int minimumSizeYBase = 100;

    public GUIGenerator(int dimension) {
        this.overallFieldDimension = dimension;
    }

    public JPanel[] generateJLabels() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Dimension fieldDimension = new Dimension(sudokuGridFieldDimensionXBase * overallFieldDimension, sudokuGridFieldDimensionYBase * overallFieldDimension);
        JPanel[] rows = new JPanel[overallFieldDimension];
        for (int x = 0; x < overallFieldDimension; x++) {
            rows[x] = new JPanel();
            for (int y = 0; y < overallFieldDimension; y++) {
                JTextField field = new JTextField();
                field.setBorder(border);
                field.setFont(font);
                field.setPreferredSize(fieldDimension);
                field.setHorizontalAlignment(SwingConstants.CENTER);
                rows[x].add(field);
            }
        }
        return rows;
    }

    public JPanel generateRootPanel(JPanel[] rows) {
        JPanel rootPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < overallFieldDimension; i++){
            constraints.gridx=0;
            constraints.gridy++;
            rootPanel.add(rows[i], constraints);
        }
        return rootPanel;
    }

    public void initializeMainFrame(JFrame mainFrame) {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(mainFrameDimensionXBase * overallFieldDimension, mainFrameDimensionYBase * overallFieldDimension);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setMinimumSize(new Dimension(overallFieldDimension * minimumSizeXBase,overallFieldDimension * minimumSizeYBase));
        mainFrame.setVisible(true);
    }
}

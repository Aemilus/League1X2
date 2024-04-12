package app.league1x2.gui.panels.filters.selection;

import javax.swing.*;
import java.awt.*;

public class SelectionRangePanel extends JPanel {
    public final JTextField minSelectionTextField = new JTextField(null, 5);
    private final JLabel separator = new JLabel("-");
    public final JTextField maxSelectionTextField = new JTextField(null, 5);

    public SelectionRangePanel() {
        initComponents();

        setLayout(new BorderLayout(5, 5));
        add(minSelectionTextField, BorderLayout.WEST);
        add(separator, BorderLayout.CENTER);
        add(maxSelectionTextField, BorderLayout.EAST);
    }

    private void initComponents() {
        initMinSelectionTextField();
        initSeparator();
        initMaxSelectionTextField();
    }

    private void initMinSelectionTextField() {
        minSelectionTextField.setMargin(new Insets(2, 4, 2, 4));
        minSelectionTextField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initSeparator() {
        separator.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void initMaxSelectionTextField() {
        maxSelectionTextField.setMargin(new Insets(2, 4, 2, 4));
        maxSelectionTextField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void clear() {
        minSelectionTextField.setText(null);
        maxSelectionTextField.setText(null);
    }

}

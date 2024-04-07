package app.league1x2.gui.panels.filter.selection;

import app.league1x2.core.selection.SelectionRange;

import javax.swing.*;
import java.awt.*;

public class FilterSelectionPanel extends JPanel{
    private JTextField selectionTextField;
    private final JTextField minSelectionTextField = new JTextField(null, 5);
    private final JTextField maxSelectionTextField = new JTextField(null, 5);

    public FilterSelectionPanel(String selection) {
        initSelectionTextField(selection);
        JPanel panel = initSelectionRangePanel();
        setLayout(new BorderLayout(15, 5));
        add(selectionTextField, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);
    }

    private void initSelectionTextField(String selection) {
        selectionTextField = new JTextField(selection, 4);
        selectionTextField.setMargin(new Insets(2, 4, 2, 4));
        selectionTextField.setHorizontalAlignment(SwingConstants.CENTER);
        selectionTextField.setEditable(false);
    }

    private JPanel initSelectionRangePanel() {
        minSelectionTextField.setMargin(new Insets(2, 4, 2, 4));
        minSelectionTextField.setHorizontalAlignment(SwingConstants.CENTER);
        maxSelectionTextField.setMargin(new Insets(2, 4, 2, 4));
        maxSelectionTextField.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel separator = new JLabel("-");
        separator.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(minSelectionTextField, BorderLayout.WEST);
        panel.add(separator, BorderLayout.CENTER);
        panel.add(maxSelectionTextField, BorderLayout.EAST);

        return panel;
    }

    public SelectionRange getSelectionRange() {
        String selection = selectionTextField.getText();
        String min = minSelectionTextField.getText();
        String max = maxSelectionTextField.getText();
        return new SelectionRange(selection, min, max);
    }

}

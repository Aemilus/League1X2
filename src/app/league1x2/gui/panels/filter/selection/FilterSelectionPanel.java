package app.league1x2.gui.panels.filter.selection;

import app.league1x2.core.filter.SelectionRange;

import javax.swing.*;
import java.awt.*;

public class FilterSelectionPanel extends JPanel{
    private final JTextField selectionTextField = new JTextField(null, 4);
    private final SelectionRangePanel selectionRangePanel = new SelectionRangePanel();

    public FilterSelectionPanel(String selection) {
        initSelectionTextField(selection);

        setLayout(new BorderLayout(15, 5));
        add(selectionTextField, BorderLayout.WEST);
        add(selectionRangePanel, BorderLayout.CENTER);
    }

    private void initSelectionTextField(String selection) {
        selectionTextField.setText(selection);
        selectionTextField.setMargin(new Insets(2, 4, 2, 4));
        selectionTextField.setHorizontalAlignment(SwingConstants.CENTER);
        selectionTextField.setEditable(false);
    }

    public SelectionRange getSelectionRange() {
        String selection = selectionTextField.getText();
        String min = selectionRangePanel.minSelectionTextField.getText();
        String max = selectionRangePanel.maxSelectionTextField.getText();
        return new SelectionRange(selection, min, max);
    }

}

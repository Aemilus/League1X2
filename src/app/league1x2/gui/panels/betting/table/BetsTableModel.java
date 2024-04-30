package app.league1x2.gui.panels.betting.table;

import app.league1x2.constants.LeagueAppConstants;
import app.league1x2.core.betting.BetOdds;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BetsTableModel extends AbstractTableModel {
    private final String[] columnNames = {
            LeagueAppConstants.GAME_ID,
            LeagueAppConstants.GAME_NAME,
            LeagueAppConstants.SELECTION_1,
            LeagueAppConstants.SELECTION_X,
            LeagueAppConstants.SELECTION_2,
    };
    public ArrayList<BetOdds> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BetOdds betOdds = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return betOdds.gameId;
            case 1:
                return betOdds.name;
            default:
                return betOdds.oddsMap.get(getColumnName(columnIndex));
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BetOdds betOdds = data.get(rowIndex);

        String value = ((String) aValue).trim().replace(",", ".");
        if (columnIndex == 0) {
            try {
                if (value.endsWith(".") || value.endsWith(",")) {
                    value = value.substring(0, value.length() - 1);
                }
                betOdds.setGameId(Integer.parseInt(value));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (columnIndex == 1) {
            betOdds.name = value;
        }
        else {
            double d;
            try {
                d = Double.parseDouble(value);
            } catch (NumberFormatException e) {
                d = Double.parseDouble("0.0");
            }

            betOdds.oddsMap.put(LeagueAppConstants.SELECTIONS[columnIndex - 1], d);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addRow(BetOdds betOdds) {
        data.add(betOdds);
    }

    @SuppressWarnings("UnusedReturnValue")
    public BetOdds removeRow(int rowIndex) {
        return data.remove(rowIndex);
    }

    public void renumberGameIds() {
        for (int rowIndex = 0; rowIndex < getRowCount(); rowIndex++) {
            data.get(rowIndex).setGameId(rowIndex + 1);
        }
    }

}

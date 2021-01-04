package table;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorPredajePredmete;

public class AbstractTableModelProfesorPredajePredmete extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaProfesorPredajePredmete.getInstance().getPredmeti().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaProfesorPredajePredmete.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaProfesorPredajePredmete.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
		return BazaProfesorPredajePredmete.getInstance().getValueAt(rowIndex, columnIndex);
	}
}

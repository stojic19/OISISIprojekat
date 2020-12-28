package table;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTableModelOcene extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcene().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
		return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
}

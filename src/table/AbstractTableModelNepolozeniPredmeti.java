package table;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozenihPredmeta;

public class AbstractTableModelNepolozeniPredmeti extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaNepolozenihPredmeta.getInstance().getPredmeti().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaNepolozenihPredmeta.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaNepolozenihPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
		return BazaNepolozenihPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
}

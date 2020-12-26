package table;

import java.text.ParseException;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		try {
			return BazaStudenata.getInstance().getStudenti().size();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int getColumnCount() {
		try {
			return BazaStudenata.getInstance().getColumnCount();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getColumnName(int column) {
		try {
			return BazaStudenata.getInstance().getColumnName(column);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex,int columnIndex) {
		try {
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnIndex;
	}
	
}

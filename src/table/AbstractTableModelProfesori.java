package table;

import java.text.ParseException;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
			return BazaProfesora.getInstance().getProfesori().size();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return BazaProfesora.getInstance().getColumnCount();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public String getColumnName(int column) {
        try {
			return BazaProfesora.getInstance().getColumnName(column);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

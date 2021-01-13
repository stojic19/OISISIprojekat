package table;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getColumnCount();
	}	
	public String getColumnName(int column) {
		
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex){
		case 2 :return  Integer.class;
		case 3 :return  Integer.class;
		default :return  String.class;
		}
	}
}

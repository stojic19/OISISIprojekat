package table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import model.BazaStudenata;

public class StudentiJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentiJTable() throws ParseException {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(new Color(170, 167, 196));
		this.getTableHeader().setFont(this.getTableHeader().getFont().deriveFont(Font.BOLD));
		this.setModel(new AbstractTableModelStudenti());
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i = 0;i < BazaStudenata.getInstance().getColumnCount();i++)
		this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(214, 209, 224));
		} else {
			if(row%2==0)
			c.setBackground(Color.LIGHT_GRAY);
			else
			c.setBackground(new Color(170, 167, 196));
		}
		return c;
	}
	
}

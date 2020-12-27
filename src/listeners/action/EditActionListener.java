package listeners.action;

import izgled.Tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;

import dialog.StudentDialog;

public class EditActionListener implements ActionListener {
	
	final JFrame parent;
	public EditActionListener(final JFrame parent){
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			switch(Tab.getInstance().getSelectedIndex()){
			case 0:
				if(Tab.getInstance().getTabelaStudenata().getSelectedRow() >= 0){
				StudentDialog dialog = new StudentDialog(parent,Tab.getInstance().getTabelaStudenata().getSelectedRow());
				dialog.setVisible(true);
				}
				break;
			case 1:
				//TO DO: izmena profesora
				break;
			case 2:
				//TO DO: izmena predmeta
				break;
			default:
					break;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

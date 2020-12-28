package listeners.action;

import izgled.Tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dialog.PredmetDialog;
import dialog.ProfesoriDialog;
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
				
				StudentDialog dialog = new StudentDialog(parent,Tab.getInstance().getTabelaStudenata().getSelectedRow());
				dialog.setVisible(true);
				
			case 1:
				
				ProfesoriDialog dialog1 = new ProfesoriDialog(parent,Tab.getInstance().getTabelaProfesora().getSelectedRow());
				dialog1.setVisible(true);
				
				  
			case 2:
					PredmetDialog dialog2 = new PredmetDialog(parent,Tab.getInstance().getTabelaPredmeta().getSelectedRow());
					dialog2.setVisible(true);
			
			default:
				  
					break;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

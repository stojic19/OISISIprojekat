package listeners.action;

import izgled.Tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dialog.ProfesoriDialog;
import dialog.StudentDialog;

public class NewActionListener implements ActionListener{

	final JFrame parent;
	public NewActionListener(final JFrame parent){
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch(Tab.getInstance().getSelectedIndex()){
		case 0:
			StudentDialog dialog = new StudentDialog(parent);
			dialog.setVisible(true);
			break;
		case 1:
			ProfesoriDialog dialog1 = new ProfesoriDialog(parent);
			dialog1.setVisible(true);
			break;
		case 2://TO DO
			break;
		default:
				break;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

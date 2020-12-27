package listeners.action;

import izgled.Tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.StudentiController;

public class DeleteActionListener implements ActionListener{

	final JFrame parent;
	public DeleteActionListener(final JFrame parent){
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String[] mess = new String[2];
		mess[0] = "Da";
		mess[1] = "Ne";
		
		try {
			switch(Tab.getInstance().getSelectedIndex()){
			case 0:
				int code = JOptionPane.showOptionDialog(parent ,"Da li ste sigurni da želite da obrišete sudenta?","Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, mess, null);
				if(code == JOptionPane.YES_OPTION){
					StudentiController.getInstance().removeStudent(Tab.getInstance().getTabelaStudenata().getSelectedRow());
					parent.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}else{
					parent.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
				break;
			case 1:
				//TO DO: brisanje profesora
				break;
			case 2:
				//TO DO: brisanje predmeta
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

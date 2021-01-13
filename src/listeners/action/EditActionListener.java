package listeners.action;

import izgled.Tab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
				if(Tab.getInstance().getTabelaStudenata().getSelectedRow() >= 0){
				StudentDialog dialog = new StudentDialog(parent,Tab.getInstance().getTabelaStudenata().convertRowIndexToModel(Tab.getInstance().getTabelaStudenata().getSelectedRow()));
				dialog.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Odaberite studenta za izmenu!", "Izmena studenta", JOptionPane.WARNING_MESSAGE,null);
				}
				break;
			case 1:
				if(Tab.getInstance().getTabelaProfesora().getSelectedRow() >= 0){
				
				ProfesoriDialog dialog1 = new ProfesoriDialog(parent,Tab.getInstance().getTabelaProfesora().convertRowIndexToModel(Tab.getInstance().getTabelaProfesora().getSelectedRow()));
				dialog1.setVisible(true);
				}else {
					
				JOptionPane.showMessageDialog(null, "Odaberite profesora za izmenu!", "Izmena profesora", JOptionPane.WARNING_MESSAGE,null);
				}
				  break;
			case 2:
				if(Tab.getInstance().getTabelaPredmeta().getSelectedRow() >= 0){
					PredmetDialog dialog2 = new PredmetDialog(parent,Tab.getInstance().getTabelaPredmeta().convertRowIndexToModel(Tab.getInstance().getTabelaPredmeta().getSelectedRow()));
					dialog2.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za izmenu!", "Izmena predmeta", JOptionPane.WARNING_MESSAGE,null);
				}
			default:
				  
				 break;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import tabs.ProfesorDialogTab;
import tabs.StudentDialogTab;
import view.ProfesorView;
import view.StudentView;



public class ProfesoriDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProfesoriDialog(Frame parent) {
		super(parent, "Dodavanje profesora", false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		ProfesorView pv = new ProfesorView();

		add(pv);
		
		//setVisible(false);
	}
	public ProfesoriDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Izmena profesora", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 450);
		setLocationRelativeTo(parent);

		JTabbedPane tp = new ProfesorDialogTab(selRow);
		
		add(tp,BorderLayout.CENTER);
	}
	

}

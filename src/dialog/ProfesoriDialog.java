package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import view.ProfesorView;
import view.StudentView;



public class ProfesoriDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String APP_TITLE = "Dodavanje profesora";

	public ProfesoriDialog(Frame parent) {
		super(parent, APP_TITLE, false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		ProfesorView pv = new ProfesorView();

		add(pv);
		
		//setVisible(false);
	}
	

}

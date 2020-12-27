package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import view.PredmetView;

public class PredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String APP_TITLE = "Dodavanje predmeta";

	public PredmetDialog(Frame parent) {
		super(parent, APP_TITLE, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(parent);

		PredmetView predmetView = new PredmetView();

		add(predmetView);
		
	}
}

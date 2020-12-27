package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import view.PredmetView;

public class PredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredmetDialog(Frame parent) {
		super(parent, "Dodavanje predmeta", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(parent);

		PredmetView predmetView = new PredmetView();

		add(predmetView);
		
	}
	public PredmetDialog(Frame parent,int selRow) {
		super(parent, "Izmeni predmet", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);
		
		PredmetView predmetView = new PredmetView(selRow);

		add(predmetView);
	}
}

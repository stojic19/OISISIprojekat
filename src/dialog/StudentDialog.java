package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import view.StudentView;

public class StudentDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String APP_TITLE = "Dodavanje studenta";

	public StudentDialog(Frame parent) {
		super(parent, APP_TITLE, true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		StudentView studentView = new StudentView();

		add(studentView);
		
	}

}

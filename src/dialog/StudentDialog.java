package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import tabs.StudentDialogTab;
import view.StudentView;

public class StudentDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentDialog(Frame parent) {
		super(parent, "Dodavanje studenta", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		StudentView studentView = new StudentView();

		add(studentView);
		
	}
	public StudentDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Izmena studenta", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550, 500);
		setLocationRelativeTo(parent);

		JTabbedPane tabStud = new StudentDialogTab(selRow);
		
		add(tabStud,BorderLayout.CENTER);
	}
	/*
	
	 * 
	 */

}

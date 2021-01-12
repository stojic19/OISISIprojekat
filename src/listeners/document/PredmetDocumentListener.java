package listeners.document;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.PredmetView;

public class PredmetDocumentListener implements DocumentListener {

	private int type;
	private PredmetView predmetView;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfESPB;
	private JButton btnButton;
	private JLabel lblMessage;
	
	public PredmetDocumentListener(int fieldType,PredmetView pv)
	{
		type = fieldType;
		predmetView = pv;
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		check();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		check();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		check();
	}
	public void check(){
		tfCode = predmetView.getTfCode();
		tfName = predmetView.getTfName();
		tfESPB = predmetView.getTfESPB();
		btnButton = predmetView.getBtnOK();
		lblMessage = predmetView.getLblMessage();
		
		switch(type){
		case 1:
			if(tfCode.getText().length()==0)
			{
				lblMessage.setText("Nepravilna sifra!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilna sifra!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 2:
			if(tfName.getText().length()==0)
			{
				lblMessage.setText("Nepravilan naziv!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilan naziv!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 3:
			if(tfESPB.getText().length()==0)
			{
				lblMessage.setText("Nepravilan broj ESPB!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilan broj ESPB!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		
		}
	}
	
	public void checkEnable(){
			if(tfCode.getText().length()==0)
			{
				return;
			}
			if(tfName.getText().length()==0)
			{
				return;
			}
			if(tfESPB.getText().length()==0)
			{
				return;
			}
			btnButton.setEnabled(true);
	}
	
}

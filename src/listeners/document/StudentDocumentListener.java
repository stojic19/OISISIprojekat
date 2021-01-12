package listeners.document;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.StudentView;

public class StudentDocumentListener implements DocumentListener {

	private int type;
	private StudentView studentView;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfDate;
	private JTextField tfAdress;
	private JTextField tfTelNum;
	private JTextField tfEmailAdr;
	private JTextField tfIndNum;
	private JTextField tfYear;
	private JButton btnButton;
	private JLabel lblMessage;
	
	public StudentDocumentListener(int fieldType,StudentView sv)
	{
		type = fieldType;
		studentView = sv;
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
		tfFirstName = studentView.getTfFirstName();
		tfLastName = studentView.getTfLastName();
		tfDate = studentView.getTfDate();
		tfAdress = studentView.getTfAdress();
		tfTelNum = studentView.getTfTelNum();
		tfEmailAdr = studentView.getTfEmailAdr();
		tfIndNum = studentView.getTfIndNum();
		tfYear = studentView.getTfYear();
		btnButton = studentView.getBtnOK();
		lblMessage = studentView.getLblMessage();
		
		switch(type){
		case 1:
			if(tfFirstName.getText().length()==0)
			{
				lblMessage.setText("Nepravilno ime!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilno ime!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 2:
			if(tfLastName.getText().length()==0)
			{
				lblMessage.setText("Nepravilno prezime!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilno prezime!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 3:
			if(tfDate.getText().length()<11)
			{
				lblMessage.setText("Format datuma dd.MM.yyyy. !");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Format datuma dd.MM.yyyy. !")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 4:
			if(tfAdress.getText().length()==0)
			{
				lblMessage.setText("Nepravilna adresa!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilna adresa!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 5:
			if(tfTelNum.getText().length()==0)
			{
				lblMessage.setText("Nepravilan broj telefona!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilan broj telefona!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 6:
			if(tfEmailAdr.getText().length()==0)
			{
				lblMessage.setText("Nepravilan e-mail!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilan e-mail!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 7:
			if(tfIndNum.getText().length()==0)
			{
				lblMessage.setText("Nepravilan broj indeksa!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilan broj indeksa!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 8:
			if(tfYear.getText().length()<4)
			{
				lblMessage.setText("Format godine yyyy!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Format godine yyyy!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		}
	}
	
	public void checkEnable(){
			if(tfFirstName.getText().length()==0)
			{
				return;
			}
			if(tfLastName.getText().length()==0)
			{
				return;
			}
			if(tfDate.getText().length()<11)
			{
				return;
			}
			if(tfAdress.getText().length()==0)
			{
				return;
			}
			if(tfTelNum.getText().length()==0)
			{
				return;
			}
			if(tfEmailAdr.getText().length()==0)
			{
				return;
			}
			if(tfIndNum.getText().length()==0)
			{
				return;
			}
			if(tfYear.getText().length()<4)
			{
				return;
			}
			btnButton.setEnabled(true);
	}
}

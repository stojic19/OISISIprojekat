package listeners.document;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.ProfesorView;


public class ProfesorDocumentListener implements DocumentListener {
	private int type;
	private ProfesorView profesorView;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfDate;
	private JTextField tfAdress;
	private JTextField tfTelNum;
	private JTextField tfEmailAdr;
	private JTextField tfCAdress;
	private JTextField tfID;
	private JButton btnButton;
	private JLabel lblMessage;
	
	public ProfesorDocumentListener(int fieldType,ProfesorView pv)
	{
		type = fieldType;
		profesorView = pv;
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
		tfLastName = profesorView.getTfPrz();
		tfFirstName = profesorView.getTfIme();
		tfDate = profesorView.getTfDate();
		tfAdress = profesorView.getTfAdrs();
		tfTelNum = profesorView.getTfKtel();
		tfEmailAdr = profesorView.getTfEmail();
		tfCAdress = profesorView.getTfAdrk();
		tfID = profesorView.getTfBrlk();
		btnButton = profesorView.getBtnOK();
		lblMessage = profesorView.getLblMessage();
		
		switch(type){
		case 1:
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
		case 2:
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
			if(tfCAdress.getText().length()==0)
			{
				lblMessage.setText("Nepravilna adresa kancelarije!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Nepravilna adresa kancelarije!")==0)
					lblMessage.setText(" ");
				checkEnable();
			}
			break;
		case 8:
			if(tfID.getText().length()<8)
			{
				lblMessage.setText("Lična karta ima minimalno 8 cifara!");
				btnButton.setEnabled(false);
			}
			else
			{
				if(lblMessage.getText().compareTo("Lična karta ima minimalno 8 cifara!")==0)
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
			if(tfCAdress.getText().length()==0)
			{
				return;
			}
			if(tfID.getText().length()<8)
			{
				return;
			}
			btnButton.setEnabled(true);
	}
}

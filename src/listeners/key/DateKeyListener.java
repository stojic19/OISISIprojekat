package listeners.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DateKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) arg0.getComponent();
		char c = arg0.getKeyChar();
		if (txt.getText().length() == 2 && (c!='.')) {
			JOptionPane.showMessageDialog(null, "Nakon broja dana ide tačka!");
			txt.setText(txt.getText().substring(0, 2));
		}
		else if (txt.getText().length() == 5 && (c!='.')) {
			JOptionPane.showMessageDialog(null, "Nakon broja meseca ide tačka!");
			txt.setText(txt.getText().substring(0, 5));
		}
		else if (txt.getText().length() == 10 && (c!='.')) {
			JOptionPane.showMessageDialog(null, "Nakon broja dana ide tačka!");
			txt.setText(txt.getText().substring(0, 10));
		}
		else if (txt.getText().length() == 11) {
			JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 11 karaktera!");
			txt.setText(txt.getText().substring(0, 11));
		}
		if(txt.getText().length()!=2 && txt.getText().length()!=5 && txt.getText().length()!=10 && c=='.'){
			JOptionPane.showMessageDialog(null, "Nemoguć unos tačke na datoj poziciji!");
			int pos = txt.getText().length();
			if(pos==0){
			System.out.println(pos);
			txt.setText(txt.getText().substring(0, pos));
			}
			else{
				System.out.println(pos);
				txt.setText(txt.getText().substring(0, pos-1));
			}
		}
		if(txt.getText().length()==2 && (Integer.parseInt(txt.getText())>31 || Integer.parseInt(txt.getText())==0)){
			JOptionPane.showMessageDialog(null, "Broj dana ne može biti veći od 31 ili jednak 0!");
			txt.setText(txt.getText().substring(0, 0));
		}
		if(txt.getText().length()==5 && (Integer.parseInt(txt.getText().substring(3, 5))>12 || Integer.parseInt(txt.getText().substring(3, 5))==0)){
			JOptionPane.showMessageDialog(null, "Broj meseci ne može biti veći od 12 ili jednak 0!");
			txt.setText(txt.getText().substring(0, 3));
		}
		if(txt.getText().length()==10)
		{
			if(prestupna(Integer.parseInt(txt.getText().substring(6, 10)))){
				if(Integer.parseInt(txt.getText().substring(3, 5))==2 && Integer.parseInt(txt.getText().substring(0, 2))>29){
					JOptionPane.showMessageDialog(null, "Nevažeći broj dana za uneti mesec!");
					txt.setText(txt.getText().substring(0, 0));
				}
			}
			else
			{
				if(Integer.parseInt(txt.getText().substring(3, 5))==2 && Integer.parseInt(txt.getText().substring(0, 2))>28){
					JOptionPane.showMessageDialog(null, "Nevažeći broj dana za uneti mesec!");
					txt.setText(txt.getText().substring(0, 0));
				}
			}
			if((	Integer.parseInt(txt.getText().substring(3, 5))==4 ||
					Integer.parseInt(txt.getText().substring(3, 5))==6 ||
					Integer.parseInt(txt.getText().substring(3, 5))==9 ||
					Integer.parseInt(txt.getText().substring(3, 5))==11 )&&Integer.parseInt(txt.getText().substring(0, 2))>30){
				JOptionPane.showMessageDialog(null, "Nevažeći broj dana za uneti mesec!");
				txt.setText(txt.getText().substring(0, 0));
			}
			String datum = new SimpleDateFormat("yyyy").format(new GregorianCalendar().getTime());
			if(Integer.parseInt(datum)<Integer.parseInt(txt.getText().substring(6, 10)))
			{
				JOptionPane.showMessageDialog(null, "Nije moguće uneti datum iz budućnosti!");
				txt.setText(txt.getText().substring(0, 6));
			}
		}
		
	}
	private boolean prestupna(int godina)
	{
	  return (godina%4==0)&&(godina % 100 !=0 || (godina%400==0));
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
				&& c != '9' && c!='.') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva i tačke!\nFormat datuma je MM.dd.YYYY.");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
}

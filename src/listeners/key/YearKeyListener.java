package listeners.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class YearKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) arg0.getComponent();
		if (txt.getText().length() == 4) {
			JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 4 karaktera!");
			txt.setText(txt.getText().substring(0, 4));
		}
		char c = arg0.getKeyChar();
		if(txt.getText().length() == 0 && !(c == '1' || c=='2')){
			JOptionPane.showMessageDialog(null, "Unesite validnu godinu!");
			txt.setText(txt.getText().substring(0, 0));
		}
		if(txt.getText().length() == 1 && !((Integer.parseInt(txt.getText()) == 1 && c=='9') || (Integer.parseInt(txt.getText()) == 2 && c== '0'))){
			JOptionPane.showMessageDialog(null, "Unesite validnu godinu!");
			txt.setText(txt.getText().substring(0, 1));
		}
		String datum = new SimpleDateFormat("yyyy").format(new GregorianCalendar().getTime());
		if(txt.getText().length() == 3 && (Integer.parseInt(txt.getText()+c)>Integer.parseInt(datum))){
			JOptionPane.showMessageDialog(null, "Nije moguće uneti godinu iz budućnosti!");
			txt.setText(txt.getText().substring(0, 3));
		}
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
				&& c != '9') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
}

package listeners.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelNumKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		JTextField txt = (JTextField) arg0.getComponent();
		if (txt.getText().length() > 0 && c=='+') {
			JOptionPane.showMessageDialog(null, "Plus možete uneti samo na početku broja!");
			txt.setText(txt.getText().substring(0,txt.getText().length()-1 ));
		}
		if (txt.getText().length() == 20) {
			JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 20 karaktera!");
			txt.setText(txt.getText().substring(0, 20));
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
				&& c != '9' && c != '+') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva i znaka plus!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
}

package listeners.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IdNumberKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
	

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

}

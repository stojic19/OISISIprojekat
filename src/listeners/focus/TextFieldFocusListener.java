package listeners.focus;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {

		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(new Color(170, 167, 196));
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

}

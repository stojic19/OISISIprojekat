package listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class YesNoDialogActionListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0,String title,String message) {
		//JFrame parentFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (JButton)arg0.getSource());
		JDialog parentDialog = (JDialog) SwingUtilities.getWindowAncestor((JButton)arg0.getSource());
		String[] mess = new String[2];
		mess[0] = "Da";
		mess[1] = "Ne";
		int code = JOptionPane.showOptionDialog(parentDialog ,message,
				title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, mess, null);
		if(code != JOptionPane.YES_OPTION){
			parentDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}else{
			parentDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		if(parentDialog.getDefaultCloseOperation() == WindowConstants.DISPOSE_ON_CLOSE)
			parentDialog.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

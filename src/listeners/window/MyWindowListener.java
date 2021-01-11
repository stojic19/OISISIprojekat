package listeners.window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import izgled.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import table.AbstractTableModelOcene;
import view.PredmetView;
import view.ProfesorView;
import view.StudentView;

public class MyWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		JFrame frame = (JFrame) arg0.getComponent();
		String[] mess = new String[2];
		mess[0] = "Da";
		mess[1] = "Ne";
		int code = JOptionPane.showOptionDialog(frame ,"Da li ste sigurni da želite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, mess, null);
		
		
		if (code != JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			try {
				BazaStudenata.getInstance().saveStudentData();
				BazaProfesora.getInstance().saveProfesorData();
				BazaPredmeta.getInstance().savePredmetData();
				
			    MainFrame.getInstance().azurirajTabele("DODAT", -1);	
	
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

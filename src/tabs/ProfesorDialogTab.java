package tabs;

import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.ProfesorPredajePredmeteView;
import view.ProfesorView;



public class ProfesorDialogTab extends JTabbedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfesorDialogTab instance=null;

    public static ProfesorDialogTab getInstance() throws ParseException {
        if (instance == null) {
            instance = new ProfesorDialogTab(0);
        }
        return instance;
    }
 
    
    public ProfesorDialogTab(int selRow) throws ParseException {

    	ProfesorView profesorView = new ProfesorView(selRow);
    	ProfesorPredajePredmeteView profesorPredajePredmeteView = new ProfesorPredajePredmeteView(selRow);
    	
        add("Informacije",profesorView);
        
        add("Predmeti",profesorPredajePredmeteView);
        
   
        
    }
}

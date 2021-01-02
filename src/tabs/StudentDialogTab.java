package tabs;

import java.text.ParseException;

import javax.swing.JTabbedPane;

import view.NepolozeniPredmetiView;
import view.OceneView;
import view.StudentView;

public class StudentDialogTab extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StudentDialogTab instance=null;

    public static StudentDialogTab getInstance(int selRow) throws ParseException {
        if (instance == null) {
            instance = new StudentDialogTab(selRow);
        }
        return instance;
    }
    /*
    private Toolkit t=Toolkit.getDefaultToolkit();
    private Dimension dim=t.getScreenSize();
	private int w=dim.width*3/4;
    private int h=dim.height*3/4;
    */
    private StudentView studentView;
	
    private OceneView oceneView;
	
    private NepolozeniPredmetiView nepolozeniPredmetiView;
    
    public StudentDialogTab(int selRow) throws ParseException {

    	studentView = new StudentView(selRow);
    	
    	oceneView = new OceneView(selRow);
    	
    	nepolozeniPredmetiView = new NepolozeniPredmetiView(selRow);
    	
        add("Informacije",studentView);
        
        add("Položeni",oceneView);
        
        add("Nepoloženi",nepolozeniPredmetiView); 
    }
    
    public void azurirajTabeluOcena(String akcija, int vrednost) throws ParseException{
    	oceneView.azurirajTabelu(akcija, vrednost);
    }
    
    public void azurirajTabeluNepolozenihPredmeta(String akcija, int vrednost) throws ParseException{
    	nepolozeniPredmetiView.azurirajTabelu(akcija, vrednost);
    }
}

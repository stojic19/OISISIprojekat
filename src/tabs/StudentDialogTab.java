package tabs;

import java.text.ParseException;

import javax.swing.JPanel;
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

    public static StudentDialogTab getInstance() throws ParseException {
        if (instance == null) {
            instance = new StudentDialogTab(0);
        }
        return instance;
    }
    /*
    private Toolkit t=Toolkit.getDefaultToolkit();
    private Dimension dim=t.getScreenSize();
	private int w=dim.width*3/4;
    private int h=dim.height*3/4;
    */
    
   
    
    public StudentDialogTab(int selRow) throws ParseException {

    	StudentView studentView = new StudentView(selRow);
    	
    	OceneView oceneView = new OceneView(selRow);
    	
    	NepolozeniPredmetiView nepolozeniPredmetiView= new NepolozeniPredmetiView(selRow);
    	
        add("Informacije",studentView);
        
        add("Položeni",oceneView);
        
        add("Nepoloženi",nepolozeniPredmetiView);
        
    }
}

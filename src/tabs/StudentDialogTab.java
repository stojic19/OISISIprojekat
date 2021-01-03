package tabs;

import java.text.ParseException;

import javax.swing.JTabbedPane;
import view.OceneNepolozeniPredmetiView;
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
	
    private OceneNepolozeniPredmetiView oceneView;
	
  //  private OceneNepolozeniPredmetiView nepolozeniPredmetiView;
    
    public StudentDialogTab(int selRow) throws ParseException {

    	studentView = new StudentView(selRow);
    	
    	oceneView = new OceneNepolozeniPredmetiView(selRow);
    	
    	//nepolozeniPredmetiView = new oceneView.;
    	
        add("Informacije",studentView);
        
        add("Položeni",oceneView);
        
        add("Nepoloženi",oceneView.getNepolozeni()); 
    }
    
}

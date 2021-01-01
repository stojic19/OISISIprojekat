package izgled;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import listeners.action.DeleteActionListener;
import listeners.action.EditActionListener;
import listeners.action.NewActionListener;
import model.BazaPredmeta;
import model.BazaProfesora;
import search.PretragaPredmeta;
import search.PretragaProfesora;



public class Toolbar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Toolbar instance=null;

    public static Toolbar getInstance() throws ParseException {
        if (instance == null) {
            instance = new Toolbar(null);
        }
        return instance;
    }
    public static PretragaProfesora pp;
    
	Toolbar(final JFrame parent){
	    super(SwingConstants.HORIZONTAL);
	    
	    JButton btn1 = new JButton();
	    btn1.setToolTipText("Add");
	    btn1.setIcon(new ImageIcon("slike" + File.separator + "plus.png"));
	    add(btn1);
	    
		btn1.addActionListener(new NewActionListener(parent));
		
	    addSeparator();

	    JButton btn2 = new JButton();
	    btn2.setToolTipText("Edit");
	    btn2.setIcon(new ImageIcon("slike" + File.separator + "edit.png"));
	    add(btn2);
	    
		btn2.addActionListener(new EditActionListener(parent));
		
	    
	    addSeparator();

	    JButton btn3 = new JButton();
	    btn3.setToolTipText("Delete");
	    btn3.setIcon(new ImageIcon("slike" + File.separator + "delete.png"));
	    add(btn3);
		btn3.addActionListener(new DeleteActionListener(parent));
	   
		for(int i = 0; i < 80; i++)
		addSeparator();
		
	    JTextField tf = new JTextField(40);
	    add(tf);
		
	    addSeparator();
		
	    
		
		
		JButton btn4 = new JButton();
		btn4.setToolTipText("Search");
		btn4.setIcon(new ImageIcon("slike" + File.separator + "search.png"));
     
		add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pretraga=tf.getText();
			try {
			switch(Tab.getInstance().getSelectedIndex()){
			case 0:
				//TO DO
				break;
			case 1:
				    	
				    	if(pretraga.isEmpty()) {
				    		BazaProfesora.getInstance().OsveziPrikaz();
				    	}
					    PretragaProfesora p1=new PretragaProfesora(pretraga.trim());
				  break;
			case 2:
						
						if(pretraga.isEmpty()) {
						BazaPredmeta.getInstance().OsveziPrikaz();
		    	        }
			            PretragaPredmeta p2=new PretragaPredmeta(pretraga.trim());
				        break;
			default:
				  
				 break;
			}
			
		
		
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			}});
		
	    setFloatable(false);
	    setBackground(new Color(91, 102, 117));
	    LineBorder lb=new LineBorder(Color.LIGHT_GRAY);
	    setBorder(lb);
	    
	  
}
	
	
	   
}
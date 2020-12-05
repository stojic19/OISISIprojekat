package izgled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar(){
		JPanel statusBar = new JPanel();
		statusBar.setBackground(Color.WHITE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        statusBar.setPreferredSize(new Dimension(3*screenWidth/4,screenHeight/9));
        JLabel ime = new JLabel("Studentska sluzba");
       
        final JLabel datum = new JLabel();
    	//SimpleDateFormat dateFormat = new SimpleDateFormat( "HH:mm  dd.MM.yyyy." );
        
	    //datum.setText(dateFormat.format(new GregorianCalendar().getTime()));
	    Timer timer = new Timer(1000, this);
	    timer.start();
	    
	    Runnable runnable = new Runnable(){
	    	@Override
	    	public void run(){
	    		while(true)
	    		{
	    			datum.setText(new SimpleDateFormat( "HH:mm:ss  dd.MM.yyyy." ).format(new GregorianCalendar().getTime()));
	    			try{
	    				Thread.sleep(1000);
	    			}
	    			catch(InterruptedException e){
	    				e.printStackTrace();
	    			}
	    		}
	    	}
	    };
	    Thread t= new Thread(runnable);
	    t.start();
       
	    BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(box);
		this.add(Box.createHorizontalStrut(10));
		this.add(ime);
		this.add(Box.createGlue());
		this.add(datum);
		this.add(Box.createHorizontalStrut(10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
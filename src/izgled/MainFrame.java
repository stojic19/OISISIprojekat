package izgled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() throws ParseException{
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*screenWidth / 4, 3*screenHeight / 4);
        setTitle("Studentska služba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(155,172,194));
        this.add(panel);
        
        JLabel lbl = new JLabel("TO DO:Prikaz entiteta sistema");
        panel.add(lbl);
        
        Toolbar tb=new Toolbar(this);
        add(tb,BorderLayout.NORTH);
        
        Meni meni = new Meni(this);
		setJMenuBar(meni);
		
		StatusBar sb = new StatusBar();
		add(sb,BorderLayout.SOUTH);
		
		
		Tab tab=Tab.getInstance();
        add(tab,BorderLayout.CENTER);
	}
}

package izgled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import listeners.window.MyWindowListener;
import table.AbstractTableModelPredmeti;
import table.AbstractTableModelProfesori;
import table.AbstractTableModelStudenti;
import table.PredmetiJTable;
import table.ProfesoriJTable;
import table.StudentiJTable;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static MainFrame instance=null;

    public static MainFrame getInstance() throws ParseException {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

	public MainFrame() throws ParseException{
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*screenWidth / 4, 3*screenHeight / 4);
        setTitle("Studentska služba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        addWindowListener(new MyWindowListener());
       
        
        
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
	
	public void azurirajTabele(String akcija, int vrednost) throws ParseException {
		StudentiJTable tStudenti=new StudentiJTable();
		ProfesoriJTable tProfesori=new ProfesoriJTable();
		PredmetiJTable tPredmeti=new PredmetiJTable();
		
		AbstractTableModelStudenti studetiModel = (AbstractTableModelStudenti)  tStudenti.getModel();
		AbstractTableModelProfesori profesoriModel = (AbstractTableModelProfesori) tProfesori.getModel();
		AbstractTableModelPredmeti predmetiModel = (AbstractTableModelPredmeti) tPredmeti.getModel();
		
		studetiModel.fireTableDataChanged();
		profesoriModel.fireTableDataChanged();
		predmetiModel.fireTableDataChanged();
		
		tStudenti.validate();
		tProfesori.validate();
		tPredmeti.validate();
		
	}
}

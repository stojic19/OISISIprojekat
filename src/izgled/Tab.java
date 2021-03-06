package izgled;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import table.AbstractTableModelPredmeti;
import table.AbstractTableModelProfesori;
import table.AbstractTableModelStudenti;
import table.PredmetiJTable;
import table.ProfesoriJTable;
import table.StudentiJTable;


public class Tab extends JTabbedPane{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static int selectedIndex1=0;
	
public static int getSelectedIndex1() {
	    System.out.println(String.valueOf(selectedIndex1));
		return selectedIndex1;
	}
	
private static Tab instance=null;

    public static Tab getInstance() throws ParseException {
        if (instance == null) {
            instance = new Tab();
        }
        return instance;
    }
    
    
    private Toolkit t=Toolkit.getDefaultToolkit();
    private Dimension dim=t.getScreenSize();
	private int w=dim.width*3/4;
    private int h=dim.height*3/4;
    
    
    private JPanel stud=new JPanel();
    private JPanel prof=new JPanel();
    private JPanel pred=new JPanel();
    
    //TABELE
    private JTable tabelaProfesora;
    private JTable tabelaStudenata;
    private JTable tabelaPredmeta;
    private Tab() throws ParseException {


        add("Studenti",stud);
        prikaziTabeluStudenata();
        add("Profesori",prof);
        prikaziTabeluProfesora();
        add("Predmeti",pred);
        prikaziTabeluPredmeta();
         stud.setBackground(new Color(91, 102, 117));
         prof.setBackground(new Color(91, 102, 117));
         pred.setBackground(new Color(91, 102, 117));



    }

    
    
    public void azurirajPrikazStudenta(String akcija, int vrednost) {
        AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();

        model.fireTableDataChanged();
        validate();
    }


    public void azurirajPrikazProfesora(String akcija, int vrednost) {
         AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();

         model.fireTableDataChanged();
         validate();
     }
    public void azurirajPrikazPredmeta(String akcija, int vrednost) {
        AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();

        model.fireTableDataChanged();
        validate();
    }

   public void prikaziTabeluProfesora() throws ParseException {

   	   tabelaProfesora  = new ProfesoriJTable();

         JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         prof.add(scrollPane, BorderLayout.CENTER);


         this.azurirajPrikazProfesora(null, -1);
     }
   private void prikaziTabeluStudenata() throws ParseException {

   	   tabelaStudenata  = new StudentiJTable();

         JScrollPane scrollPane = new JScrollPane( tabelaStudenata);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         stud.add(scrollPane, BorderLayout.CENTER);


         this.azurirajPrikazStudenta(null, -1);
     }
   private void prikaziTabeluPredmeta() throws ParseException {

   	   tabelaPredmeta  = new PredmetiJTable();

         JScrollPane scrollPane = new JScrollPane( tabelaPredmeta);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         pred.add(scrollPane, BorderLayout.CENTER);


         this.azurirajPrikazPredmeta(null, -1);
     }

public JTable getTabelaStudenata() {
	return tabelaStudenata;
}
public void setTabelaStudenata(JTable tabelaStudenata) {
	this.tabelaStudenata = tabelaStudenata;
}

public JTable getTabelaPredmeta() {
	return tabelaPredmeta;
}
public void setTabelaPredmeta(JTable tabelaPredmeta) {
	this.tabelaPredmeta = tabelaPredmeta;
}

public JTable getTabelaProfesora() {
	return tabelaProfesora;
}
public void setTabelaProfesora(JTable tabelaProfesora) {
	this.tabelaProfesora = tabelaProfesora;
}
   	
}
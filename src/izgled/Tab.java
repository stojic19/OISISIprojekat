package izgled;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import table.AbstractTableModelStudenti;
import table.StudentiJTable;


public class Tab extends JTabbedPane{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static Tab instance=null;

    public static Tab getInstance() {
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

    private Tab() {


        add("Studenti",stud);
        prikaziTabeluStudenata();
        add("Profesori",prof);
        prikaziTabeluProfesora();
        add("Predmeti",pred);

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

   private void prikaziTabeluProfesora() {

   	   tabelaProfesora  = new ProfesoriJTable();

         JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         prof.add(scrollPane, BorderLayout.CENTER);


         this.azurirajPrikazProfesora(null, -1);
     }
   private void prikaziTabeluStudenata() {

   	   tabelaStudenata  = new StudentiJTable();

         JScrollPane scrollPane = new JScrollPane( tabelaStudenata);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         stud.add(scrollPane, BorderLayout.CENTER);


         this.azurirajPrikazStudenta(null, -1);
     }

}
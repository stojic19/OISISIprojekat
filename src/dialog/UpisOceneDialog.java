package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.focus.TextFieldFocusListener;
import listeners.key.DateKeyListener;
import model.BazaNepolozenihPredmeta;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Ocena.VrednostOcene;


public class UpisOceneDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	///obicni
	private JPanel pnlContent;
	private JPanel pnlButtons;
    private JPanel pnlcntr; 
	private JButton btnDodaj;
	private JButton btnOdustani;
	
	///dodatni
	 JPanel panSifra;
     JLabel lblSifra;
     JTextField txtSifra;
     JPanel panNaziv;
     JLabel lblNaziv;
     JTextField txtNaziv;
     JComboBox<String> cbOcena;
     JPanel panOcena;
     JLabel lblOcena;
     JPanel panDatum;
     JLabel lblDatum;
     JTextField txtDatum;
	 
     String Datum;
     VrednostOcene vo;
	 
	public  UpisOceneDialog(Frame parent,int selRow,int predmet) throws ParseException {
		super(parent, "Upis Ocene", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,350);
		setLocationRelativeTo(parent);
		
	
		initGUI(selRow,predmet);
		constructGUI(selRow,predmet);
	}
	
	
	private void initGUI(int selRow,int predmet) throws ParseException{
		    this.setLayout(new BorderLayout());
			pnlContent = new JPanel();
			pnlcntr =new JPanel();
			pnlButtons = new JPanel(new FlowLayout());
			btnDodaj = new JButton("Potvrdi");
			
			panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    lblSifra = new JLabel("Šifra*");
		    txtSifra = new JTextField();
		     
		    panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    lblNaziv = new JLabel("Naziv*");
		    txtNaziv = new JTextField();
		     
		    String[] ocena= {"6","7","8","9","10"};
		    cbOcena = new JComboBox<String>(ocena);
		    panOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    lblOcena=new JLabel("Ocena*");
		     
		    
		     
		        
		
		    panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    lblDatum = new JLabel("Datum*");
		    txtDatum= new JTextField();
	        
			btnDodaj.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
			
					try {
						
						   if(!txtDatum.getText().isEmpty()) {
							   
								switch(cbOcena.getSelectedIndex()) {
								case 0:
									vo= VrednostOcene.SEST;
									break;
								case 1:
									vo= VrednostOcene.SEDAM;
									break;
								case 2:
									vo= VrednostOcene.OSAM;
									break;
								case 3:
									vo=VrednostOcene.DEVET;
									break;
								case 4:
									vo= VrednostOcene.DESET;
								    break;
									
								}
								
						   Predmet o=BazaNepolozenihPredmeta.getInstance().getRow(predmet);
		  		       	   BazaNepolozenihPredmeta.getInstance().removePredmet(o.getSpr());
					 	   BazaOcena.getInstance().addOcena(BazaStudenata.getInstance().getRow(selRow),o,vo,new SimpleDateFormat("dd.MM.yyyy.").parse(txtDatum.getText()));
						   BazaStudenata.getInstance().azurirajStudenta(BazaStudenata.getInstance().getRow(selRow).getBrojIndeksa());
						   BazaPredmeta.getInstance().azurirajPredmet(o.getSpr());
						   dispose(); 
						   }else {
							  JOptionPane.showMessageDialog(null, "Unesite datum!", "Datum", JOptionPane.WARNING_MESSAGE, null);
							   
						   }
		                    
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				
					
				}
			});
		
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			
		}
	
	
	private void constructGUI(int selRow,int predmet){
		
	    Dimension dim = new Dimension(150,25);
		pnlButtons.add(btnDodaj);
		pnlButtons.add(btnOdustani);	
		
		
		lblSifra.setPreferredSize(dim);  
		txtSifra.setPreferredSize(dim);
	    txtSifra.setText(BazaNepolozenihPredmeta.getInstance().getRow(predmet).getSpr());
	    txtSifra.setBackground(Color.GRAY);
	    txtSifra.setEditable(false);
	    panSifra.add(lblSifra);
	    panSifra.add(txtSifra);
		
	    lblNaziv.setPreferredSize(dim);
	    txtNaziv.setBackground(Color.GRAY);
	    txtNaziv.setText(BazaNepolozenihPredmeta.getInstance().getRow(predmet).getNaziv());
	    txtNaziv.setEditable(false);
	    txtNaziv.setPreferredSize(dim);
	    panNaziv.add(lblNaziv);
	    panNaziv.add(txtNaziv);
	        
	        
	    cbOcena.setPreferredSize(dim);
	    lblOcena.setPreferredSize(dim);
	    panOcena.add(lblOcena);
	    panOcena.add(cbOcena);
		   
	    lblDatum.setPreferredSize(dim);
	    txtDatum= new JTextField();
	      
	    KeyListener dateKeyListener = new DateKeyListener();
	    FocusListener tfFocusListener = new TextFieldFocusListener();
	        
	    txtDatum.addFocusListener(tfFocusListener);
	    txtDatum.addKeyListener(dateKeyListener); 
	    txtDatum.setPreferredSize(dim);
	    panDatum.add(lblDatum);
	    panDatum.add(txtDatum);
	        
	        
	    Box boxCentar = Box.createVerticalBox();
	    boxCentar.add(Box.createVerticalStrut(20));
	    boxCentar.add(panSifra);
	    boxCentar.add(panNaziv);
	    boxCentar.add(panOcena);
	    boxCentar.add(panDatum);
	    boxCentar.add(Box.createGlue());
	    add(boxCentar, BorderLayout.NORTH);
	        
	    pnlcntr.add(pnlContent);
	    add(pnlcntr,BorderLayout.CENTER);
		add(pnlButtons,BorderLayout.SOUTH);
		
	}
}

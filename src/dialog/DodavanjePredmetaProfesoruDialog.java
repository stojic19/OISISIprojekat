package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaNepolozenihPredmeta;
import model.BazaPredmeta;
import model.BazaProfesorPredajePredmete;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class DodavanjePredmetaProfesoruDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlContent;
	private JPanel pnlButtons;
	private JPanel pnlPredmeti;
	private JLabel lblPredmeti;
	private DefaultListModel<String> listModel;
	
	private JList<String> list;
	
	private JScrollPane scrollPane;
	
	private JButton btnDodaj;
	private JButton btnOdustani;
	
	private List<Predmet> predmeti;
	
	public DodavanjePredmetaProfesoruDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Dodaj predmet", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(350, 280);
		setLocationRelativeTo(parent);
		
		initGUI(selRow);
		constructGUI();
	}
	
	private void initGUI(int selRow) throws ParseException{
		this.setLayout(new BorderLayout());
		pnlContent = new JPanel(new BorderLayout());
		pnlButtons = new JPanel(new FlowLayout());
		pnlPredmeti = new JPanel(new BorderLayout());
		lblPredmeti= new JLabel("Predmeti:");
		
		initList(selRow);

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		scrollPane = new JScrollPane(list);
		
		btnDodaj = new JButton("Potvrdi");
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()>=0)
				{
					Predmet p = predmeti.get(list.getSelectedIndex());
					
					predmeti.remove(list.getSelectedIndex());
					try {

						BazaProfesorPredajePredmete.getInstance().addPredmet(p.getSpr(), p.getNaziv(), p.getSemestar(), p.getGodina(), p.getEspb());
						BazaPredmeta.getInstance().dodajProfesoraPredmetu(p.getSpr(),selRow);
						BazaProfesora.getInstance().azurirajProfesora(BazaProfesora.getInstance().getRow(selRow).getBrlk());
						BazaPredmeta.getInstance().azurirajPredmet(p.getSpr());
						
						initList(selRow);
						
						list.updateUI();
						pnlContent.validate();
						pnlContent.repaint();
						dispose();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za dodavanje!", "Dodavanje predmeta", JOptionPane.WARNING_MESSAGE,null);
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
	
	private void constructGUI(){
		pnlButtons.add(btnDodaj);
		pnlButtons.add(btnOdustani);
	    pnlPredmeti.add(lblPredmeti,BorderLayout.WEST);
		pnlContent.add(scrollPane,BorderLayout.CENTER);
		pnlContent.add(pnlPredmeti,BorderLayout.NORTH);
		add(pnlContent,BorderLayout.CENTER);
		add(pnlButtons,BorderLayout.SOUTH);
	}
	
	private void initList(int selRow) throws ParseException{
		listModel = new DefaultListModel<String>();
		//boolean exists=false;
		predmeti = new ArrayList<Predmet>();
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
		{
			
	
           if(p.getProfesor()==null) {
			listModel.addElement(p.getSpr() + " - " + p.getNaziv());
			
			predmeti.add(p);
           }
		}
		list = new JList<String>(listModel);
	}

}

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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaNepolozenihPredmeta;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;

public class DodavanjePredmetaStudentuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlContent;
	private JPanel pnlButtons;
	
	private DefaultListModel<String> listModel;
	
	private JList<String> list;
	
	private JScrollPane scrollPane;
	
	private JButton btnDodaj;
	private JButton btnOdustani;
	
	private List<Predmet> predmeti;
	
	public DodavanjePredmetaStudentuDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Dodavanje predmeta", true);
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
		
		initList(selRow);

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		scrollPane = new JScrollPane(list);
		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()>=0)
				{
					Predmet p = predmeti.get(list.getSelectedIndex());
					BazaNepolozenihPredmeta.getInstance().addPredmet(p.getSpr(), p.getNaziv(), p.getSemestar(), p.getGodina(), p.getEspb());
					BazaPredmeta.getInstance().dodajStudentaUNepolozene(p.getSpr(), selRow);
					try {
						BazaStudenata.getInstance().azurirajStudenta(BazaStudenata.getInstance().getRow(selRow).getBrojIndeksa());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					BazaPredmeta.getInstance().azurirajPredmet(p.getSpr());
					
					predmeti.remove(list.getSelectedIndex());
					
					list.updateUI();
					pnlContent.validate();
					pnlContent.repaint();
					dispose();
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
		pnlContent.add(scrollPane,BorderLayout.CENTER);
		add(pnlContent,BorderLayout.CENTER);
		add(pnlButtons,BorderLayout.SOUTH);
	}
	
	private void initList(int selRow) throws ParseException{
		listModel = new DefaultListModel<String>();
		
		boolean exists = false;
		predmeti = new ArrayList<Predmet>();
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti())
		{
			exists = false;
			for(Ocena o : BazaOcena.getInstance().getOcene()){
				if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
					exists = true;
					break;
				}
			}
			for(Predmet p1 : BazaNepolozenihPredmeta.getInstance().getPredmeti()){
				if(p1.getSpr().matches(p.getSpr())){
				exists = true;
				break;
				}
			}
			if(BazaStudenata.getInstance().getRow(selRow).getTrenutnaGodinaStudija()<p.getGodina()){
				exists = true;
			}
			if(!exists){
				listModel.addElement(p.getSpr() + " - " + p.getNaziv());
				predmeti.add(p);
			}
		}
		list = new JList<String>(listModel);
	}
}

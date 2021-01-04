package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dialog.DodavanjePredmetaStudentuDialog;
import model.BazaNepolozenihPredmeta;
import model.BazaOcena;
import model.BazaStudenata;
import model.Ocena;
import table.AbstractTableModelNepolozeniPredmeti;
import table.AbstractTableModelOcene;
import table.NepolozeniPredmetiJTable;
import table.OceneJTable;

public class OceneNepolozeniPredmetiView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlButton;
	private JPanel pnlContent;
	private JPanel pnlPonisti;
	
	private JLabel lblProsek;
	private JLabel lblEspb;
	
	private JButton btnPONISTI;
	
	private JTable tabelaOcena;
	
	JScrollPane scrollPane;
	///nepolozeni predmeti
	private JPanel pnlempty;
	private JPanel pnlContent1;
	private JPanel pnlPom;
	
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	
	private JTable tabelaPredmeta;
	JScrollPane scrollPane1;
	private JPanel nepolozeni;
	
	public OceneNepolozeniPredmetiView(int selRow) throws ParseException
	{
		
		BazaOcena.getInstance().setOcene(BazaStudenata.getInstance().getRow(selRow).getPolozeniIspiti());
		
		initGUIOcene(selRow);
		constructGUIOcene();
		
		BazaNepolozenihPredmeta.getInstance().setPredmeti(BazaStudenata.getInstance().getRow(selRow).getNepolozeniIspiti());
		
		initGUINP(selRow);
		constructGUINP();
	}
	private void initGUIOcene(int selRow) {
		BoxLayout box=new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);

		pnlContent = new JPanel(new BorderLayout());
		
		pnlButton = new JPanel();
		BoxLayout boxCenter=new BoxLayout(pnlButton, BoxLayout.Y_AXIS);
		pnlButton.setLayout(boxCenter);
		
		pnlPonisti = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		lblProsek = new JLabel("Prosečna ocena:"+BazaOcena.getInstance().getProsek());
		lblEspb	= new JLabel("Ukupno ESPB:"+BazaOcena.getInstance().getESPB());

		
		btnPONISTI = new JButton("Poništi ocenu");
		btnPONISTI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] mess = new String[2];
				mess[0] = "Da";
				mess[1] = "Ne";
				if(tabelaOcena.getSelectedRow()>=0){
				int code = JOptionPane.showOptionDialog(null ,"Da li ste sigurni da zelite da poništite ocenu?",
						"Ponistavanje ocene", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, mess, null);
				if(code == JOptionPane.YES_OPTION){
					Ocena o = BazaOcena.getInstance().getOcene().get(tabelaOcena.getSelectedRow());
						
					BazaOcena.getInstance().removeOcena(o.getPredmet().getSpr());
					BazaNepolozenihPredmeta.getInstance().addPredmet(o.getPredmet().getSpr(), o.getPredmet().getNaziv(), o.getPredmet().getSemestar(), o.getPredmet().getGodina(), o.getPredmet().getEspb());
					
					azurirajTabeluOcena("UKLONJEN",tabelaOcena.getSelectedRow());
					azurirajTabeluNP("DODAT", -1);
				}
				}else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za poništavanje!", "Poništavanje predmeta", JOptionPane.WARNING_MESSAGE,null);
				}
				}
			});
		tabelaOcena = new OceneJTable();
		scrollPane = new JScrollPane(tabelaOcena);
	}

	private void constructGUIOcene() {
		this.setMaximumSize(new Dimension(500,450));
		
		pnlPonisti.add(btnPONISTI);
		pnlPonisti.setPreferredSize(new Dimension(80,80));
		
		pnlButton.add(lblProsek);
		pnlButton.add(lblEspb);
		
		pnlContent.add(pnlButton,BorderLayout.EAST);
		pnlContent.setPreferredSize(new Dimension(80,80));
		
		scrollPane.setPreferredSize(new Dimension(500,300));
		
		add(pnlPonisti);
		add(scrollPane);
		add(pnlContent);
		//add(pnlPonisti,BorderLayout.NORTH);
		//add(scrollPane, BorderLayout.CENTER);
		//add(pnlContent, BorderLayout.SOUTH);
	}
	public void azurirajTabeluOcena(String akcija, int vrednost) {
		azurirajLabele();
		AbstractTableModelOcene model = (AbstractTableModelOcene) tabelaOcena.getModel();
		model.fireTableDataChanged();
		tabelaOcena.validate();
	}
	private void azurirajLabele(){
		lblProsek.setText("Prosečna ocena:"+BazaOcena.getInstance().getProsek());
		lblEspb.setText("Ukupno ESPB:"+BazaOcena.getInstance().getESPB());
	}
	// nepolozeni predmeti:
	private void initGUINP(int selRow) {
		nepolozeni = new JPanel();
		BoxLayout box=new BoxLayout(nepolozeni, BoxLayout.Y_AXIS);
		nepolozeni.setLayout(box);

		pnlContent1 = new JPanel(new BorderLayout());
		
		pnlempty = new JPanel();
		BoxLayout boxCenter=new BoxLayout(pnlempty, BoxLayout.Y_AXIS);
		pnlempty.setLayout(boxCenter);
		
		pnlPom = new JPanel(new FlowLayout(FlowLayout.LEFT));
	

		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaStudentuDialog dialog;
				try {
					dialog = new DodavanjePredmetaStudentuDialog(null,selRow);
					dialog.setVisible(true);
					azurirajTabeluNP("DODAT",-1);
					dialog.repaint();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		btnObrisi = new JButton("Ukloni");
		btnObrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] mess = new String[2];
				mess[0] = "Da";
				mess[1] = "Ne";
				if(tabelaPredmeta.getSelectedRow()>=0){
				int code = JOptionPane.showOptionDialog(null ,"Da li ste sigurni da zelite da uklonite predmet?",
						"Uklanjanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, mess, null);
				if(code == JOptionPane.YES_OPTION){
					BazaNepolozenihPredmeta.getInstance().removePredmet(BazaNepolozenihPredmeta.getInstance().getRow(tabelaPredmeta.getSelectedRow()).getSpr());
					azurirajTabeluNP("UKLONJEN",tabelaPredmeta.getSelectedRow());
				}
				}
				else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za uklanjanje!", "Uklanjanje predmeta", JOptionPane.WARNING_MESSAGE,null);
				}
				}
			});
		btnPolaganje = new JButton("Polaganje");
		btnPolaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("polaganje");
				}
			});
		tabelaPredmeta = new NepolozeniPredmetiJTable();
		scrollPane1 = new JScrollPane(tabelaPredmeta);
	}
	
	private void constructGUINP() {
		nepolozeni.setMaximumSize(new Dimension(500,450));
		
		pnlPom.add(btnDodaj);
		pnlPom.add(btnObrisi);
		pnlPom.add(btnPolaganje);
		pnlPom.setPreferredSize(new Dimension(80,80));
		
		
		pnlContent1.add(pnlempty,BorderLayout.EAST);
		pnlContent1.setPreferredSize(new Dimension(80,80));
		
		scrollPane1.setPreferredSize(new Dimension(500,300));
		
		nepolozeni.add(pnlPom);
		nepolozeni.add(scrollPane1);
		nepolozeni.add(pnlContent1);
	}
	
	
	public JPanel getNepolozeni() {
		return nepolozeni;
	}
	public void setNepolozeni(JPanel nepolozeni) {
		
		this.nepolozeni = nepolozeni;
	}
	public void azurirajTabeluNP(String akcija, int vrednost) {
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		tabelaPredmeta.validate();
	}
	
}

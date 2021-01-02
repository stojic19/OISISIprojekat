package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BazaNepolozenihPredmeta;
import model.BazaStudenata;
import table.AbstractTableModelNepolozeniPredmeti;
import table.NepolozeniPredmetiJTable;

public class NepolozeniPredmetiView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlempty;
	private JPanel pnlContent;
	private JPanel pnlPom;
	
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	
	private JTable tabelaPredmeta;
	JScrollPane scrollPane;
	
	public NepolozeniPredmetiView(int selRow) throws ParseException
	{
		BazaNepolozenihPredmeta.getInstance().setPredmeti(BazaStudenata.getInstance().getRow(selRow).getNepolozeniIspiti());
		initGUI(selRow);
		constructGUI();
	}

	private void initGUI(int selRow) {
		BoxLayout box=new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);

		pnlContent = new JPanel(new BorderLayout());
		
		pnlempty = new JPanel();
		BoxLayout boxCenter=new BoxLayout(pnlempty, BoxLayout.Y_AXIS);
		pnlempty.setLayout(boxCenter);
		
		pnlPom = new JPanel(new FlowLayout(FlowLayout.LEFT));
	

		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("dodaj");
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
					azurirajTabelu("UKLONJEN",tabelaPredmeta.getSelectedRow());
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
		scrollPane = new JScrollPane(tabelaPredmeta);
	}

	private void constructGUI() {
		this.setMaximumSize(new Dimension(500,450));
		
		pnlPom.add(btnDodaj);
		pnlPom.add(btnObrisi);
		pnlPom.add(btnPolaganje);
		pnlPom.setPreferredSize(new Dimension(80,80));
		
		
		pnlContent.add(pnlempty,BorderLayout.EAST);
		pnlContent.setPreferredSize(new Dimension(80,80));
		
		scrollPane.setPreferredSize(new Dimension(500,300));
		
		add(pnlPom);
		add(scrollPane);
		add(pnlContent);
		
	}
	
	public void azurirajTabelu(String akcija, int vrednost) {
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		tabelaPredmeta.validate();
	}
}




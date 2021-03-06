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

import dialog.DodavanjePredmetaProfesoruDialog;
import model.BazaPredmeta;
import model.BazaProfesorPredajePredmete;
import model.BazaProfesora;
import model.Predmet;
import table.AbstractTableModelProfesorPredajePredmete;
import table.ProfesorPredajePredmeteJTable;

public class ProfesorPredajePredmeteView extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlButton;
	private JPanel pnlContent;
	private JPanel pnlP;
	
	
	private JButton btnDODAJ;
	private JButton btnUKLONI;
	private JTable tabelaPredmeta;
	
	JScrollPane scrollPane;
	
	public ProfesorPredajePredmeteView(int selRow) throws ParseException
	{
		BazaProfesorPredajePredmete.getInstance().setPredmeti(BazaProfesora.getInstance().getRow(selRow).getPredmeti());
		
		initGUIPPP(selRow);
		constructGUIPPP();
	
	}
	private void initGUIPPP(int selRow) throws ParseException {
		BoxLayout box=new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);

		pnlContent = new JPanel(new BorderLayout());
		
		pnlButton = new JPanel();
		BoxLayout boxCenter=new BoxLayout(pnlButton, BoxLayout.Y_AXIS);
		pnlButton.setLayout(boxCenter);
		
		pnlP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		btnDODAJ = new JButton("Dodaj predmet");
		btnDODAJ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaProfesoruDialog dialog1;
				try {
					dialog1 = new DodavanjePredmetaProfesoruDialog(null,selRow);
					dialog1.setVisible(true);
					azurirajTabeluPPPredmeta("DODAT",-1);
					dialog1.repaint();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			});
		
		btnUKLONI = new JButton("Ukloni predmet");
		btnUKLONI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] mess = new String[2];
				mess[0] = "Potrvdi";
				mess[1] = "Odustani";
				if(tabelaPredmeta.getSelectedRow()>=0){
				int code = JOptionPane.showOptionDialog(null ,"Da li ste sigurni?",
						"Ukloni predmet", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, mess, null);
				if(code == JOptionPane.YES_OPTION){
					Predmet p = BazaProfesorPredajePredmete.getInstance().getPredmeti().get(tabelaPredmeta.getSelectedRow());
						
					BazaProfesorPredajePredmete.getInstance().removePredmet(p.getSpr());
					BazaPredmeta.getInstance().ukloniProfesoraSaPredmeta(p.getSpr(),selRow);
					try {
						BazaProfesora.getInstance().azurirajProfesora(BazaProfesora.getInstance().getRow(selRow).getBrlk());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					BazaPredmeta.getInstance().azurirajPredmet(p.getSpr());
					
					azurirajTabeluPPPredmeta("UKLONJEN",tabelaPredmeta.getSelectedRow());
				
				}
				}else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za uklanjanje!", "Uklanjanje predmeta", JOptionPane.WARNING_MESSAGE,null);
				}
				}
			});
		tabelaPredmeta = new ProfesorPredajePredmeteJTable();
		scrollPane = new JScrollPane(tabelaPredmeta);
	}

	private void constructGUIPPP() {
		this.setMaximumSize(new Dimension(500,450));
		
		pnlP.add(btnDODAJ);
		pnlP.setPreferredSize(new Dimension(80,80));
		
		pnlP.add(btnUKLONI);
		pnlP.setPreferredSize(new Dimension(80,80));
		
		
		pnlContent.add(pnlButton,BorderLayout.EAST);
		pnlContent.setPreferredSize(new Dimension(80,80));
		///
		scrollPane.setPreferredSize(new Dimension(500,300));
		
		add(pnlP);
		add(scrollPane);
		add(pnlContent);
	}
	public void azurirajTabeluPPPredmeta(String akcija, int vrednost) {
		AbstractTableModelProfesorPredajePredmete model = (AbstractTableModelProfesorPredajePredmete) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		tabelaPredmeta.validate();
	}

}

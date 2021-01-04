package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BazaProfesorPredajePredmete;
import model.BazaProfesora;
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
				
				}
			});
		
		btnUKLONI = new JButton("Ukloni predmet");
		btnUKLONI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ukloni");
					
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

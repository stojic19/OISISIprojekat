package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import table.OceneJTable;
import model.Ocena;

public class OceneView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private OceneController oceneController;

	private JPanel pnlButton;
	private JPanel pnlContent;
	private JPanel pnlPonisti;
	
	private JLabel lblProsek;
	private JLabel lblEspb;
	
	private JButton btnPONISTI;
	
	private JTable tabelaOcena;
	
	JScrollPane scrollPane;
	
	public OceneView(int selRow) throws ParseException
	{
		List<Ocena> polozeniIspiti = new ArrayList<Ocena>();
		
		polozeniIspiti.add(new Ocena(BazaStudenata.getInstance().getRow(selRow), BazaPredmeta.getInstance().getRow(selRow), Ocena.VrednostOcene.DESET, new SimpleDateFormat("dd.MM.yyyy").parse("09.01.2021.")));
		
		BazaStudenata.getInstance().getRow(selRow).setPolozeniIspiti(polozeniIspiti);
		BazaOcena.getInstance().setOcene(BazaStudenata.getInstance().getRow(selRow).getPolozeniIspiti());
		
		initGUI();
		constructGUI();
	}

	private void initGUI() {
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
				int code = JOptionPane.showOptionDialog(null ,"Da li ste sigurni da zelite da ponistite ocenu?",
						"Ponistavanje ocene", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, mess, null);
				if(code != JOptionPane.YES_OPTION){
					//TO DO: ponistavanje ocene
				}
				}
			});
		tabelaOcena = new OceneJTable();
		scrollPane = new JScrollPane(tabelaOcena);
	}

	private void constructGUI() {
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
}

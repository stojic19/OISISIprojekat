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

import model.BazaNepolozenihPredmeta;
import model.BazaOcena;
import model.BazaStudenata;
import model.Ocena;
import table.AbstractTableModelOcene;
import table.OceneJTable;
import tabs.StudentDialogTab;

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
		BazaOcena.getInstance().setOcene(BazaStudenata.getInstance().getRow(selRow).getPolozeniIspiti());
		
		initGUI(selRow);
		constructGUI();
	}

	private void initGUI(int selRow) {
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
				int code = JOptionPane.showOptionDialog(null ,"Da li ste sigurni da zelite da ponistite ocenu?",
						"Ponistavanje ocene", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, mess, null);
				if(code == JOptionPane.YES_OPTION){
					Ocena o = BazaOcena.getInstance().getOcene().get(tabelaOcena.getSelectedRow());
						
					try {
						BazaStudenata.getInstance().getStudenti().get(selRow).getPolozeniIspiti().remove(tabelaOcena.getSelectedRow());
						BazaStudenata.getInstance().getStudenti().get(selRow).getNepolozeniIspiti().add(o.getPredmet());
						BazaOcena.getInstance().setOcene(BazaStudenata.getInstance().getStudenti().get(selRow).getPolozeniIspiti());
						BazaNepolozenihPredmeta.getInstance().setPredmeti(BazaStudenata.getInstance().getStudenti().get(selRow).getNepolozeniIspiti());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						azurirajTabelu("UKLONJEN",tabelaOcena.getSelectedRow());
						StudentDialogTab.getInstance(selRow).azurirajTabeluNepolozenihPredmeta("DODAT", -1);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}
				}else{
					JOptionPane.showMessageDialog(null, "Odaberite predmet za poništavanje!", "Poništavanje predmeta", JOptionPane.WARNING_MESSAGE,null);
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
	public void azurirajTabelu(String akcija, int vrednost) {
		azurirajLabele();
		AbstractTableModelOcene model = (AbstractTableModelOcene) tabelaOcena.getModel();
		model.fireTableDataChanged();
		tabelaOcena.validate();
	}
	private void azurirajLabele(){
		lblProsek.setText("Prosečna ocena:"+BazaOcena.getInstance().getProsek());
		lblEspb.setText("Ukupno ESPB:"+BazaOcena.getInstance().getESPB());
	}
}

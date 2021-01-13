package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Profesor;

public class DodavanjeProfNaPredmetDialog extends JDialog {
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
	
	public  DodavanjeProfNaPredmetDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Odaberi profesora", true);
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
					Profesor p;
					try {
						p = BazaProfesora.getInstance().getRow(list.getSelectedIndex());
						BazaPredmeta.getInstance().getPredmeti().get(selRow).setProfesor(p);
						BazaProfesora.getInstance().getRow(list.getSelectedIndex()).getPredmeti().add(BazaPredmeta.getInstance().getRow(selRow));
						BazaPredmeta.getInstance().azurirajPredmet(BazaPredmeta.getInstance().getRow(selRow).getSpr());
						BazaProfesora.getInstance().azurirajProfesora(p.getBrlk());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Odaberite profesora za dodavanje!", "Dodavanje profesora", JOptionPane.WARNING_MESSAGE,null);
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
		
		for(Profesor p : BazaProfesora.getInstance().getProfesori())
		{
				listModel.addElement(p.getIme() + " " + p.getPrz());
			
		}
		list = new JList<String>(listModel);
	}
}

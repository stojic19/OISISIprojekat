package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import listeners.action.YesNoDialogActionListener;
import listeners.focus.TextFieldFocusListener;
import listeners.key.EspbKeyListener;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import controller.PredmetiController;
import dialog.DodavanjeProfNaPredmetDialog;

public class PredmetView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Predmet predmet;
	private PredmetiController predmetController;

	private JPanel pnlContent;
	private JPanel pnlButton;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblYear;
	private JComboBox<String> cbYear;
	private JLabel lblSemester;
	private JComboBox<String> cbSemester;
	private JLabel lblESPB;
	private JTextField tfESPB;
	private JLabel lblProfessor;
	private JTextField tfProfessor;
	
	private JButton btnPLUS;
	private JButton btnMINUS;

	private JButton btnOK;
	private JButton btnCANCEL;
	
	public PredmetView(int selRow) {
		initGUI(true,selRow);
		constructGUI(true);

		setPredmet(BazaPredmeta.getInstance().getRow(selRow));
	}
	public PredmetView()
	{
		initGUI(false,-1);
		constructGUI(false);
	}

	private void initGUI(boolean update,int selRow) {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		pnlButton = new JPanel(new GridBagLayout());
		
		FocusListener tfFocusListener = new TextFieldFocusListener();
		lblCode = new JLabel("Šifra*");
		tfCode = new JTextField(20);
		tfCode.addFocusListener(tfFocusListener);
		
		lblName = new JLabel("Naziv*");
		tfName = new JTextField(20);
		tfName.addFocusListener(tfFocusListener);
		
		lblYear = new JLabel("Godina*");
		String[] yearStrings = {"1","2","3","4","5","6"};
		cbYear = new JComboBox<String>(yearStrings);
		
		lblSemester = new JLabel("Semestar*");
		String[] semesterStrings = {"zimski","letnji"};
		cbSemester = new JComboBox<String>(semesterStrings);
		
		KeyListener espbKeyListener = new EspbKeyListener();
		lblESPB = new JLabel("ESPB*");
		tfESPB = new JTextField(20);
		tfESPB.addFocusListener(tfFocusListener);
		tfESPB.addKeyListener(espbKeyListener);
		
		lblProfessor = new JLabel("Profesor*");
		tfProfessor = new JTextField(20);
		tfProfessor.addFocusListener(tfFocusListener);
		tfProfessor.setMinimumSize(new Dimension(150,20));
		
		btnCANCEL = new JButton("Odustani");
		btnCANCEL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				YesNoDialogActionListener dialog = new YesNoDialogActionListener();
				if(!update)
				dialog.actionPerformed(e,"Prekid unosa?","Da li ste sigurni da želite da prekinete dodavanje predmeta?");
				else
				dialog.actionPerformed(e,"Prekid izmene?","Da li ste sigurni da želite da prekinete izmenu podataka o predmetu?");
			}
		});

		btnOK = new JButton("Potvrdi");
		btnOK.setBackground(new Color(170, 167, 196));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ok(update);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnPLUS = new JButton("+");
		btnPLUS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DodavanjeProfNaPredmetDialog dialog = new DodavanjeProfNaPredmetDialog(null,selRow);
					dialog.setVisible(true);
					Predmet p = BazaPredmeta.getInstance().getRow(selRow);
					if(p.getProfesor()!=null){
					tfProfessor.setText(p.getProfesor().getIme()+" "+p.getProfesor().getPrz());
					setPredmet(p);
					refreshView();
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnMINUS = new JButton("-");
		btnMINUS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TO DO:uklanjaje prof sa predmeta
				}
		});
		btnPLUS.setMaximumSize(new Dimension(18,18));
		btnMINUS.setMaximumSize(new Dimension(18,18));
	}

	private void constructGUI(boolean update) {
		pnlContent.add(lblCode, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfCode, new GridBagConstraints(1, 0, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfName, new GridBagConstraints(1, 1, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblYear, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbYear, new GridBagConstraints(1, 2, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblSemester, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbSemester, new GridBagConstraints(1, 3, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblESPB, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfESPB, new GridBagConstraints(1, 4, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		if(!update){
		pnlContent.add(btnOK, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnCANCEL, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		}
		else
		{
			pnlButton.add(tfProfessor, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
					
			pnlButton.add(btnPLUS, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
					
			pnlButton.add(btnMINUS, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
					
			pnlContent.add(lblProfessor, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(pnlButton, new GridBagConstraints(1, 5, 1, 120, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			
			JPanel pnlSouth = new JPanel(new FlowLayout());
			pnlSouth.add(btnOK);
			pnlSouth.add(btnCANCEL);
			add(pnlSouth, BorderLayout.SOUTH);
		}
		add(pnlContent, BorderLayout.CENTER);
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
		predmetController = null;
		refreshView();
	}

	public void refreshView() {
		tfCode.setText(predmet.getSpr());
		tfName.setText(predmet.getNaziv());
		switch(predmet.getGodina()){
		case 1:
			cbYear.setSelectedIndex(0);
			break;
		case 2:
			cbYear.setSelectedIndex(1);
			break;
		case 3:
			cbYear.setSelectedIndex(2);
			break;
		case 4:
			cbYear.setSelectedIndex(3);
			break;
		case 5:
			cbYear.setSelectedIndex(4);
			break;
		default:
			cbYear.setSelectedIndex(5);
		}
		if(predmet.getSemestar() == Predmet.Semestar.ZIMSKI)
			cbSemester.setSelectedIndex(0);
		else
			cbSemester.setSelectedIndex(1);
		tfESPB.setText(Integer.toString(predmet.getEspb()));
		
		if(predmet.getProfesor()==null){
			btnMINUS.setEnabled(false);
			btnPLUS.setEnabled(true);
		}else{
			Profesor p = predmet.getProfesor();
			tfProfessor.setText(p.getIme()+" "+p.getPrz());
			btnMINUS.setEnabled(true);
			btnPLUS.setEnabled(false);
		}
	}

	private void ok(boolean update) throws ParseException {
		
		String spr = tfCode.getText();
		String naziv = tfName.getText();
		String semestar = Integer.toString(cbSemester.getSelectedIndex());
		String godina = Integer.toString(cbYear.getSelectedIndex());
		String espb = tfESPB.getText();
		
		if (predmetController == null) {
			predmetController = new PredmetiController(this);
		}
		
		String message;
		if(!update)
		message = predmetController.addPredmet(spr, naziv, semestar, godina, espb);
		else
		message = predmetController.updatePredmet(spr, naziv, semestar, godina, espb,predmet.getSpr());
			
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		JOptionPane.showMessageDialog(parent, message);
		
		if(message=="Predmet uspešno dodat"||message=="Predmet uspešno izmenjen")
			parent.setVisible(false);
	}

}

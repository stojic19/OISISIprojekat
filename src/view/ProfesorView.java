package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.ProfesoriController;
import listeners.action.YesNoDialogActionListener;
import listeners.focus.TextFieldFocusListener;
import listeners.key.DateKeyListener;
import listeners.key.IdNumberKeyListener;
import listeners.key.TelNumKeyListener;
import model.BazaProfesora;
import model.Profesor;



public class ProfesorView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profesor profesor;
	private ProfesoriController profesoriController;


	private JPanel pnlContent;
	private JLabel lblPrz;
	private JTextField tfPrz;
	private JLabel lblIme;
	private JTextField tfIme;
	private JLabel lblDate;
	private JTextField tfDate;
	private JLabel lblAdrs;
	private JTextField tfAdrs;
	private JLabel lblKtel;
	private JTextField tfKtel;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblAdrk;
	private JTextField tfAdrk;
	private JLabel lblBrlk;
	private JTextField tfBrlk;
	private JLabel lblTitula;
	private JComboBox<String> cbTitula;
	private JLabel lblZvanje;
	private JComboBox<String> cbZvanje;
	

	private JButton btnOK;
	private JButton btnCANCEL;
	
	
	public ProfesorView(int selRow) throws ParseException {
		initGUI(true);
		constructGUI();

		setProfesor(BazaProfesora.getInstance().getRow(selRow));
	}
	public ProfesorView()
	{
		initGUI(false);
		constructGUI();
	}

	private void initGUI(boolean update) {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		FocusListener tfFocusListener = new TextFieldFocusListener();
		
		
		lblIme = new JLabel("Ime*");
		tfIme = new JTextField(20);
		tfIme.addFocusListener(tfFocusListener);
		
		lblPrz = new JLabel("Prezime*");
		tfPrz = new JTextField(20);
		tfPrz.addFocusListener(tfFocusListener);
		
		//KeyListener yearKeyListener = new YearKeyListener();
		KeyListener dateKeyListener = new DateKeyListener();
		lblDate = new JLabel("Datum rođenja*");
		tfDate = new JTextField(20);
		tfDate.addKeyListener(dateKeyListener);
		tfDate.addFocusListener(tfFocusListener);
	   
		
		lblAdrs = new JLabel("Adresa stanovanja*");
		tfAdrs = new JTextField(20);
		tfAdrs.addFocusListener(tfFocusListener);
		
		KeyListener telNumKeyListener = new TelNumKeyListener();
		lblKtel = new JLabel("Broj telefona*");
		tfKtel = new JTextField(20);
		tfKtel.addKeyListener(telNumKeyListener);
		tfKtel.addFocusListener(tfFocusListener);
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		tfEmail.addFocusListener(tfFocusListener);
		
		lblAdrk = new JLabel("Adresa kancelarije*");
		tfAdrk = new JTextField(20);
		tfAdrk.addFocusListener(tfFocusListener);
		

		KeyListener idNumberKeyListener=new  IdNumberKeyListener();
		lblBrlk = new JLabel("Broj lične karte*");
		tfBrlk = new JTextField(20);
		tfBrlk.addKeyListener(idNumberKeyListener);
		tfBrlk.addFocusListener(tfFocusListener);
		
		lblTitula = new JLabel("Titula*");
		String[] titulaStrings = {"BSc","MSc","Mr","Dr","Prof. dr"};
		cbTitula = new JComboBox<String>(titulaStrings);
		
		
		lblZvanje = new JLabel("Zvanje*");
		String[] zvanjeStrings = {"Saradnik u nastavi","Asistent","Asistent sa doktoratom","Docent","Vanredni profesor","Redovni profesor","Profesor emeritus","Dekan"};
		cbZvanje = new JComboBox<String>(zvanjeStrings);
		

		
		btnCANCEL = new JButton("Odustani");
		btnCANCEL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				YesNoDialogActionListener dialog = new YesNoDialogActionListener();
				if(!update)
					dialog.actionPerformed(e,"Prekid unosa?","Da li ste sigurni da želite da prekinete dodavanje profesora?");
					else
					dialog.actionPerformed(e,"Prekid izmene?","Da li ste sigurni da želite da prekinete izmenu podataka o profesoru?");
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
	}

	private void constructGUI() {
		pnlContent.add(lblIme, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfIme, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblPrz, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfPrz, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfDate, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblAdrs, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfAdrs, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblKtel, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfKtel, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblEmail, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfEmail, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblAdrk, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfAdrk, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblBrlk, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBrlk, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblTitula, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbTitula, new GridBagConstraints(1, 8, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblZvanje, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbZvanje, new GridBagConstraints(1, 9, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(btnOK, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnCANCEL, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		add(pnlContent, BorderLayout.CENTER);
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
		profesoriController = null;
		refreshView();
	}

	public void refreshView() {
		tfIme.setText(profesor.getIme());
		tfPrz.setText(profesor.getPrz());
		String timePattern = "dd.MM.yyyy";
		DateFormat df = new SimpleDateFormat(timePattern);
		tfDate.setText(df.format(profesor.getDatrodj()));
		tfAdrs.setText(profesor.getAdrs());
		tfKtel.setText(profesor.getKtel());
		tfEmail.setText(profesor.getEmail());
		tfAdrk.setText(profesor.getAdrk());
		tfBrlk.setText(profesor.getBrlk());

		switch(String.valueOf(profesor.getTitula())){
		case "BSC":
			cbTitula.setSelectedIndex(0);
			break;
		case  "MSC":
			cbTitula.setSelectedIndex(1);
			break;
		case "MR":
			cbTitula.setSelectedIndex(2);
			break;
		case  "DR":
			cbTitula.setSelectedIndex(3);
			break;
		case "PROFDR":
			cbTitula.setSelectedIndex(4);
			break;
		}
		
		switch(String.valueOf(profesor.getZvanje())){
		case "SARADNIKUNASTAVI":
			cbTitula.setSelectedIndex(0);
			break;
		case  "ASISTENT":
			cbTitula.setSelectedIndex(1);
			break;
		case "ASISTENTSADOKTORATOM":
			cbTitula.setSelectedIndex(2);
			break;
		case  "DOCENT":
			cbTitula.setSelectedIndex(3);
			break;
		case "VANREDNIPROFESOR":
			cbTitula.setSelectedIndex(4);
			break;
		case "REDOVNIPROFESOR":
			cbTitula.setSelectedIndex(5);
			break;
		case "PROFESOREMERITUS":
			cbTitula.setSelectedIndex(6);
			break;
		case "DEKAN":
			cbTitula.setSelectedIndex(7);
			break;
		}
		
	}

	private void ok(boolean update) throws ParseException {
		
		String ime = tfIme.getText();
		String prz = tfPrz.getText();
		String datrodj = tfDate.getText();
		String adrs = tfAdrs.getText();
		String ktel = tfKtel.getText();
		String email = tfEmail.getText();
		String adrk =tfAdrk.getText();
		String brlk= tfBrlk.getText();
		String titula= Integer.toString(cbTitula.getSelectedIndex());
		String zvanje= Integer.toString(cbZvanje.getSelectedIndex());
	
		
		if (profesoriController == null) {
			profesoriController = new ProfesoriController(this);
		}
	
        String message;
		if(!update) {
		 message = profesoriController.addProfesor(prz,ime,datrodj,adrs,ktel,email,adrk,brlk,titula,zvanje); 
		}else {	
		message = profesoriController.editProfesor(prz,ime,datrodj,adrs,ktel,email,adrk,brlk,titula,zvanje,profesor.getBrlk());
		}

		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		JOptionPane.showMessageDialog(parent, message);
		
		if(message=="Profesor uspešno dodat" || message=="Profesor uspešno izmenjen" )
			parent.setVisible(false);
	}
}

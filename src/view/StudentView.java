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

import listeners.action.YesNoDialogActionListener;
import listeners.focus.TextFieldFocusListener;
import listeners.key.DateKeyListener;
import listeners.key.TelNumKeyListener;
import listeners.key.YearKeyListener;
import model.Student;
import controller.StudentiController;

public class StudentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student student;
	private StudentiController studentController;

	private JPanel pnlContent;
	private JLabel lblFirstName;
	private JTextField tfFirstName;
	private JLabel lblLastName;
	private JTextField tfLastName;
	private JLabel lblDate;
	private JTextField tfDate;
	private JLabel lblAdress;
	private JTextField tfAdress;
	private JLabel lblTelNum;
	private JTextField tfTelNum;
	private JLabel lblEmailAdr;
	private JTextField tfEmailAdr;
	private JLabel lblIndNum;
	private JTextField tfIndNum;
	private JLabel lblYear;
	private JTextField tfYear;
	private JLabel lblPresYear;
	private JComboBox<String> cbPresYear;
	private JLabel lblFinan;
	private JComboBox<String> cbFinan;

	private JButton btnOK;
	private JButton btnCANCEL;
	
	public StudentView(Student student) {
		initGUI();
		constructGUI();

		setStudent(student);
	}
	public StudentView()
	{
		initGUI();
		constructGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		FocusListener tfFocusListener = new TextFieldFocusListener();
		lblFirstName = new JLabel("Ime*");
		tfFirstName = new JTextField(20);
		tfFirstName.addFocusListener(tfFocusListener);
		
		lblLastName = new JLabel("Prezime*");
		tfLastName = new JTextField(20);
		tfLastName.addFocusListener(tfFocusListener);
		
		KeyListener dateKeyListener = new DateKeyListener();
		lblDate = new JLabel("Datum rodjenja*");
		tfDate = new JTextField(20);
		tfDate.addKeyListener(dateKeyListener);
		tfDate.addFocusListener(tfFocusListener);
		
		lblAdress = new JLabel("Adresa stanovanja*");
		tfAdress = new JTextField(20);
		tfAdress.addFocusListener(tfFocusListener);
		
		KeyListener telNumKeyListener = new TelNumKeyListener();
		lblTelNum = new JLabel("Broj telefona*");
		tfTelNum = new JTextField(20);
		tfTelNum.addKeyListener(telNumKeyListener);
		tfTelNum.addFocusListener(tfFocusListener);
		
		lblEmailAdr = new JLabel("E-mail adresa*");
		tfEmailAdr = new JTextField(20);
		tfEmailAdr.addFocusListener(tfFocusListener);
		
		lblIndNum = new JLabel("Broj indeksa*");
		tfIndNum = new JTextField(20);
		tfIndNum.addFocusListener(tfFocusListener);
		
		KeyListener yearKeyListener = new YearKeyListener();
		lblYear = new JLabel("Godina upisa*");
		tfYear = new JTextField(20);
		tfYear.addKeyListener(yearKeyListener);
		tfYear.addFocusListener(tfFocusListener);
		
		lblPresYear = new JLabel("Trenutna godina studija*");
		String[] presYearStrings = {"I(prva)","II(druga)","III(treća)","IV(četvtra)","V(peta)","VI(šesta)"};
		cbPresYear = new JComboBox<String>(presYearStrings);
		
		lblFinan = new JLabel("Način finansiranja*");
		String[] finanStrings = {"Budžet","Samofinansiranje"};
		cbFinan = new JComboBox<String>(finanStrings);
		
		btnCANCEL = new JButton("Odustani");
		btnCANCEL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				YesNoDialogActionListener dialog = new YesNoDialogActionListener();
				dialog.actionPerformed(e,"Prekid unosa?","Da li ste sigurni da želite da prekinete dodavanje studenta?");
			}
		});

		// pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton("Potvrdi");
		btnOK.setBackground(Color.CYAN);
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ok();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void constructGUI() {
		pnlContent.add(lblFirstName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfFirstName, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblLastName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfLastName, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfDate, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblAdress, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfAdress, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblTelNum, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfTelNum, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblEmailAdr, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfEmailAdr, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblIndNum, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfIndNum, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblYear, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfYear, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblPresYear, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbPresYear, new GridBagConstraints(1, 8, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblFinan, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbFinan, new GridBagConstraints(1, 9, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(btnOK, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnCANCEL, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		add(pnlContent, BorderLayout.CENTER);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
		studentController = null;
		refreshView();
	}

	public void refreshView() {
		tfFirstName.setText(student.getIme());
		tfLastName.setText(student.getPrezime());
		String timePattern = "dd.MM.yyyy";
		DateFormat df = new SimpleDateFormat(timePattern);
		tfDate.setText(df.format(student.getDatum()));
		tfAdress.setText(student.getAdresaStanovanja());
		tfTelNum.setText(student.getKontaktTelefon());
		tfEmailAdr.setText(student.getEmailAdresa());
		tfIndNum.setText(student.getBrojIndeksa());
		tfYear.setText(Integer.toString(student.getGodinaUpisa()));
		switch(student.getTrenutnaGodinaStudija()){
		case 1:
			cbPresYear.setSelectedIndex(0);
			break;
		case 2:
			cbPresYear.setSelectedIndex(1);
			break;
		case 3:
			cbPresYear.setSelectedIndex(2);
			break;
		case 4:
			cbPresYear.setSelectedIndex(3);
			break;
		case 5:
			cbPresYear.setSelectedIndex(4);
			break;
		default:
			cbPresYear.setSelectedIndex(5);
		}
		if(student.getStatus() == Student.Finansiranje.B)
			cbFinan.setSelectedIndex(0);
		else
			cbFinan.setSelectedIndex(1);
	}

	private void ok() throws ParseException {
		
		String ime = tfFirstName.getText();
		String prez = tfLastName.getText();
		String datRodj = tfDate.getText();
		String adresa = tfAdress.getText();
		String brojTel = tfTelNum.getText();
		String emailAdr = tfEmailAdr.getText();
		String brIndeksa = tfIndNum.getText();
		String godUpisa = tfYear.getText();
		String trenGodStud = Integer.toString(cbPresYear.getSelectedIndex());
		String nacin = Integer.toString(cbFinan.getSelectedIndex());
		
		if (studentController == null) {
			studentController = new StudentiController(this);
		}
		
		String message = studentController.addStudent(ime,prez,datRodj,adresa,brojTel,emailAdr,brIndeksa,godUpisa,trenGodStud,nacin);

		Window parent = SwingUtilities.getWindowAncestor(this);
		
		JOptionPane.showMessageDialog(parent, message);
		
		if(message=="Student uspešno dodat")
			parent.setVisible(false);
	}

}
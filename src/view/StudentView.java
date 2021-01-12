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
import listeners.document.StudentDocumentListener;
import listeners.focus.TextFieldFocusListener;
import listeners.key.DateKeyListener;
import listeners.key.TelNumKeyListener;
import listeners.key.YearKeyListener;
import model.BazaStudenata;
import model.Student;
import controller.StudentiController;

public class StudentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StudentView instance = null;

	public static StudentView getInstance() {
		if (instance == null) {
			instance = new StudentView();
		}
		return instance;
	}
	
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
	
	private JLabel lblMessage;
	
	public StudentView(int selRow) throws ParseException {
		initGUI(true);
		constructGUI();

		setStudent(BazaStudenata.getInstance().getRow(selRow));
	}
	public StudentView()
	{
		initGUI(false);
		constructGUI();
	}

	private void initGUI(boolean update) {
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
		lblDate = new JLabel("Datum rođenja*");
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
				if(!update)
					dialog.actionPerformed(e,"Prekid unosa?","Da li ste sigurni da želite da prekinete dodavanje studenta?");
					else
					dialog.actionPerformed(e,"Prekid izmene?","Da li ste sigurni da želite da prekinete izmenu podataka o studentu?");
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
		lblMessage = new JLabel(" ");
		tfFirstName.getDocument().addDocumentListener(new StudentDocumentListener(1,this));
		tfLastName.getDocument().addDocumentListener(new StudentDocumentListener(2,this));
		tfDate.getDocument().addDocumentListener(new StudentDocumentListener(3,this));
		tfAdress.getDocument().addDocumentListener(new StudentDocumentListener(4,this));
		tfTelNum.getDocument().addDocumentListener(new StudentDocumentListener(5,this));
		tfEmailAdr.getDocument().addDocumentListener(new StudentDocumentListener(6,this));
		tfIndNum.getDocument().addDocumentListener(new StudentDocumentListener(7,this));
		tfYear.getDocument().addDocumentListener(new StudentDocumentListener(8,this));
		if(!update)
			btnOK.setEnabled(false);
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
		
		add(lblMessage, BorderLayout.SOUTH);
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
		String timePattern = "dd.MM.yyyy.";
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

	private void ok(boolean update) throws ParseException {
		
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
		
		String message;
		if(!update)
		{message = studentController.addStudent(ime,prez,datRodj,adresa,brojTel,emailAdr,brIndeksa,godUpisa,trenGodStud,nacin);}
		else
		{message = studentController.updateStudent(ime,prez,datRodj,adresa,brojTel,emailAdr,brIndeksa,godUpisa,trenGodStud,nacin,student.getBrojIndeksa());}
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		JOptionPane.showMessageDialog(parent, message);
		
		if(message=="Student uspešno dodat" || message =="Student uspešno izmenjen")
			parent.setVisible(false);
	}
	
	public JTextField getTfFirstName() {
		return tfFirstName;
	}
	public void setTfFirstName(JTextField tfFirstName) {
		this.tfFirstName = tfFirstName;
	}
	public JTextField getTfLastName() {
		return tfLastName;
	}
	public void setTfLastName(JTextField tfLastName) {
		this.tfLastName = tfLastName;
	}
	public JTextField getTfDate() {
		return tfDate;
	}
	public void setTfDate(JTextField tfDate) {
		this.tfDate = tfDate;
	}
	public JTextField getTfAdress() {
		return tfAdress;
	}
	public void setTfAdress(JTextField tfAdress) {
		this.tfAdress = tfAdress;
	}
	public JTextField getTfTelNum() {
		return tfTelNum;
	}
	public void setTfTelNum(JTextField tfTelNum) {
		this.tfTelNum = tfTelNum;
	}
	public JTextField getTfEmailAdr() {
		return tfEmailAdr;
	}
	public void setTfEmailAdr(JTextField tfEmailAdr) {
		this.tfEmailAdr = tfEmailAdr;
	}
	public JTextField getTfIndNum() {
		return tfIndNum;
	}
	public void setTfIndNum(JTextField tfIndNum) {
		this.tfIndNum = tfIndNum;
	}
	public JTextField getTfYear() {
		return tfYear;
	}
	public void setTfYear(JTextField tfYear) {
		this.tfYear = tfYear;
	}
	public JButton getBtnOK() {
		return btnOK;
	}
	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}
	public void disableBtnOk(){
		btnOK.setEnabled(false);
		pnlContent.repaint();
		this.validate();
	}
	public void enableBtnOk(){
		btnOK.setEnabled(true);
		this.validate();
	}
	public JLabel getLblMessage() {
		return lblMessage;
	}
	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}
	
}

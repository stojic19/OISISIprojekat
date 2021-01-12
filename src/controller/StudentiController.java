package controller;

import izgled.Tab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.BazaStudenata;
import model.Student;
import view.StudentView;

public class StudentiController {

private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	//private Student student;
	private StudentView studentView;
	
	public StudentiController(StudentView studentView){
		setStudentView(studentView);
	}
	public String addStudent(String ime,String prezime,String datRodj,String adresa,String brojTel,String emailAdr,String brIndeksa,String godUpisa,String trenGodStud,String nacin) throws ParseException {
		if (ime == null) {
			return "Unesite ime studenta";
		}
		ime = ime.trim();
		if (ime.isEmpty()) {
			return "Unesite ime studenta";
		}

		if (prezime == null) {
			return "Unesite prezime studenta";
		}
		prezime = prezime.trim();
		if (prezime.isEmpty()) {
			return "Unesite prezime studenta";
		}
		
		if (datRodj == null) {
			return "Unesite datum rođenja studenta";
		}
		datRodj = datRodj.trim();
		if (datRodj.isEmpty()) {
			return "Unesite datum rođenja studenta";
		}
		if(datRodj.length()!=11){
			return "Nepravilan format datuma";
		}
		if (adresa == null) {
			return "Unesite adresu stanovanja studenta";
		}
		adresa = adresa.trim();
		if (adresa.isEmpty()) {
			return "Unesite adresu stanovanja studenta";
		}
		if (brojTel == null) {
			return "Unesite broj telefona studenta";
		}
		brojTel = brojTel.trim();
		if (brojTel.isEmpty()) {
			return "Unesite broj telefona studenta";
		}
		if (emailAdr == null) {
			return "Unesite E-mail adresu studenta";
		}
		emailAdr = emailAdr.trim();
		if (emailAdr.isEmpty()) {
			return "Unesite E-mail adresu studenta";
		}
		if (brIndeksa == null) {
			return "Unesite broj indeksa studenta";
		}
		brIndeksa = brIndeksa.trim();
		if (brIndeksa.isEmpty()) {
			return "Unesite broj indeksa studenta";
		}
		List<Student> checkingList = BazaStudenata.getInstance().getStudenti();
		for(Student s: checkingList)
		{
			if(0==s.getBrojIndeksa().compareTo(brIndeksa))
				return "Broj indeksa već postoji. Unesite novi.";
		}
		if (godUpisa == null) {
			return "Unesite godinu upisa studenta";
		}
		godUpisa = godUpisa.trim();
		if (godUpisa.isEmpty()) {
			return "Unesite godinu upisa studenta";
		}
		if(godUpisa.length()!=4){
			return "Nepravilna dužina godine upisa";
		}
		
		if (trenGodStud == null) {
			return "Odaberite treuntnu godinu studiranja studenta";
		}
		trenGodStud = trenGodStud.trim();
		if (trenGodStud.isEmpty()) {
			return "Odaberite trenutnu godinu studiranja studenta";
		}
		
		if (nacin == null) {
			return "Odaberite način finansiranja studenta";
		}
		nacin = nacin.trim();
		if (nacin.isEmpty()) {
			return "Odaberite način finansiranja studenta";
		}
			int index = Integer.parseInt(nacin);
		BazaStudenata.getInstance().addStudent(ime, prezime, new SimpleDateFormat("dd.MM.yyyy").parse(datRodj), adresa, brojTel, emailAdr, brIndeksa,Integer.parseInt(godUpisa),Integer.parseInt(trenGodStud)+1,((index == 0) ? Student.Finansiranje.B : Student.Finansiranje.S));
		//studentView.refreshView();
		Tab.getInstance().azurirajPrikazStudenta("DODAT", -1);
		return "Student uspešno dodat";
	}
	public String updateStudent(String ime,String prezime,String datRodj,String adresa,String brojTel,String emailAdr,String brIndeksa,String godUpisa,String trenGodStud,String nacin,String izuzetak) throws ParseException {
		if (ime == null) {
			return "Unesite ime studenta";
		}
		ime = ime.trim();
		if (ime.isEmpty()) {
			return "Unesite ime studenta";
		}

		if (prezime == null) {
			return "Unesite prezime studenta";
		}
		prezime = prezime.trim();
		if (prezime.isEmpty()) {
			return "Unesite prezime studenta";
		}
		
		if (datRodj == null) {
			return "Unesite datum rodjenja studenta";
		}
		datRodj = datRodj.trim();
		if (datRodj.isEmpty()) {
			return "Unesite datum rodjenja studenta";
		}
		if(datRodj.length()!=11){
			return "Nepravilan format datuma";
		}
		if (adresa == null) {
			return "Unesite adresu stanovanja studenta";
		}
		adresa = adresa.trim();
		if (adresa.isEmpty()) {
			return "Unesite adresu stanovanja studenta";
		}
		if (brojTel == null) {
			return "Unesite broj telefona studenta";
		}
		brojTel = brojTel.trim();
		if (brojTel.isEmpty()) {
			return "Unesite broj telefona studenta";
		}
		if (emailAdr == null) {
			return "Unesite E-mail adresu studenta";
		}
		emailAdr = emailAdr.trim();
		if (emailAdr.isEmpty()) {
			return "Unesite E-mail adresu studenta";
		}
		if (brIndeksa == null) {
			return "Unesite broj indeksa studenta";
		}
		brIndeksa = brIndeksa.trim();
		if (brIndeksa.isEmpty()) {
			return "Unesite broj indeksa studenta";
		}
		List<Student> checkingList = BazaStudenata.getInstance().getStudenti();
		for(Student s: checkingList)
		{
			if(0==s.getBrojIndeksa().compareTo(brIndeksa) && 0!=izuzetak.compareTo(brIndeksa))
				return "Broj indeksa vec postoji. Unesite novi.";
		}
		if (godUpisa == null) {
			return "Unesite godinu upisa studenta";
		}
		godUpisa = godUpisa.trim();
		if (godUpisa.isEmpty()) {
			return "Unesite godinu upisa studenta";
		}
		if(godUpisa.length()!=4){
			return "Nepravilna dužina godine upisa";
		}
		
		if (trenGodStud == null) {
			return "Odaberite treuntnu godinu studiranja studenta";
		}
		trenGodStud = trenGodStud.trim();
		if (trenGodStud.isEmpty()) {
			return "Odaberite trenutnu godinu studiranja studenta";
		}
		
		if (nacin == null) {
			return "Odaberite nacin finansiranja studenta";
		}
		nacin = nacin.trim();
		if (nacin.isEmpty()) {
			return "Odaberite nacin finansiranja studenta";
		}
		int index = Integer.parseInt(nacin);
		BazaStudenata.getInstance().editStudent(ime, prezime, new SimpleDateFormat("dd.MM.yyyy").parse(datRodj), adresa, brojTel, emailAdr, brIndeksa,Integer.parseInt(godUpisa),Integer.parseInt(trenGodStud)+1,((index == 0) ? Student.Finansiranje.B : Student.Finansiranje.S),izuzetak);
		Tab.getInstance().azurirajPrikazStudenta(null, -1);
		//studentView.refreshView();
		return "Student uspešno izmenjen";
	}
	public void removeStudent(int rowSelectedIndex) throws ParseException {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().removeStudent(student.getBrojIndeksa());
		Tab.getInstance().azurirajPrikazStudenta("UKLONJEN", rowSelectedIndex);
    }
	public StudentView getStudentView() {
		return studentView;
	}

	private void setStudentView(StudentView studentView) {
		if (studentView == null) {
			throw new NullPointerException();
		}
		this.studentView = studentView;
	}
}

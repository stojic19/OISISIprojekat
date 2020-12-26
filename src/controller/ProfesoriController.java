package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import izgled.Tab;
import model.BazaProfesora;
import model.Profesor;
import view.ProfesorView;

public class ProfesoriController {
     private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	private ProfesorView profesorView;
	
	public ProfesoriController(ProfesorView profesorView){
		setProfesorView(profesorView);
	}
	
	
	public String addProfesor(String prz,String ime,String datRodj,String adrs,String ktel,String email,String adrk,String brlk,String titula,String zvanje) throws ParseException {
		
		List<Profesor> checkingList = BazaProfesora.getInstance().getProfesori();
		
		
		
		if (prz == null) {
			return "Unesite prezime profesora";
		}
		prz = prz.trim();
		if (prz.isEmpty()) {
			return "Unesite prezime profesora";
		}

		if (ime == null) {
			return "Unesite ime profesora";
		}
		ime = ime.trim();
		if (ime.isEmpty()) {
			return "Unesite prezime profesora";
		}
		
		if (datRodj == null) {
			return "Unesite datum rođenja profesora";
		}
		datRodj = datRodj.trim();
		if (datRodj.isEmpty()) {
			return "Unesite datum rođenja profesora";
		}
		if(datRodj.length()!=11){
			return "Nepravilan format datuma";
		}
		if (adrs == null) {
			return "Unesite adresu stanovanja profesora";
		}
		adrs = adrs.trim();
		if (adrs.isEmpty()) {
			return "Unesite adresu stanovanja profesora";
		}
		if (ktel == null) {
			return "Unesite kontakt telefon profesora";
		}
		ktel = ktel.trim();
		if (ktel.isEmpty()) {
			return "Unesite kontakt telefon profesora";
		}
		if (email == null) {
			return "Unesite E-mail adresu profesora";
		}
		email = email.trim();
		if (email.isEmpty()) {
			return "Unesite E-mail adresu profesora";
		}
		if (adrk == null) {
			return "Unesite adresu kancelarije profesora";
		}
		adrk = adrk.trim();
		if (adrk.isEmpty()) {
			return "Unesite adresu kancelarije profesora";
		}
		
		brlk = brlk.trim();
		if (brlk.isEmpty()) {
			return "Unesite broj lične karte profesora";
		}
		if(brlk.length()<8){
			return "Broj lične karte ima minimalno 8 karaktera!";
		}
		for(Profesor p: checkingList)
		{
			if(0==p.getBrlk().compareTo(brlk))
				return "Broj lične karte već postoji. Unesite novi.";
		}
		
		Profesor pom=new Profesor();
		
		
		BazaProfesora.getInstance().addProfesor(prz,ime,new SimpleDateFormat("dd.MM.yyyy").parse(datRodj), adrs, ktel, email, adrk,brlk,pom.nadjiTitulu(titula),pom.nadjiZvanje(zvanje));
	
		Tab.getInstance().azurirajPrikazProfesora("DODAT", -1);
		return "Profesor uspešno dodat";
	}
	public ProfesorView getProfesorView() {
		return profesorView;
	}

	private void setProfesorView(ProfesorView profesorView) {
		if (profesorView == null) {
			throw new NullPointerException();
		}
		this.profesorView = profesorView;
	}
}

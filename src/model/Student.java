package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Ocena.VrednostOcene;
import model.Student.Finansiranje;

public class Student implements Serializable{

	public enum Finansiranje
	{
		B,S;
	}
	
	private String prezime;
	private String ime;
	private Date datum;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Finansiranje status;
	private Double prosecnaOcena;
	
	private List<Ocena> polozeniIspiti;
	private List<Predmet> nepolozeniIspiti;
	
	public Student(String ime,String prezime,Date datRodj,String adresa,String brojTel,String emailAdr,String brIndeksa,int godUpisa,int trenGodStud,Finansiranje nacin)
	{
		setPrezime(prezime);
		setIme(ime);
		setDatum(datRodj);
		setAdresaStanovanja(adresa);
		setKontaktTelefon(brojTel);
		setEmailAdresa(emailAdr);
		setBrojIndeksa(brIndeksa);
		setGodinaUpisa(godUpisa);
		setTrenutnaGodinaStudija(trenGodStud);
		setStatus(nacin);
		
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Predmet>();
		
		setProsecnaOcena(5.00);
	}
	public Student(String brIndeksa, String ime, String prezime, int trenGodStud,
			Date datRodj, String adresa, String brojTel, String emailAdr,
			Finansiranje nacin, int godUpisa) {
		
		setPrezime(prezime);
		setIme(ime);
		setDatum(datRodj);
		setAdresaStanovanja(adresa);
		setKontaktTelefon(brojTel);
		setEmailAdresa(emailAdr);
		setBrojIndeksa(brIndeksa);
		setGodinaUpisa(godUpisa);
		setTrenutnaGodinaStudija(trenGodStud);
		setStatus(nacin);
		
		polozeniIspiti = new ArrayList<Ocena>();
		nepolozeniIspiti = new ArrayList<Predmet>();
		
		setProsecnaOcena(5.00);
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmailAdresa() {
		return emailAdresa;
	}
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}
	public Finansiranje getStatus() {
		return status;
	}
	public void setStatus(Finansiranje status) {
		this.status = status;
	}
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public List<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}
	public void setPolozeniIspiti(List<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}
	public List<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}
	public void setNepolozeniIspiti(List<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	public void racunajProsek(){
		if(!polozeniIspiti.isEmpty())
		{
			double sum=0;
			for(Ocena o : polozeniIspiti)
			{
				if(o.getVrednostOcene() == VrednostOcene.SEST)
					sum += 6;
				else if(o.getVrednostOcene() == VrednostOcene.SEDAM)
					sum += 7;
				else if(o.getVrednostOcene() == VrednostOcene.OSAM)
					sum += 8;
				else if(o.getVrednostOcene() == VrednostOcene.DEVET)
					sum += 9;
				else
					sum += 10;
			}
			double avg = sum / polozeniIspiti.size();
			if(sum == 0)
			{
				prosecnaOcena = 5.00;
			}
			prosecnaOcena = avg;
		}
		else
		{
			prosecnaOcena = 5.00;
		}
	}
}

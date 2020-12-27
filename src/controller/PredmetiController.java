package controller;

import izgled.Tab;

import java.text.ParseException;
import java.util.List;

import model.BazaPredmeta;
import model.Predmet;
import view.PredmetView;

public class PredmetiController {

private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {}
	
	//private Predmet predmet;
	private PredmetView predmetView;
	
	public PredmetiController(PredmetView predmetView){
		setPredmetView(predmetView);
	}
	public String addPredmet(String spr, String naziv, String semestar, String godina, String espb) throws ParseException {
		if (spr == null) {
			return "Unesite šifru predmeta";
		}
		spr = spr.trim();
		if (spr.isEmpty()) {
			return "Unesite šifru predmeta";
		}
		List<Predmet> checkingList = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet p: checkingList)
		{
			if(p.getSpr().compareTo(spr)==0)
				return "Šifra predmeta već postoji. Unesite novu.";
		}
		
		if (naziv == null) {
			return "Unesite naziv predmeta";
		}
		naziv = naziv.trim();
		if (naziv.isEmpty()) {
			return "Unesite naziv predmeta";
		}
		
		if (semestar == null) {
			return "Unesite semestar u kom se predmet sluša";
		}
		semestar = semestar.trim();
		if (semestar.isEmpty()) {
			return "Unesite semestar u kom se predmet sluša";
		}
		
		if (godina == null) {
			return "Unesite godinu u kojoj se predmet sluša";
		}
		godina = godina.trim();
		if (godina.isEmpty()) {
			return "Unesite godinu u kojoj se predmet sluša";
		}
		
		if (espb == null) {
			return "Unesite koliko ESPB predmet nosi";
		}
		espb = espb.trim();
		if (espb.isEmpty()) {
			return "Unesite koliko ESPB predmet nosi";
		}
		if(espb.length()>2){
			return "Predmet ne može nositi broj ESPB veći od dvocifrenog";
		}
		int index = Integer.parseInt(semestar);
		BazaPredmeta.getInstance().addPredmet(spr, naziv, ((index == 0) ? Predmet.Semestar.ZIMSKI : Predmet.Semestar.LETNJI), Integer.parseInt(godina)+1, Integer.parseInt(espb));
		Tab.getInstance().azurirajPrikazPredmeta("DODAT", -1);
		return "Predmet uspešno dodat";
	}
	public String updatePredmet(String spr, String naziv, String semestar, String godina, String espb,String izuzetak) throws ParseException {
		if (spr == null) {
			return "Unesite šifru predmeta";
		}
		spr = spr.trim();
		if (spr.isEmpty()) {
			return "Unesite šifru predmeta";
		}
		List<Predmet> checkingList = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet p: checkingList)
		{
			if(p.getSpr().compareTo(spr)==0 && izuzetak.compareTo(spr)!=0)
				return "Šifra predmeta već postoji. Unesite novu.";
		}
		
		if (naziv == null) {
			return "Unesite naziv predmeta";
		}
		naziv = naziv.trim();
		if (naziv.isEmpty()) {
			return "Unesite naziv predmeta";
		}
		
		if (semestar == null) {
			return "Unesite semestar u kom se predmet sluša";
		}
		semestar = semestar.trim();
		if (semestar.isEmpty()) {
			return "Unesite semestar u kom se predmet sluša";
		}
		
		if (godina == null) {
			return "Unesite godinu u kojoj se predmet sluša";
		}
		godina = godina.trim();
		if (godina.isEmpty()) {
			return "Unesite godinu u kojoj se predmet sluša";
		}
		
		if (espb == null) {
			return "Unesite koliko ESPB predmet nosi";
		}
		espb = espb.trim();
		if (espb.isEmpty()) {
			return "Unesite koliko ESPB predmet nosi";
		}
		if(espb.length()>2){
			return "Predmet ne može nositi broj ESPB veći od dvocifrenog";
		}
		int index = Integer.parseInt(semestar);
		BazaPredmeta.getInstance().editPredmet(spr, naziv, ((index == 0) ? Predmet.Semestar.ZIMSKI : Predmet.Semestar.LETNJI), Integer.parseInt(godina)+1, Integer.parseInt(espb),izuzetak);
		Tab.getInstance().azurirajPrikazPredmeta(null, -1);
		return "Predmet uspešno izmenjen";
	}
	public PredmetView getPredmetView() {
		return predmetView;
	}

	private void setPredmetView(PredmetView predmetView) {
		if (predmetView == null) {
			throw new NullPointerException();
		}
		this.predmetView = predmetView;
	}
}

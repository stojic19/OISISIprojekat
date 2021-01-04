package model;

import java.util.ArrayList;
import java.util.List;

import model.Predmet.Semestar;

public class BazaProfesorPredajePredmete {
	private static BazaProfesorPredajePredmete instance = null;

	public static BazaProfesorPredajePredmete getInstance() {
		if (instance == null) {
			instance = new BazaProfesorPredajePredmete();
		}
		return instance;
	}

  	private List<Predmet> predmeti;
  	private List<String> kolone;

  	private BazaProfesorPredajePredmete() {
  		
  		initPPPredmete();

  		this.kolone = new ArrayList<String>();
  		this.kolone.add("Šifra");
  		this.kolone.add("Naziv");
  		this.kolone.add("Godina studija");
  		this.kolone.add("Semestar");
  	}
  	
  	private void initPPPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		
	}
  	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSpr();
		case 1:
			return predmet.getNaziv();
		case 2:
			return String.valueOf(predmet.getGodina());
		case 3:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		}
	}
	
	public void addPredmet(String spr,String naz,Semestar s,int godina,int espb) {
		this.predmeti.add(new Predmet(spr,naz,s,godina,espb));
	}

	public void removePredmet(String spr) {
		for (Predmet p : predmeti) {
			if (p.getSpr().compareTo(spr) == 0) {
				predmeti.remove(p);
				break;
			}
		}
	}
}

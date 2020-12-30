package model;
import java.util.ArrayList;
import java.util.List;
import model.Predmet.Semestar;

public class BazaNepolozenihPredmeta {
	
	private static BazaNepolozenihPredmeta instance = null;

	public static BazaNepolozenihPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaNepolozenihPredmeta();
		}
		return instance;
	}

  	private List<Predmet> predmeti;
  	private List<String> kolone;

  	private BazaNepolozenihPredmeta() {
  		
  		initNepolozenePredmete();

  		this.kolone = new ArrayList<String>();
  		this.kolone.add("Šifra predmeta");
  		this.kolone.add("Naziv predmeta");
  		this.kolone.add("ESPB");
  		this.kolone.add("Godina");
  		this.kolone.add("Semestar");
  	}
  	
  	private void initNepolozenePredmete() {
		this.predmeti = new ArrayList<Predmet>();
		
	}
  	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
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
			   return Integer.toString(predmet.getEspb());
		case 3:
			   return Integer.toString(predmet.getGodina());
		case 4:
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

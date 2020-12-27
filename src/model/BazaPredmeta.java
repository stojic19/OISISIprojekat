package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	
	private List<Predmet> predmeti =new ArrayList<>();
	private List<String> kolone = new ArrayList<>();

	private BazaPredmeta() {
	   
	
		initProfesore();

		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
	}

	
	  private String spr;
      private String naziv;
      private Semestar semestar;
      private int godina;
      private Profesor profesor;
      private int espb;
      private List<Student> polozili= new ArrayList<Student>();
      private List<Student> nisuPolozili= new ArrayList<Student>();


	private void initProfesore() {
			
			Predmet p1= new Predmet("E11","Algebra",Semestar.ZIMSKI,1,new Profesor(),8,new ArrayList<Student>(),new ArrayList<Student>());
			Predmet p2= new Predmet("E12","Matematička analiza 1",Semestar.ZIMSKI,1,new Profesor(),8,new ArrayList<Student>(),new ArrayList<Student>());
			Predmet p3= new Predmet("E11","Arhitektura računara",Semestar.LETNJI,1,new Profesor(),8,new ArrayList<Student>(),new ArrayList<Student>());
			Predmet p4= new Predmet("E11","Matematička analiza 2",Semestar.ZIMSKI,2,new Profesor(),8,new ArrayList<Student>(),new ArrayList<Student>());
			Predmet p5= new Predmet("E11","Sociologija",Semestar.LETNJI,2,new Profesor(),3,new ArrayList<Student>(),new ArrayList<Student>());
			Predmet p6= new Predmet("E11","Programski prevodioci",Semestar.ZIMSKI,3,new Profesor(),3,new ArrayList<Student>(),new ArrayList<Student>());
			predmeti.add(p1);
			predmeti.add(p2);
			predmeti.add(p3);
			predmeti.add(p4);
			predmeti.add(p5);
			predmeti.add(p6);
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
			return String.valueOf(predmet.getEspb());
		case 3:
			return String.valueOf(predmet.getGodina());
		case 4:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		}
	}
	

}

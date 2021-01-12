package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Predmet.Semestar;

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
	private List<Predmet> refresh =new ArrayList<>();

	private BazaPredmeta() {
	   
	
		initPredmete();

		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
	}

	private void initPredmete() {
			loadPredmetData();
		/*
			Predmet p1= new Predmet("E11","Algebra",Predmet.Semestar.ZIMSKI,1,8);
			Predmet p2= new Predmet("E12","Matematička analiza 1",Predmet.Semestar.ZIMSKI,1,8);
			Predmet p3= new Predmet("E13","Arhitektura računara",Predmet.Semestar.LETNJI,1,8);
			Predmet p4= new Predmet("E14","Matematička analiza 2",Predmet.Semestar.ZIMSKI,2,8);
			Predmet p5= new Predmet("E15","Sociologija",Predmet.Semestar.LETNJI,2,3);
			Predmet p6= new Predmet("E16","Programski prevodioci",Predmet.Semestar.ZIMSKI,3,3);
			predmeti.add(p1);
			predmeti.add(p2);
			predmeti.add(p3);
			predmeti.add(p4);
			predmeti.add(p5);
			predmeti.add(p6);
			*/
			refresh=predmeti;
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
	
	public void addPredmet(String spr, String naziv, Semestar semestar, int godina, int espb) {
		this.predmeti.add(new Predmet(spr, naziv, semestar, godina, espb));
		refresh=predmeti;
		
	}

	public void removePredmet(String spr) throws ParseException {
		for (Predmet p : predmeti) {
			if (p.getSpr() == spr) {	
				predmeti.remove(p);
				break;
			}
		}
		for (Predmet p : refresh) {
			if (p.getSpr() == spr) {
				refresh.remove(p);
				break;
			}
		}
	}

	public void editPredmet(String spr, String naziv, Semestar semestar, int godina, int espb, String staraSpr) {
		for (Predmet p : predmeti) {
			if (p.getSpr().compareTo(staraSpr) == 0){
				p.setSpr(spr);
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodina(godina);
				p.setEspb(espb);
				
				
				try {
					for(Profesor prof : BazaProfesora.getInstance().getProfesori()){
						for(Predmet p1 : prof.getPredmeti()){
							if(p1.getSpr().compareTo(p.getSpr())==0){
								p1 = p;
								break;
							}
						}
					}
					for(Student s : BazaStudenata.getInstance().getStudenti()){
						for(Ocena o : s.getPolozeniIspiti())
						{
							if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
								o.setPredmet(p);
								break;
							}
						}
						for(Predmet p1 : s.getNepolozeniIspiti()){
							if(p1.getSpr().compareTo(p.getSpr())==0){
								p1 = p;
								break;
							}
						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (Predmet p : refresh) {
			if (p.getSpr().compareTo(staraSpr) == 0){
				p.setSpr(spr);
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodina(godina);
				p.setEspb(espb);
			}
		}
		
	}
	public void osveziPrikaz() {
		predmeti=refresh;
	}
	
	 public void savePredmetData() {
		    ObjectOutputStream out=null;
			try {
			    out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.txt")));
			
					out.writeObject(predmeti);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(out!=null) {
					  try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
	   }
	 
	 @SuppressWarnings("unchecked")
		public void loadPredmetData(){
			 ObjectInputStream in;
			try {
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.txt")));
				predmeti = (ArrayList<Predmet>)in.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

	public void dodajStudentaUNepolozene(String spr, int selRow) {
		for(Predmet p : predmeti){
			if(p.getSpr().compareTo(spr)==0){
				try {
					p.getNisuPolozili().add(BazaStudenata.getInstance().getRow(selRow));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void ukloniStudentaSaPredmeta(String spr, int selRow) {
		for(Predmet p : predmeti){
			if(p.getSpr().compareTo(spr)==0){
				try {
					p.getNisuPolozili().remove(BazaStudenata.getInstance().getRow(selRow));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void ukloniProfesoraSaPredmeta(String spr, int selRow) {
		for(Predmet p : predmeti){
			if(p.getSpr().compareTo(spr)==0){
				try {
					if(p.getProfesor()==null){
						break;
					}
					if(p.getProfesor().getBrlk().compareTo(BazaProfesora.getInstance().getRow(selRow).getBrlk())==0){
						p.setProfesor(null);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

}

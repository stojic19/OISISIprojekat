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
			
		Semestar s1 = Semestar.LETNJI;
		Semestar s2 = Semestar.ZIMSKI;
		try {
			predmeti.add(new Predmet("p1", "osnove programiranja", 1, 7, BazaProfesora.getInstance().getProfesorByBrlk("321321321"), s2));
			
		predmeti.add(new Predmet("p2", "statistika", 3, 8, BazaProfesora.getInstance().getProfesorByBrlk("321321321"), s1));
		predmeti.add(new Predmet("p3", "algoritmi i strukture podataka", 2, 9, BazaProfesora.getInstance().getProfesorByBrlk("321321321"), s1));
		predmeti.add(new Predmet("p4", "LPRS", 3, 7, BazaProfesora.getInstance().getProfesorByBrlk("321321321"), s2));
		predmeti.add(new Predmet("p5", "matematika", 1, 11, null, s1));	
		predmeti.add(new Predmet("p6", "xml i web servisi", 4, 6, null, s1));
		predmeti.add(new Predmet("p7", "Metode optimizacije", 3, 6,null, s2));
		predmeti.add(new Predmet("p8", "osnove elektortehnike", 1, 11, BazaProfesora.getInstance().getProfesorByBrlk("001001001"), s1));
		predmeti.add(new Predmet("p9", "Sociologija", 1, 10, BazaProfesora.getInstance().getProfesorByBrlk("001001001"), s2));
		predmeti.add(new Predmet("p10", "Filozofija", 1, 4, BazaProfesora.getInstance().getProfesorByBrlk("001001001"), s2));
		predmeti.add(new Predmet("p11", "ORT", 2, 7, null, s1));
		predmeti.add(new Predmet("p12", "NANS", 2, 5, BazaProfesora.getInstance().getProfesorByBrlk("002002002"), s1));
		predmeti.add(new Predmet("p13", "Organizacija podataka", 2, 7, BazaProfesora.getInstance().getProfesorByBrlk("002002002"), s2));
		predmeti.add(new Predmet("p14", "Baze podataka", 2, 6, BazaProfesora.getInstance().getProfesorByBrlk("002002002"), s2));
		predmeti.add(new Predmet("p15", "paralelno programiranje", 2, 8, BazaProfesora.getInstance().getProfesorByBrlk("559585632"), s2));
		predmeti.add(new Predmet("p16", "konkurentno programiranje", 2, 9, BazaProfesora.getInstance().getProfesorByBrlk("559585632"), s1));
		predmeti.add(new Predmet("p17", "Operativni sistemi", 2, 8, null, s1));
		predmeti.add(new Predmet("p18", "Algebra", 1, 15, null, s2));
		predmeti.add(new Predmet("p19", "Verovatnoca", 3, 14, null, s1));
		predmeti.add(new Predmet("ps20", "Upravljacki sistemi", 3, 8, null, s1));
		predmeti.add(new Predmet("ps21", "Osnovi elektronike", 2, 7, null, s2));
		predmeti.add(new Predmet("ps22", "Slucajni procesi", 4, 9, null, s1));
		predmeti.add(new Predmet("ps23", "Racunarstvo visokih performansi", 4, 10, null, s1));
		predmeti.add(new Predmet("ps24", "Analiza 1", 1, 1, null, s2));
		predmeti.add(new Predmet("it25", "Informaciona bezbednost", 4, 9, BazaProfesora.getInstance().getProfesorByBrlk("004004004"), s1));  
		predmeti.add(new Predmet("it26", "Elektronsko placanje", 3, 8, BazaProfesora.getInstance().getProfesorByBrlk("005005005"), s2));
		predmeti.add(new Predmet("it27", "Distribuirani sistemi", 4, 6, BazaProfesora.getInstance().getProfesorByBrlk("006006006"), s2));
		predmeti.add(new Predmet("p28", "Projektovanje softvera", 3, 5, BazaProfesora.getInstance().getProfesorByBrlk("005005005"), s2));
		predmeti.add(new Predmet("p29", "Informacioni sistemi", 4, 6, BazaProfesora.getInstance().getProfesorByBrlk("004004004"), s2));
		predmeti.add(new Predmet("p30", "Masinsko ucenje", 4, 7, null, s1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Predmet p : predmeti){
			try {
				if(p.getProfesor()!=null)
				BazaProfesora.getInstance().getProfesorByBrlk(p.getProfesor().getBrlk()).getPredmeti().add(p);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
			
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

	public Object getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSpr();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getEspb();
		case 3:
			return predmet.getGodina();
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
				
				
				for(Profesor prof : BazaProfesora.getInstance().getProfesori()){
					for(Predmet p1 : prof.getPredmeti()){
						if(p1.getSpr().compareTo(p.getSpr())==0){
							prof.getPredmeti().remove(p1);
							break;
						}
					}
				}
				for(Student s : BazaStudenata.getInstance().getStudenti()){
					for(Ocena o : s.getPolozeniIspiti())
					{
						if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
							s.getPolozeniIspiti().remove(o);
							break;
						}
					}
					for(Predmet p1 : s.getNepolozeniIspiti()){
						if(p1.getSpr().compareTo(p.getSpr())==0){
							s.getNepolozeniIspiti().remove(p1);
							break;
						}
					}
				}
				
				
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
							if(p1.getSpr().compareTo(staraSpr)==0){
								p1.setSpr(p.getSpr());
								p1.setNaziv(p.getNaziv());
								p1.setSemestar(p.getSemestar());
								p1.setGodina(p.getGodina());
								p1.setEspb(p.getEspb());
								p1.setProfesor(p.getProfesor());
								break;
							}
						}
					}
					for(Student s : BazaStudenata.getInstance().getStudenti()){
						for(Ocena o : s.getPolozeniIspiti())
						{
							if(o.getPredmet().getSpr().compareTo(staraSpr)==0){
								o.setPredmet(p);
								break;
							}
						}
						for(Predmet p1 : s.getNepolozeniIspiti()){
							if(p1.getSpr().compareTo(staraSpr)==0){
								p1.setSpr(spr);
								p1.setNaziv(naziv);
								p1.setSemestar(semestar);
								p1.setGodina(godina);
								p1.setEspb(espb);
								p1.setProfesor(p.getProfesor());
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
	public void ponistiOcenu(String spr, int selRow) {
		for(Predmet p : predmeti){
			if(p.getSpr().compareTo(spr)==0){
				try {
					p.getNisuPolozili().add(BazaStudenata.getInstance().getRow(selRow));
					p.getPolozili().remove(BazaStudenata.getInstance().getRow(selRow));
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
	
public void poloziIspit(String spr, int selRow){
		for(Predmet p : predmeti){
			if(p.getSpr().compareTo(spr)==0){
				try {
					p.getPolozili().add(BazaStudenata.getInstance().getRow(selRow));
					p.getNisuPolozili().remove(BazaStudenata.getInstance().getRow(selRow));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
public void azurirajPredmet(String spr) {
		for (Predmet p : predmeti) {
			if (p.getSpr().compareTo(spr) == 0){
				try {
					for(Profesor prof : BazaProfesora.getInstance().getProfesori()){
						for(Predmet p1 : prof.getPredmeti()){
							if(p1.getSpr().compareTo(p.getSpr())==0){
								p1.setSpr(p.getSpr());
								p1.setNaziv(p.getNaziv());
								p1.setSemestar(p.getSemestar());
								p1.setGodina(p.getGodina());
								p1.setEspb(p.getEspb());
								p1.setProfesor(p.getProfesor());
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
								p1.setSpr(p.getSpr());
								p1.setNaziv(p.getNaziv());
								p1.setSemestar(p.getSemestar());
								p1.setGodina(p.getGodina());
								p1.setEspb(p.getEspb());
								p1.setProfesor(p.getProfesor());
								break;
							}
						}
					}
					for (Predmet p1 : refresh) {
						if (p1.getSpr().compareTo(spr) == 0){
							p1.setSpr(p.getSpr());
							p1.setNaziv(p.getNaziv());
							p1.setSemestar(p.getSemestar());
							p1.setGodina(p.getGodina());
							p1.setEspb(p.getEspb());
							p1.setProfesor(p.getProfesor());
						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

public void dodajProfesoraPredmetu(String spr, int selRow) {
	for(Predmet p : predmeti){
		if(p.getSpr().compareTo(spr)==0){
			try {			
				p.setProfesor(BazaProfesora.getInstance().getRow(selRow));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	}	
}

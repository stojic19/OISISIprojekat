package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() throws ParseException {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}



	private List<Profesor> profesori =new ArrayList<>();
	private List<Profesor> refresh =new ArrayList<>();
	private List<String> kolone = new ArrayList<>();

	private BazaProfesora() throws ParseException {
	
	
		initProfesore();

		this.kolone.add("Prezime");
		this.kolone.add("Ime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		

	}

	private void initProfesore() throws ParseException {
		loadProfesorData();
		/*
		Profesor p1= new Profesor("Nikolić","Nikola",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa1","0394320492049","mejl1","Adresa k1","12345678",Titula.DR,Zvanje.ASISTENT);
		Profesor p2= new Profesor("Lukić","Luka",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa2","0394320492049","mejl2","Adresa k2","21345678",Titula.MR,Zvanje.VANREDNIPROFESOR);
		Profesor p3= new Profesor("Minić","Mina",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa3","0394320492049","mejl3","Adresa k3","31245678",Titula.DR,Zvanje.REDOVNIPROFESOR);
		Profesor p4= new Profesor("Marković","Marko",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa4","0394320492049","mejl4","Adresa k4","41235678",Titula.MSC,Zvanje.DOCENT);
		Profesor p5= new Profesor("Popović","Nikola",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa1","0394320492049","mejl1","Adresa k1","51234678",Titula.BSC,Zvanje.ASISTENT);
		Profesor p6= new Profesor("Jovanović","Jovan",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."),"Adresa2","0394320492049","mejl2","Adresa k2","612345678",Titula.PROFDR,Zvanje.VANREDNIPROFESOR);
		profesori.add(p1);
		profesori.add(p2);
		profesori.add(p3);
		profesori.add(p4);
		profesori.add(p5);
		profesori.add(p6);
		
		profesori.get(0).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		profesori.get(0).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(5).getSpr(),BazaPredmeta.getInstance().getRow(5).getNaziv(),
				BazaPredmeta.getInstance().getRow(5).getSemestar(),BazaPredmeta.getInstance().getRow(5).getGodina(),
				BazaPredmeta.getInstance().getRow(5).getEspb()));
		profesori.get(1).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		profesori.get(1).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(5).getSpr(),BazaPredmeta.getInstance().getRow(5).getNaziv(),
				BazaPredmeta.getInstance().getRow(5).getSemestar(),BazaPredmeta.getInstance().getRow(5).getGodina(),
				BazaPredmeta.getInstance().getRow(5).getEspb()));
		profesori.get(2).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		profesori.get(2).getPredmeti().add(new Predmet(BazaPredmeta.getInstance().getRow(5).getSpr(),BazaPredmeta.getInstance().getRow(5).getNaziv(),
				BazaPredmeta.getInstance().getRow(5).getSemestar(),BazaPredmeta.getInstance().getRow(5).getGodina(),
				BazaPredmeta.getInstance().getRow(5).getEspb()));
				
		profesori.add(new Profesor("Milos", "Nikolic", new SimpleDateFormat("dd.MM.yyyy.").parse("12.12.1965."), "Temerinska 15, Novi Sad" , "021/356-785", "milos.nikolic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 600", "123123123", Titula.PROFDR, Zvanje.REDOVNIPROFESOR, null));
		profesori.add(new Profesor("Nikola", "Mirkovic", new SimpleDateFormat("dd.MM.yyyy.").parse("01.01.1978."), "Jovana Cvjića 25, Subotica" , "021/368-456", "nikola.mirkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 601", "321321321", Titula.PROFDR, Zvanje.REDOVNIPROFESOR, null));
		profesori.add(new Profesor("Ilija", "Petkovic", new SimpleDateFormat("dd.MM.yyyy.").parse("03.09.1988."), "Gogoljeva 1, Novi Sad" , "021/215-314", "ilija.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 602", "456456456", Titula.DR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Mitar", "Petrovic", new SimpleDateFormat("dd.MM.yyyy.").parse("25.07.1976."), "Marka Kraljevića 102, Beograd" , "021/884-640", "mitar.petrovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 603", "789789789", Titula.DR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Vasa", "Micic", new SimpleDateFormat("dd.MM.yyyy.").parse("14.02.1970."), "Tolstojeva 55, Novi Sad" , "021/212-114", "vasa.micic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 604", "001001001", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Srdjan", "Miletic", new SimpleDateFormat("dd.MM.yyyy.").parse("20.04.1966."), "Šekspirova 12, Novi Sad" , "021/978-225", "mitar.petrovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 605", "002002002", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Branislav", "Mihajlovic", new SimpleDateFormat("dd.MM.yyyy.").parse("28.06.1980."), "Jovana Subotića 99, Novi Sad" , "021/778-323", "branislav.mihajlovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 606", "559585632", Titula.PROFDR, Zvanje.REDOVNIPROFESOR, null));
		profesori.add(new Profesor("Marko", "Marković", new SimpleDateFormat("dd.MM.yyyy.").parse("31.01.1985."), "Mirka Markovića 101, Kraljevo" , "021/899-659", "marko.markovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 607", "334968855", Titula.PROFDR, Zvanje.REDOVNIPROFESOR, null));
		profesori.add(new Profesor("Miloš", "Milaković", new SimpleDateFormat("dd.MM.yyyy.").parse("21.09.1975."), "Braće Jugović 1, Kragujevac" , "021/122-326", "milos.milakovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 608", "073070365", Titula.DR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Lazar", "Bratić", new SimpleDateFormat("dd.MM.yyyy.").parse("13.11.1973."), "Jovanke Orleanke 3, Niš" , "021/156-326", "lazar.bratic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 609", "006003786", Titula.DR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Ljeposava", "Dražić", new SimpleDateFormat("dd.MM.yyyy.").parse("11.08.1964."), "Vojvode Stepe 1100, Beograd" , "021/888-156", "ljeposava.drazic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 610", "158496152", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Miroljub", "Dragić", new SimpleDateFormat("dd.MM.yyyy.").parse("02.03.1959."), "Miše Ljubibratiće 123, Aleksandrovac" , "021/456-125", "miroljub.dragic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 611", "777348595", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Bogdan", "Rekavić", new SimpleDateFormat("dd.MM.yyyy.").parse("23.06.1977."), "Resavska 12, Beograd" , "021/886-455", "bogdan.rekavic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 612", "721254363", Titula.DR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Stanka", "Milić", new SimpleDateFormat("dd.MM.yyyy.").parse("03.03.1990."), "Vidakovićeva 90, Novi Sad" , "021/945-255", "stanka.milic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 613", "225533448", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Milica", "Vuković", new SimpleDateFormat("dd.MM.yyyy.").parse("18.10.1967."), "Nikolićeva 12, Novi Sad" , "021/746-659", "milica.vukovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 614", "111555888", Titula.PROFDR, Zvanje.VANREDNIPROFESOR, null));
		profesori.add(new Profesor("Miša", "Mišić", new SimpleDateFormat("dd.MM.yyyy.").parse("20.10.1969."), "Šojićeva 10, Subotica" , "021/489-326", "misa.misic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 615", "003003003", Titula.DR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Branko", "Maricic", new SimpleDateFormat("dd.MM.yyyy.").parse("18.01.1973."), "Nikole Tesle 25, Sombor" , "021/487-265", "branko.maricic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 616", "004004004", Titula.PROFDR, Zvanje.DOCENT, null));
		profesori.add(new Profesor("Branislav", "Lukovic", new SimpleDateFormat("dd.MM.yyyy.").parse("08.04.1982."), "Živojina Mišića 7, Apatin" , "021/159-478", "branislav.lukovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 617", "005005005", Titula.DR, Zvanje.REDOVNIPROFESOR, null));
		profesori.add(new Profesor("Branimir", "Obradovic", new SimpleDateFormat("dd.MM.yyyy.").parse("07.01.1979."), "Stari šor 18, Sremska Mitrovica" , "021/922-333", "branimir.obradovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 618", "006006006", Titula.PROFDR, Zvanje.DOCENT, null));
		*/
		refresh=profesori;
	}

	

	public List<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);

		switch (column) {
		case 0:
			return profesor.getPrz();
		case 1:
			return profesor.getIme();
		case 2:
			return String.valueOf(profesor.getTitula());
		case 3:
			return String.valueOf(profesor.getZvanje());
		default:
			return null;
		}
	}
	
	public void addProfesor(String prz,String ime,Date datRodj,String adresa,String brojTel,String email,String Adrk,String brlk,Titula t,Zvanje z) {
		this.profesori.add(new Profesor(prz,ime,datRodj,adresa,brojTel,email,Adrk,brlk,t,z));
		refresh=profesori;
		
	}
	
	public void removeProfesor(String brLK) {
		for (Profesor p : profesori) {
			if (p.getBrlk().compareTo(brLK)==0) {
				
				for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()){
					if(pred.getProfesor()!=null)
					if(pred.getProfesor().getBrlk().compareTo(p.getBrlk())==0){
						pred.setProfesor(null);
					}
				}
				profesori.remove(p);
				break;
			}
		}
		for (Profesor p : refresh) {
			if (p.getBrlk().compareTo(brLK)==0) {
				refresh.remove(p);
				break;
			}
		}
	}

   
   public void osveziPrikaz() {
	   profesori=refresh;
   }
   public void editProfesor(String prz, String ime, Date datRodj, String adrs, String ktel, String email, String adrk,
			String brlk, Titula t, Zvanje z, String licna_p) {
	
			for (Profesor p : profesori) {
					if (0==p.getBrlk().compareTo(licna_p)) {
						p.setPrz(prz);
						p.setIme(ime);
						p.setDatrodj(datRodj);
						p.setAdrs(adrs);
						p.setKtel(ktel);
						p.setEmail(email);
						p.setAdrk(adrk);
						p.setBrlk(brlk);
						p.setTitula(t);
						p.setZvanje(z);
						
							
						for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()){
							if(pred.getProfesor()!=null)
							if(pred.getProfesor().getBrlk().compareTo(licna_p)==0){
								pred.setProfesor(p);
							}
						}
						for(Predmet pred : p.getPredmeti()){
							if(pred.getProfesor()!=null)
								if(pred.getProfesor().getBrlk().compareTo(licna_p)==0){
									pred.setProfesor(p);
								}
						}
						
						
						
						
					}
			}
			for (Profesor p : refresh) {
				if (0==p.getBrlk().compareTo(licna_p)) {
					p.setPrz(prz);
					p.setIme(ime);
					p.setDatrodj(datRodj);
					p.setAdrs(adrs);
					p.setKtel(ktel);
					p.setEmail(email);
					p.setAdrk(adrk);
					p.setBrlk(brlk);
					p.setTitula(t);
					p.setZvanje(z);
				}
	     	}
	}
   
   public void saveProfesorData() {
	    ObjectOutputStream out=null;
		try {
		    out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("profesori.txt")));
		
				out.writeObject(profesori);
			
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
	public void loadProfesorData(){
		 ObjectInputStream in;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("profesori.txt")));
			profesori = (ArrayList<Profesor>)in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
   
   public void azurirajProfesora(String brlk) {
		
		for (Profesor p : profesori) {
				if (0==p.getBrlk().compareTo(brlk)) {
					
					for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()){
						if(pred.getProfesor()!=null)
						if(pred.getProfesor().getBrlk().compareTo(brlk)==0){
							pred.setProfesor(p);
						}
					}
					for(Predmet pred : p.getPredmeti()){
								pred.setProfesor(p);
							for(Predmet pred1 : BazaPredmeta.getInstance().getPredmeti()){
								if(pred1.getSpr().matches(pred.getSpr())){
									pred1 = pred;
								}
							}
					}
				}
		}
		for (Profesor p : refresh) {
			if (0==p.getBrlk().compareTo(brlk)) {
				for(Predmet pred : BazaPredmeta.getInstance().getPredmeti()){
					if(pred.getProfesor()!=null)
					if(pred.getProfesor().getBrlk().compareTo(brlk)==0){
						pred.setProfesor(p);
					}
				}
				for(Predmet pred : p.getPredmeti()){
					if(pred.getProfesor()!=null)
						if(pred.getProfesor().getBrlk().compareTo(brlk)==0){
							pred.setProfesor(p);
						}
				}
			}
    	}
}

public Profesor getProfesorByBrlk(String string) {
	for(Profesor p : profesori){
		if(p!=null)
		if(p.getBrlk().matches(string))
			return p;
	}
	return null;
}

public void ukloniPredmetProfesoru(String brlk,String spr){
	 for(Profesor p : profesori){
		 if(p.getBrlk().matches(brlk)){
			 for(Predmet pred : p.getPredmeti()){
				 if(pred.getSpr().matches(spr)){
					 p.getPredmeti().remove(pred);
					 break;
				 }
			 }
			 break;
		 }
	 }
}
 
}


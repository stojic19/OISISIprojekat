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

import model.Student.Finansiranje;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() throws ParseException {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
	private List<Student> refresh;
	private List<String> kolone;

	private BazaStudenata() throws ParseException {
		
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}

	private void initStudente() throws ParseException {
		this.studenti = new ArrayList<Student>();
		loadStudentData();
		/*
		studenti.add(new Student("Magdalena", "Reljin",new SimpleDateFormat("dd.MM.yyyy.").parse("07.08.1978."), "Bulevar Severne Armije 45", "021021021", "adresa", "RA82/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Nenad", "Jecković",new SimpleDateFormat("dd.MM.yyyy.").parse("17.08.1979."), "Bulevar Severne Armije 45", "021021021", "adresa", "RA85/2018", 2018, 2 , Finansiranje.S));
		studenti.add(new Student("Anja", "Tanović",new SimpleDateFormat("dd.MM.yyyy.").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "EE49/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Jovana", "Đorđević",new SimpleDateFormat("dd.MM.yyyy.").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "II20/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Zorana", "Popović",new SimpleDateFormat("dd.MM.yyyy.").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "AU27/2018", 2018, 3 , Finansiranje.S));
	
		studenti.get(0).getPolozeniIspiti().add(new Ocena(studenti.get(0), BazaPredmeta.getInstance().getRow(1), Ocena.VrednostOcene.DESET, new SimpleDateFormat("dd.MM.yyyy.").parse("09.01.2021.")));
		studenti.get(0).getPolozeniIspiti().add(new Ocena(studenti.get(0), BazaPredmeta.getInstance().getRow(2), Ocena.VrednostOcene.OSAM, new SimpleDateFormat("dd.MM.yyyy.").parse("09.10.2021.")));
		
		studenti.get(0).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(3).getSpr(),BazaPredmeta.getInstance().getRow(3).getNaziv(),
				BazaPredmeta.getInstance().getRow(3).getSemestar(),BazaPredmeta.getInstance().getRow(3).getGodina(),
				BazaPredmeta.getInstance().getRow(3).getEspb()));
		studenti.get(0).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		
		
		studenti.get(1).getPolozeniIspiti().add(new Ocena(studenti.get(1), BazaPredmeta.getInstance().getRow(1), Ocena.VrednostOcene.DESET, new SimpleDateFormat("dd.MM.yyyy.").parse("09.01.2021.")));
		studenti.get(1).getPolozeniIspiti().add(new Ocena(studenti.get(1), BazaPredmeta.getInstance().getRow(2), Ocena.VrednostOcene.OSAM, new SimpleDateFormat("dd.MM.yyyy.").parse("09.10.2021.")));
		
		studenti.get(1).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(3).getSpr(),BazaPredmeta.getInstance().getRow(3).getNaziv(),
				BazaPredmeta.getInstance().getRow(3).getSemestar(),BazaPredmeta.getInstance().getRow(3).getGodina(),
				BazaPredmeta.getInstance().getRow(3).getEspb()));
		studenti.get(1).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		
		 Finansiranje s1 =  Finansiranje.B; 
		 Finansiranje s2 =  Finansiranje.S;
		studenti.add(new Student("RA 2/2020", "Marko", "Milosević",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("12.03.2001."),	"Karađorđeva 83, Novi Sad",	"021/333-555",	"marko.milosevic@mailinator.com", 	s1,	2020));
		studenti.add(new Student("RA 3/2019", "Marija", "Milić",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("12.03.2000."),	"Stražilovska 12, Novi Sad",	"021/555-2222",	"marija.milic@mailinator.com", 	s2,	2017));
		studenti.add(new Student("RA 3/2017", "Nikola", "Nikolic",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("30.08.2001."),	"Knez Mihajlova 16, Beograd",	"021/135-463",	"nikola.nikolic@mailinator.com", 	s1,	2017));
		studenti.add(new Student("RA 134/2015", "Pera", "Perić",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("07.06.1995."),	"Gogoljeva 3, Novi Sad",	"021/903-463",	"pera.peric@mailinator.com", 	s2,	2015));
		studenti.add(new Student("RA 5/2019", "Sofija", "Ilić",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("06.05.1999."),	"Miše Dimitrijevića 44, Novi Sad",	"021/731-067",	"sofija.ilic@mailinator.com", 	s1,	2019));
		studenti.add(new Student("RA 8/2018", "Martina", "Lukić",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("16.05.1999."),	"Vojvode Stepe 180, Beograd",	"011/4333-800",	"martina.lukic@mailinator.com", 	s2,	2018));
		studenti.add(new Student("RA 10/2017", "Stojan", "Stojaković",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("19.10.2001."),	"1300 Kaplara, Šabac",	"011/3130-007", "stojan.stojakovic@mailinator.com",	s1,	2017));
		studenti.add(new Student("RA 12/2017", "Milan", "Milanović",	2,	new SimpleDateFormat("dd.MM.yyyy.").parse("02.11.2000."),	"Surepova 12, Šabac",	"015/313-061", "milan.milanovic@mailinator.com", s2, 2017));
		studenti.add(new Student("RA 16/2019", "Miroslav", "Milic",	2,	new SimpleDateFormat("dd.MM.yyyy.").parse("11.10.2000."),	"Milovana Glišića, Valjevo",	"021/351-091", "miroslav.milic@mailinator.com", s1, 2019));
		studenti.add(new Student("RA 21/2015", "Stefan", "Gojic",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("01.05.1999."),	"Bulevar Mihajla Pupina, Novi Sad",	"015/324-500", "stefan.gojic@mailinator.com", s2, 2015));
		studenti.add(new Student("RA 9/2020", "Anastasija", "Jokic",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("11.07.1999."),	"Braće Ribnikar 12, Novi Sad",	"011/2333-900", "anastasija.jokic@mailinator.com", s1, 2020));
		studenti.add(new Student("RA 4/2017", "Bogdan", "Bogdanovic",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("23.07.1999."),	"Cara Dušana 42, Subotica",	"021/231-114", "bogdan.bogdanovic@mailinator.com", s2, 2017));
		studenti.add(new Student("RA 30/2019", "Ana", "Dabovic",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("12.12.2001."),	"Marka Kraljevića 1, Kikinda",	"014/303-007", "ana.dabovic@mailinator.com", s1, 2019));
		studenti.add(new Student("RA 1/2020", "Mika", "Mikic",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("05.11.2001."),	"Nikole Stojanovića 2, Kraljevo",	"015/101-909", "mika.mikic@mailinator.com", s2, 2020));
		studenti.add(new Student("RA 11/2018", "Jovan", "Deretic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("10.09.1998."),	"Marka Bratića 99, Niš",	"002/200-300", "jovan.deretic@mailinator.com", s1, 2018));
		studenti.add(new Student("RA 12/2018", "Nikola", "Miskovic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("03.08.1998."),	"Cara Dušana 12, Banja Luka",	"022/123-456", "nikola.miskovic@mailinator.com", s2, 2018));
		studenti.add(new Student("RA 13/2018", "Martin", "Stojanovic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("01.05.1998."),	"Borisa Bačkog 1, Bijeljina",	"024/321-775", "martin.stojanovic@mailinator.com", s2, 2018));
		studenti.add(new Student("RA 14/2018", "Tomislav", "Novakovic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("25.02.1996."),	"Mirka Maksića 10, Kruševac",	"011/1188-379", "tomislav.novakovic@mailinator.com", s1, 2018));
		studenti.add(new Student("RA 154/2016", "Lena", "Ivic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("11.05.1998."),	"Stari Most 6, Sremska Mitrovica",	"024/333-555", "lena.ivic@mailinator.com", s1, 2016));
		studenti.add(new Student("RA 23/2020", "Jovan", "Lazic",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("22.01.2001."),	"Nevesinjskih ustanika 10, Nevesinje",	"025/1189-479", "jovan.lazic@mailinator.com", s1, 2020));
		studenti.add(new Student("RA 1/2019", "Isidora", "Mikic",	2,	new SimpleDateFormat("dd.MM.yyyy.").parse("31.12.2000."),	"Radničка 11, Novi Sad",	"011/1122-366", "isidora.mikic@mailinator.com", s1, 2019));
		studenti.add(new Student("SW 4/2014", "Vladimir", "Ilic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("31.08.1998."),	"Miloša Obilića 1, Beograd",	"021/1122-367", "vladimir.ilic@mailinator.com", s1, 2014));
		studenti.add(new Student("SW 17/2015", "Mirko", "Alicic",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("21.07.1999."),	"Heroja Pinkija 112, Novi Sad",	"012/1122-368", "mirko.alicic@mailinator.com", s1, 2015));
		studenti.add(new Student("SW 17/2016", "Milisav", "Perkovic",	4,	new SimpleDateFormat("dd.MM.yyyy.").parse("28.09.1998."),	"Pavla Bakića 26, Novi Sad",	"012/1122-369", "milisav.pejkovic@mailinator.com", s2, 2016));
		studenti.add(new Student("SW 27/2018", "Purisa", "Djordjevic",	2,	new SimpleDateFormat("dd.MM.yyyy.").parse("29.02.2000."),	"Pavla Papa 1, Novi Sad",	"011/1543-370", "purisa.djordjevic@mailinator.com", s1, 2018));
		studenti.add(new Student("RA 226/2017", "Mikica", "Kovacevic",	3,	new SimpleDateFormat("dd.MM.yyyy.").parse("23.03.1999."),	"Valentina Vodnika 112, Novi Sad",	"011/1992-371", "mikica.kovacevic@mailinator.com", s2, 2017));
		studenti.add(new Student("SW 12/2020", "Miloš", "Milić",	1,	new SimpleDateFormat("dd.MM.yyyy.").parse("21.10.2001."),	"Neznanog junaka 12, Beograd",	"011/8172-372", "milos.milic@mailinator.com", s2, 2020));
		*/
		refresh = studenti;
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		student.racunajProsek();
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getTrenutnaGodinaStudija();
		case 4:
			if(student.getStatus()==Finansiranje.B)
				return "B";
			else
				return "S";
		case 5:
			return student.getProsecnaOcena();
		default:
			return null;
		}
	}
	
	public boolean checkUniqueBrIndeksa(String brIndeksa)
	{
		for(Student s : studenti)
		{
			if(s.getBrojIndeksa()==brIndeksa)
				return false;
		}
		return true;
	}
	
	public void addStudent(String ime,String prezime,Date datRodj,String adresa,String brojTel,String emailAdr,String brIndeksa,int godUpisa,int trenGodStud,Finansiranje nacin) {
		this.studenti.add(new Student(ime,prezime,datRodj,adresa,brojTel,emailAdr,brIndeksa,godUpisa,trenGodStud,nacin));
		refresh = studenti;
	}



	public void editStudent(String ime,String prezime,Date datRodj,String adresa,String brojTel,String emailAdr,String brIndeksa,int godUpisa,int trenGodStud,Finansiranje nacin,String stariBrInd) {
		for (Student s : studenti) {
			if (0==s.getBrojIndeksa().compareTo(stariBrInd)) {
				s.setPrezime(prezime);
				s.setIme(ime);
				s.setDatum(datRodj);
				s.setAdresaStanovanja(adresa);
				s.setKontaktTelefon(brojTel);
				s.setEmailAdresa(emailAdr);
				s.setGodinaUpisa(godUpisa);
				s.setTrenutnaGodinaStudija(trenGodStud);
				s.setStatus(nacin);
				s.setBrojIndeksa(brIndeksa);
				
				
				for(Ocena o : s.getPolozeniIspiti()){
					o.setStudent(s);
					
			   	for(Predmet p : BazaPredmeta.getInstance().getPredmeti()){
						if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
							for(Student s1: p.getPolozili()){
								if (0==s1.getBrojIndeksa().compareTo(stariBrInd)){
									s1=s;
									o.setPredmet(p);
									break;
								}
							}
							break;
						}
					}
				 }
				for(Predmet p: s.getNepolozeniIspiti()){
					for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()){
						if(p.getSpr().compareTo(p1.getSpr())==0){
					for(Student s1: p1.getNisuPolozili()){
						if (0==s1.getBrojIndeksa().compareTo(stariBrInd)){
							s1=s;
							p = p1;
							break;
						}
					}
					break;
					}
						}
				 }
			}
		}
		for (Student s : refresh) {
			if (0==s.getBrojIndeksa().compareTo(stariBrInd)) {
				s.setPrezime(prezime);
				s.setIme(ime);
				s.setDatum(datRodj);
				s.setAdresaStanovanja(adresa);
				s.setKontaktTelefon(brojTel);
				s.setEmailAdresa(emailAdr);
				s.setGodinaUpisa(godUpisa);
				s.setTrenutnaGodinaStudija(trenGodStud);
				s.setStatus(nacin);
				s.setBrojIndeksa(brIndeksa);
				
				for(Ocena o : s.getPolozeniIspiti()){
					o.setStudent(s);
					
					for(Predmet p : BazaPredmeta.getInstance().getPredmeti()){
						if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
							for(Student s1: p.getPolozili()){
								if (0==s1.getBrojIndeksa().compareTo(stariBrInd)){
									s1=s;
									o.setPredmet(p);
									break;
								}
							}
							break;
						}
					}
				}
				for(Predmet p: s.getNepolozeniIspiti()){
					for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()){
						if(p.getSpr().compareTo(p1.getSpr())==0){
					for(Student s1: p1.getNisuPolozili()){
						if (0==s1.getBrojIndeksa().compareTo(stariBrInd)){
							s1=s;
							p = p1;
							break;
						}
					}
					break;
					}
						}
				}
				break;
			}
		}
	}
	
	public void removeStudent(String brInd) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa() == brInd) {
				
				for(Ocena o : s.getPolozeniIspiti()){
					
					for(Predmet p : BazaPredmeta.getInstance().getPredmeti()){
						if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
							for(Student s1: p.getPolozili()){
								if (0==s1.getBrojIndeksa().compareTo(brInd)){
									p.getPolozili().remove(s1);
									break;
								}
							}
							break;
						}
					}
				}
				
				for(Predmet p: s.getNepolozeniIspiti()){
					for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()){
						if(p.getSpr().compareTo(p1.getSpr())==0){
					for(Student s1: p1.getNisuPolozili()){
						if (0==s1.getBrojIndeksa().compareTo(brInd)){
							p1.getNisuPolozili().remove(s1);
							break;
						}
					}
					break;
					}
						}
				}
				studenti.remove(s);
				break;
			}
		}
		for (Student s : refresh) {
			if (s.getBrojIndeksa() == brInd) {
				refresh.remove(s);
				break;
			}
		}
	}
	
	public void osveziPrikaz(){
		studenti = refresh;
	}
	
	 public void saveStudentData() {
		    ObjectOutputStream out=null;
			try {
			    out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.txt")));
				
					out.writeObject(studenti);
				
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
	public void loadStudentData(){
		 ObjectInputStream in;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("studenti.txt")));
			studenti = (ArrayList<Student>)in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 public void azurirajStudenta(String brInd) {
			for (Student s : studenti) {
				if (0==s.getBrojIndeksa().compareTo(brInd)) {
					for(Ocena o : s.getPolozeniIspiti()){
						o.setStudent(s);
						
						for(Predmet p : BazaPredmeta.getInstance().getPredmeti()){
							if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
								for(Student s1: p.getPolozili()){
									if (0==s1.getBrojIndeksa().compareTo(brInd)){
										s1=s;
										o.setPredmet(p);
										break;
									}
								}
								break;
							}
						}
					}
					for(Predmet p: s.getNepolozeniIspiti()){
						for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()){
							if(p.getSpr().compareTo(p1.getSpr())==0){
						for(Student s1: p1.getNisuPolozili()){
							if (0==s1.getBrojIndeksa().compareTo(brInd)){
								s1=s;
								p = p1;
								break;
							}
						}
						break;
						}
							}
					}
				}
			}
			for (Student s : refresh) {
				if (0==s.getBrojIndeksa().compareTo(brInd)) {
					for(Ocena o : s.getPolozeniIspiti()){
						o.setStudent(s);
						
						for(Predmet p : BazaPredmeta.getInstance().getPredmeti()){
							if(o.getPredmet().getSpr().compareTo(p.getSpr())==0){
								for(Student s1: p.getPolozili()){
									if (0==s1.getBrojIndeksa().compareTo(brInd)){
										s1=s;
										o.setPredmet(p);
										break;
									}
								}
								break;
							}
						}
					}
					for(Predmet p: s.getNepolozeniIspiti()){
						for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()){
							if(p.getSpr().compareTo(p1.getSpr())==0){
						for(Student s1: p1.getNisuPolozili()){
							if (0==s1.getBrojIndeksa().compareTo(brInd)){
								s1=s;
								p = p1;
								break;
							}
						}
						break;
						}
							}
					}
					break;
				}
			}
		}
}

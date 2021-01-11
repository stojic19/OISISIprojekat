package model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		
		studenti.add(new Student("Magdalena", "Reljin",new SimpleDateFormat("dd.MM.yyyy").parse("07.08.1978."), "Bulevar Severne Armije 45", "021021021", "adresa", "RA82/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Nenad", "Jecković",new SimpleDateFormat("dd.MM.yyyy").parse("17.08.1979."), "Bulevar Severne Armije 45", "021021021", "adresa", "RA85/2018", 2018, 2 , Finansiranje.S));
		studenti.add(new Student("Anja", "Tanović",new SimpleDateFormat("dd.MM.yyyy").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "EE49/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Jovana", "Đorđević",new SimpleDateFormat("dd.MM.yyyy").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "II20/2018", 2018, 3 , Finansiranje.B));
		studenti.add(new Student("Zorana", "Popović",new SimpleDateFormat("dd.MM.yyyy").parse("27.10.1980."), "Bulevar Severne Armije 45", "021021021", "adresa", "AU27/2018", 2018, 3 , Finansiranje.S));
	
		studenti.get(0).getPolozeniIspiti().add(new Ocena(studenti.get(0), BazaPredmeta.getInstance().getRow(1), Ocena.VrednostOcene.DESET, new SimpleDateFormat("dd.MM.yyyy").parse("09.01.2021.")));
		studenti.get(0).getPolozeniIspiti().add(new Ocena(studenti.get(0), BazaPredmeta.getInstance().getRow(2), Ocena.VrednostOcene.OSAM, new SimpleDateFormat("dd.MM.yyyy").parse("09.10.2021.")));
		
		studenti.get(0).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(3).getSpr(),BazaPredmeta.getInstance().getRow(3).getNaziv(),
				BazaPredmeta.getInstance().getRow(3).getSemestar(),BazaPredmeta.getInstance().getRow(3).getGodina(),
				BazaPredmeta.getInstance().getRow(3).getEspb()));
		studenti.get(0).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		
		
		studenti.get(1).getPolozeniIspiti().add(new Ocena(studenti.get(1), BazaPredmeta.getInstance().getRow(1), Ocena.VrednostOcene.DESET, new SimpleDateFormat("dd.MM.yyyy").parse("09.01.2021.")));
		studenti.get(1).getPolozeniIspiti().add(new Ocena(studenti.get(1), BazaPredmeta.getInstance().getRow(2), Ocena.VrednostOcene.OSAM, new SimpleDateFormat("dd.MM.yyyy").parse("09.10.2021.")));
		
		studenti.get(1).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(3).getSpr(),BazaPredmeta.getInstance().getRow(3).getNaziv(),
				BazaPredmeta.getInstance().getRow(3).getSemestar(),BazaPredmeta.getInstance().getRow(3).getGodina(),
				BazaPredmeta.getInstance().getRow(3).getEspb()));
		studenti.get(1).getNepolozeniIspiti().add(new Predmet(BazaPredmeta.getInstance().getRow(4).getSpr(),BazaPredmeta.getInstance().getRow(4).getNaziv(),
				BazaPredmeta.getInstance().getRow(4).getSemestar(),BazaPredmeta.getInstance().getRow(4).getGodina(),
				BazaPredmeta.getInstance().getRow(4).getEspb()));
		
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

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 4:
			if(student.getStatus()==Finansiranje.B)
				return "B";
			else
				return "S";
		case 5:
			return Double.toString(student.getProsecnaOcena());
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
		this.refresh.add(new Student(ime,prezime,datRodj,adresa,brojTel,emailAdr,brIndeksa,godUpisa,trenGodStud,nacin));
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
			}
		}
	}
	
	public void removeStudent(String brInd) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa() == brInd) {
				studenti.remove(i);
				break;
			}
		}
		for (Student i : refresh) {
			if (i.getBrojIndeksa() == brInd) {
				refresh.remove(i);
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
				for(Student s:studenti) {
					out.writeObject(s);
				}
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
}

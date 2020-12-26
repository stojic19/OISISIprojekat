package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Finansiranje;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() throws ParseException {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}



	private List<Profesor> profesori =new ArrayList<>();
	private List<String> kolone = new ArrayList<>();

	private BazaProfesora() throws ParseException {
	
	
		initProfesore();

		this.kolone.add("Prezime");
		this.kolone.add("Ime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		

	}

	private void initProfesore() throws ParseException {
		
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
	}
}


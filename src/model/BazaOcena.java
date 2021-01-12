package model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Ocena.VrednostOcene;

public class BazaOcena {

	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}

	private List<Ocena> ocene;
	private List<String> kolone;

	private BazaOcena() {
		
		initOcene();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}

	private void initOcene() {
		this.ocene = new ArrayList<Ocena>();
		
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Ocena ocena = this.ocene.get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getSpr();
		case 1:
			return ocena.getPredmet().getNaziv();
		case 2:
			 return Integer.toString(ocena.getPredmet().getEspb());
		case 3:
			if(ocena.getVrednostOcene()==VrednostOcene.SEST)
				 return Integer.toString(6);
			else if(ocena.getVrednostOcene()==VrednostOcene.SEDAM)
				 return Integer.toString(7);
			else if(ocena.getVrednostOcene()==VrednostOcene.OSAM)
				 return Integer.toString(8);
			else if(ocena.getVrednostOcene()==VrednostOcene.DEVET)
				 return Integer.toString(9);
			else 
				 return Integer.toString(10);
		case 4:
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");  
			return dateFormat.format(ocena.getDatumPolaganja()); 
		default:
			return null;
		}
	}
	
	public void addOcena(Student student,Predmet predmet,VrednostOcene ocena,Date datPol) {
		this.ocene.add(new Ocena(student,predmet,ocena,datPol));
	}

	public void removeOcena(String spr) {
		for (Ocena o : ocene) {
			if (o.getPredmet().getSpr().compareTo(spr) == 0) {
				ocene.remove(o);
				break;
			}
		}
	}

	public String getProsek() {
		double sum=0;
		for(Ocena o:ocene)
		{
			if(o.getVrednostOcene()==VrednostOcene.SEST)
				sum += 6;
			else if(o.getVrednostOcene()==VrednostOcene.SEDAM)
				sum += 7;
			else if(o.getVrednostOcene()==VrednostOcene.OSAM)
				sum += 8;
			else if(o.getVrednostOcene()==VrednostOcene.DEVET)
				sum += 9;
			else
				sum += 10;
		}
		double avg = sum / ocene.size();
		if(sum == 0)
		{
			return  Double.toString(0);
		}
		DecimalFormat df = new DecimalFormat("##.##");
		return df.format(avg);
	}

	public String getESPB() {
		int sum=0;
		for(Ocena o:ocene)
			sum+=o.getPredmet().getEspb();
		
		return Integer.toString(sum);
	}
}

package model;

import java.util.Date;

public class Ocena {

	public enum VrednostOcene
	{
		SEST, SEDAM, OSAM, DEVET, DESET;
	}
	
	private Student student;
	private Predmet predmet;
	private VrednostOcene vrednostOcene;
	private Date datumPolaganja;
	
	public Ocena(/*Student student,*/Predmet predmet,VrednostOcene ocena,Date datPol)
	{
		setStudent(student);
		setPredmet(predmet);
		setVrednostOcene(vrednostOcene);
		setDatumPolaganja(datPol);
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public VrednostOcene getVrednostOcene() {
		return vrednostOcene;
	}
	public void setVrednostOcene(VrednostOcene vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}
	public Date getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
}

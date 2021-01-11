package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Predmet implements Serializable {
       private String spr;
       private String naziv;
       private Semestar semestar;
       private int godina;
       private Profesor profesor;
       private int espb;
       private List<Student> polozili;
       private List<Student> nisuPolozili;
       
       public enum Semestar{
    		LETNJI(0),ZIMSKI(1);
    		int s;
    		private Semestar() {}
    		private Semestar(int i) {
    			this.s=i;
    		}
    		
    	    private String[] semestar= {"Letnji","Zimski"};
    		
    		public String toString(){
    			return semestar[this.ordinal()];
    		}
       }
	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Predmet(String spr, String naziv, Semestar semestar, int godina, int espb) {
		super();
		this.spr = spr;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = null;
		this.espb = espb;
		
		polozili= new ArrayList<Student>();
		nisuPolozili= new ArrayList<Student>();
	}


	public String getSpr() {
		return spr;
	}


	public void setSpr(String spr) {
		this.spr = spr;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public Semestar getSemestar() {
		return semestar;
	}


	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}


	public int getGodina() {
		return godina;
	}


	public void setGodina(int godina) {
		this.godina = godina;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public int getEspb() {
		return espb;
	}


	public void setEspb(int espb) {
		this.espb = espb;
	}


	public List<Student> getPolozili() {
		return polozili;
	}


	public void setPolozili(List<Student> polozili) {
		this.polozili = polozili;
	}


	public List<Student> getNisuPolozili() {
		return nisuPolozili;
	}


	public void setNisuPolozili(List<Student> nisuPolozili) {
		this.nisuPolozili = nisuPolozili;
	}


	@Override
	public String toString() {
		return "Predmet [spr=" + spr + ", naziv=" + naziv + ", semestar=" + semestar + ", godina=" + godina + ", espb="
				+ espb + "]";
	}

       
}

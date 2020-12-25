package model;

import java.util.Date;

enum Titula {
	BSC(0),MSC(1),MR(2),DR(3),PROFDR(4);
	int t;
	private Titula() {}
	private Titula(int i) {
		this.t=i;
	}
	private String[] titula= {"BSc","MSc","Mr","Dr","Prof. dr"};
	
	public String toString(){
		return titula[this.ordinal()];
	}
}

enum Zvanje {
	SARADNIKUNASTAVI(0),ASISTENT(1),ASISTENTSADOKTORATOM(2),DOCENT(3),VANREDNIPROFESOR(4),REDOVNIPROFESOR(5),PROFESOREMERITUS(6),DEKAN(7);
	int z;
	private Zvanje() {}
	private Zvanje(int i) {
		this.z=i;
	}
	private String[] zvanje= {"Saradnik u nastavi","Asistent","Asistent sa doktoratom","Docent","Vanredni profesor","Redovni profesor","Profesor emeritus","Dekan"};
	
	public String toString(){
		return zvanje[this.ordinal()];
	}
}

public class Profesor {
    private String prz;
	private String ime;
	private Date datrodj;
	private String adrs;
	private String ktel;
	private String email;
	private String adrk;
	private String brlk;
    private Titula titula;
    private Zvanje zvanje;
    
    
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profesor(String prz, String ime, Date datrodj, String adrs, String ktel, String email, String adrk,
			String brlk, Titula titula, Zvanje zvanje) {
		super();
		this.prz = prz;
		this.ime = ime;
		this.datrodj = datrodj;
		this.adrs = adrs;
		this.ktel = ktel;
		this.email = email;
		this.adrk = adrk;
		this.brlk = brlk;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	public String getPrz() {
		return prz;
	}
	public void setPrz(String prz) {
		this.prz = prz;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getDatrodj() {
		return datrodj;
	}
	public void setDatrodj(Date datrodj) {
		this.datrodj = datrodj;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getKtel() {
		return ktel;
	}
	public void setKtel(String ktel) {
		this.ktel = ktel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdrk() {
		return adrk;
	}
	public void setAdrk(String adrk) {
		this.adrk = adrk;
	}
	public String getBrlk() {
		return brlk;
	}
	public void setBrlk(String brlk) {
		this.brlk = brlk;
	}
	public Titula getTitula() {
		return titula;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	@Override
	public String toString() {
		return "Profesor [prz=" + prz + ", ime=" + ime + ", titula=" + titula + ", zvanje=" + zvanje + "]";
	}
	
    
    
}

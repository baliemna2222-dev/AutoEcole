package entities;

import java.time.LocalDate;

public class Seance {
	
	public Seance(String type ,int num, LocalDate date,String heure , Candidat c,Moniteur m) {
		super();
		this.type=type;
		this.num = num;
		this.date = date;
		this.prix = 0;
		this.c = c;
		this.m=m;
		this.heure=heure;
		//this.m = m;
		//this.v=v;
		
	}
	
	
	  public Seance() {
	    }
	protected int num ;
	protected LocalDate date ;
	protected int prix ;
	protected Candidat c ;
	protected String type ;
	private Moniteur m ;
	private String heure ;
	//private Vehicule v ;
	
	
	public int getNum() {
		return num;
	}
	public Moniteur getM() {
		return m;
	}


	public void setM(Moniteur m) {
		this.m = m;
	}


	public String getHeure() {
		return heure;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Candidat getC() {
		return c;
	}
	public void setC(Candidat c) {
		this.c = c;
	}
	public Moniteur getMoniteur() {
		return m;
	}
	public void setMoniteur(Moniteur m) {
		this.m = m;
	}
	
	
}

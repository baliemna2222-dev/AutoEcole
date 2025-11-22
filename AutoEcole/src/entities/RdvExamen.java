package entities;

import java.time.LocalDate;

public class RdvExamen {
	public RdvExamen(int num, LocalDate date, Candidat c,String type ,String heure) {
		super();
		this.num = num;
		this.date = date;
		this.prix = 0;
		
		this.c = c;
	}
	private int num ; 
	private String type ;
	private LocalDate date ;
	private String heure ;
	private int prix ; 
	private Candidat c ;
	public int getNum() {
		return num;
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
	
	public Candidat getC() {
		return c;
	}
	public void setC(Candidat c) {
		this.c = c;
	} 
	
	
	
	
	
}

package entities;

import java.time.LocalDateTime;

public class RdvExamen {
	public RdvExamen(int num, LocalDateTime date, Candidat c) {
		super();
		this.num = num;
		this.date = date;
		this.prix = 0;
		this.c = c;
	}
	private int num ; 
	private LocalDateTime date ;
	private int prix ; 
	private Candidat c ;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Candidat getC() {
		return c;
	}
	public void setC(Candidat c) {
		this.c = c;
	} 
	
	
	
	
	
}

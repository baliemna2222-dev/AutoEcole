package entities;

import java.time.LocalDateTime;

public class Seance {
	public Seance(int num, LocalDateTime date, Candidat c) {
		super();
		this.num = num;
		this.date = date;
		this.prix = 0;
		this.c = c;
		//this.m = m;
	}
	protected int num ;
	protected LocalDateTime date ;
	protected int prix ;
	protected Candidat c ;
	//private Moniteur m ;
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
	/*public Moniteur getM() {
		return m;
	}
	public void setM(Moniteur m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "Seance [num=" + num + ", date=" + date + ", prix=" + prix + ", Candidat=" + c + "Moniteur "+ m+"]";
	}
	
*/	
	
}

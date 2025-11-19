package entities;

import java.time.LocalDateTime;

public class Seance {
	public Seance(String type ,int num, LocalDateTime date, Candidat c) {
		super();
		this.type=type;
		this.num = num;
		this.date = date;
		this.prix = 0;
		this.c = c;
		//this.m = m;
		//this.v=v;
		
	}
	  public Seance() {
	    }
	protected int num ;
	protected LocalDateTime date ;
	protected int prix ;
	protected Candidat c ;
	protected String type ;
	//private Moniteur m ;
	//private Vehicule v ;
	
	
	public int getNum() {
		return num;
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

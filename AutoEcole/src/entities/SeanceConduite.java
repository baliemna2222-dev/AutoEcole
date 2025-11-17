package entities;

import java.time.LocalDateTime;

public class SeanceConduite extends Seance{

	//private Vehicule v ; 
	public SeanceConduite(int num, LocalDateTime date, int prix, Candidat c) {
		super(num, date, prix, c);
		//this.v=v ;
		}
	/*@Override
	public String toString() {
		return "SeanceConduite [num=" + num + ", date=" + date + ", prix=" + prix + ", Condidat=" + c + "Moniteur= "+m +"Vehicule="+v ]";
	}
	*/
}

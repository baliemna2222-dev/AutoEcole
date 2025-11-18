package entities;

import java.time.LocalDateTime;

public class SeanceConduite extends Seance{

	//private Vehicule v ; 
	public SeanceConduite(int num, LocalDateTime date,Candidat c) {
		super(num, date, c);
		//this.v=v ;
		switch (c.getCategoriepermis().toUpperCase()) {
	    case "A1": this.prix = 300; break;
	    case "A": this.prix = 350; break;
	    case "B": this.prix = 400; break;
	    case "B+E": this.prix = 450; break;
	    case "C": this.prix = 500; break;
	    case "C+E": this.prix = 550; break;
	    case "D": this.prix = 600; break;
	    case "D+E": this.prix = 650; break;
	    case "H": this.prix = 400; break;
	    case "D1": this.prix = 350; break;
	    default: this.prix = 0; break;
	}

		
		}
	
	
	
}

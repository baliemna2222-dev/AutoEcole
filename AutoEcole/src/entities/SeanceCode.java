package entities;

import java.time.LocalDateTime;

public class SeanceCode  extends Seance {

	public SeanceCode(int num, LocalDateTime date, Candidat c) {
		super(num, date, c);
		switch (c.getCategoriepermis().toUpperCase()) {
        case "A1": this.prix=200; break ;
        case "A": this.prix= 250;break ;
        case "B": this.prix=300;break ;
        case "B+E": this.prix= 350;break ;
        case "C": this.prix= 400;break ;
        case "C+E": this.prix= 450;break ;
        case "D": this.prix= 500;break ;
        case "D+E": this.prix= 550;break ;
        case "H": this.prix= 350;break ;
        case "D1": this.prix= 300;break ;
        default: this.prix= 0; break ;
    }
	}
	

}

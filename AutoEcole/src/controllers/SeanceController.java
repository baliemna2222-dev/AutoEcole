package controllers;

import java.time.LocalDateTime;
import java.util.List;

import entities.Seance;
import entities.SeanceCode;
import services.SeanceService;
import ui.SeanceUi;

public class SeanceController {
	private SeanceService service;
	
    public void creerSeance() {
    	SeanceUi s=new SeanceUi();
    	service.ajouterSeance(s.saisirSeance());
    }

    public List<Seance> listerToutes() {
        return service.listerToutes();
    }

    public Seance rechercherParNumero() {
    	int num= SeanceUi.saisirCIN();
        return service.rechercherParNumero(num);
    }

   
    public boolean supprimer() {
    	int num= SeanceUi.saisirCIN();
        return service.supprimer(num);
    }

    public boolean modifierDate( ) {
    	int num= SeanceUi.saisirCIN();
    	LocalDateTime d= SeanceUi.saisirNouvelleDate();
        return service.modifierDate(num, d);
    }
}

package services;

import java.time.LocalDateTime;
import java.util.List;

import entities.Candidat;
import entities.Seance;
import entities.SeanceCode;
import repositories.SeanceRep;

public class SeanceService {
	
	    private SeanceRep repo;
	   
	    public void ajouterSeance(SeanceCode seance) {
	        if (seance != null) {
	            repo.ajouter(seance);
	        }
	    }

	   
	    public List<Seance> listerToutes() {
	        return repo.listerToutes();
	    }

	    public Seance rechercherParNumero(int num) {
	        return repo.rechercherParNumero(num);
	    }

	    public boolean supprimer(int num) {
	        Seance s = repo.rechercherParNumero(num);
	        if (s != null) {
	            Candidat c = s.getC();
	            c.setNbreseancecode(c.getNbreseancecode() - 1);
	            c.setPrixtotale(c.getPrixtotale()-s.getPrix());
	            return repo.supprimer(num);
	        }
	        return false;
	    }

	    
	    public boolean modifierDate(int num, LocalDateTime nouvelleDate) {
	        return repo.modifierDate(num, nouvelleDate);
	    }
	}


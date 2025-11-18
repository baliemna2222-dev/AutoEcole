package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Seance;
import entities.SeanceCode;

public class SeanceRep {
	private List<Seance> seances = new ArrayList<>();

    // ajouter une saeance
    public void ajouter(SeanceCode seance) {
        seances.add(seance);
    }

    // afficher tous
    public List<Seance> listerToutes() {
        return seances;
    }

    // Rechercher une seance
    public Seance rechercherParNumero(int num) {
        for (Seance s : seances) {
            if (s.getNum() == num) {
                return s;
            }
        }
        return null;
    }

    // Supprimer une séance 
    public boolean supprimer(int num) {
        Seance s = rechercherParNumero(num);
        if (s != null) {
            seances.remove(s);
            return true;
        }
        return false;
    }

    // Modifier la date d'une séance
    public boolean modifierDate(int num, java.time.LocalDateTime nouvelleDate) {
        Seance s = rechercherParNumero(num);
        if (s != null) {
            s.setDate(nouvelleDate);
            return true;
        }
        return false;
    }
}


package services;

import java.time.LocalDateTime;

import entities.Candidat;
import entities.Seance;
import repositories.CandidatRepository;
import repositories.SeanceRep;

public class SeanceService {

    private SeanceRep repo = new SeanceRep();
    private CandidatRepository crep= new CandidatRepository();

    // Ajouter une séance
    public void ajouterSeance(Seance s) throws Exception {
        if (repo.getByNum(s.getNum()) != null) {
            throw new Exception("Erreur : Numéro de séance déjà existant !");
        }
        if (repo.getByNum(s.getNum()).getType()=="Code") {
        Candidat c =crep.getByCin(s.getC().getCIN());
        c.setNbreseancecode(c.getNbreseancecode()+1);
        
        }else {
        	Candidat c =crep.getByCin(s.getC().getCIN());
            c.setNbreseanceconduit(c.getNbreseanceconduit()+1);
        }
        repo.add(s);
    }

    // Afficher une séance
    public void afficher(Seance s) {
        repo.display(s);
    }

    // Rechercher une séance par numéro
    public Seance rechercher(int num) throws Exception {
        Seance s = repo.getByNum(num);
        if (s == null) throw new Exception("Séance introuvable !");
        return s;
    }

    // Supprimer une séance
    public boolean supprimer(int num) throws Exception {
        boolean ok = repo.deleteByNum(num);
        if (!ok) throw new Exception("Suppression échouée : Séance introuvable !");
        return true;
    }

    // Modifier une séance entière
    public boolean modifierSeance(Seance s) throws Exception {
        boolean ok = repo.update(s);
        if (!ok) throw new Exception("Modification échouée : Séance introuvable !");
        return true;
    }

    // Afficher toutes les séances
    public void afficherTous() {
        repo.displayAll();
    }

    // Modifier des champs spécifiques : type, prix, date, candidat
    public boolean modifierSeanceChamp(int num, String champ, Object nouvelleValeur) throws Exception {
        Seance s = repo.getByNum(num);
        if (s == null) throw new Exception("Séance introuvable !");

        switch (champ.toLowerCase()) {
            case "type":
                s.setType((String) nouvelleValeur);
                break;
            case "prix":
                s.setPrix((Integer) nouvelleValeur);
                break;
            case "date":
                s.setDate((LocalDateTime) nouvelleValeur);
                break;
            case "candidat":
                s.setC((Candidat) nouvelleValeur);
                break;
            default:
                throw new Exception("Champ invalide !");
        }

        return repo.update(s);
    }
}

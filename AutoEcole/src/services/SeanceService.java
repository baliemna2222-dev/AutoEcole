package services;

import java.time.LocalDate;

import entities.Candidat;
import entities.Moniteur;
import entities.Seance;
import repositories.CandidatRepository;
import repositories.MoniteurRep;
import repositories.SeanceRep;

public class SeanceService {

    private SeanceRep repo = new SeanceRep();
    private CandidatRepository crep = new CandidatRepository();
    private MoniteurRep mrep = new MoniteurRep();
    public void ajouterSeance(Seance s) throws Exception {
        if (repo.getByNum(s.getNum()) != null) {
            throw new Exception("Erreur : Numéro de séance déjà existant !");
        }
        Candidat c = crep.getByCin(s.getC().getCIN());
        Moniteur m = mrep.find(s.getMoniteur().getCIN());
        if (s.getType().equalsIgnoreCase("Code")) {
            c.setNbreseancecode(c.getNbreseancecode() + 1);
            m.setHeuresTravaillecode(m.getHeuresTravaillecode()+1);
        } else { 
            c.setNbreseanceconduit(c.getNbreseanceconduit() + 1);
            m.setHeuresTravailleconduite(m.getHeuresTravailleconduite()+1);
        }

        repo.add(s);
    }
    public void afficher(Seance s) {
        repo.display(s);
    }
    public Seance rechercher(int num) throws Exception {
        Seance s = repo.getByNum(num);
        if (s == null) throw new Exception("Séance introuvable !");
        return s;
    }
    public boolean supprimer(int num) throws Exception {
        boolean ok = repo.deleteByNum(num);
        if (!ok) throw new Exception("Suppression échouée : Séance introuvable !");
        return true;
    }
    public boolean modifierSeance(Seance s) throws Exception {
        boolean ok = repo.update(s);
        if (!ok) throw new Exception("Modification échouée : Séance introuvable !");
        return true;
    }
    public void afficherTous() {
        repo.displayAll();
    }

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
                s.setDate((LocalDate) nouvelleValeur); 
                break;
            case "heure":
                s.setHeure((String) nouvelleValeur); 
                break;
            case "candidat":
                s.setC((Candidat) nouvelleValeur);
                break;
            case "moniteur":
                s.setMoniteur((Moniteur) nouvelleValeur);
                break; 
            default:
                throw new Exception("Champ invalide !");
        }

        return repo.update(s);
    }
}

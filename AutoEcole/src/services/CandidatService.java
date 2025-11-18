package services;

import entities.Candidat;
import repositories.CandidatRepository;

public class CandidatService {
	private CandidatRepository repo = new CandidatRepository();
	
	
	public void ajouterCandidat(Candidat c) throws Exception {
        if (repo.getByCin(c.getCIN()) != null) {
            throw new Exception("Erreur : CIN deja existant !");
        }
        repo.add(c);
    }
	
	
	public void afficher(Candidat c) {
        repo.display(c);
        }
   
	
	public Candidat rechercher(int cin) throws Exception {
        Candidat c = repo.getByCin(cin);
        if (c == null)
            throw new Exception("Candidat introuvable !");
        
        return c;
    }
	
	
	public boolean supprimer(int cin) throws Exception {
        boolean ok = repo.deleteByCin(cin);
        if (!ok)
            throw new Exception("Suppression échouée : CIN introuvable !");
        return true;
    }
	
	public boolean modifierCandidat(Candidat c) throws Exception {
        boolean ok = repo.update(c);
        if (!ok)
            throw new Exception("Modification échouée : CIN introuvable !");
        return true;
    }
	
	
	public void afficherTous() {
        repo.getAll();
        }
	

	
	//calcul prixtotale
	public void CalculerPrix(Candidat c,int prix) {
		c.setPrixtotale(c.getPrixtotale()+prix);
	}
	//calcul payement 
	public void payer(int cin, int montant) throws Exception {
        Candidat c = repo.getByCin(cin);
        if (c == null) {
            throw new Exception("Candidat introuvable !");
        }
        
        if (montant <= 0) {
            throw new Exception("le montant est invalide !");
        }
        c.setPrixpaye(montant);
        c.setReste(c.getPrixtotale()-montant);
        
    }
	
}












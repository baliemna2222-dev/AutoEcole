package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	public boolean modifierCandidatChamp(int cin, String champ, String nouvelleValeur) throws Exception {
	    Candidat c = repo.getByCin(cin);
	    if (c == null) throw new Exception("Candidat introuvable !");

	    switch(champ.toLowerCase()) {
	        case "nom":
	            if (nouvelleValeur.length() < 2 || !nouvelleValeur.matches("[a-zA-Z]+"))
	                throw new Exception("Nom invalide !");
	            c.setNom(nouvelleValeur);
	            break;
	        case "prenom":
	            if (nouvelleValeur.length() < 2 || !nouvelleValeur.matches("[a-zA-Z]+"))
	                throw new Exception("Prenom invalide !");
	            c.setPrenom(nouvelleValeur);
	            break;
	        case "datenaissance":
	            try {
	                c.setDatedenaissance(LocalDate.parse(nouvelleValeur, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            } catch (Exception e) {
	                throw new Exception("Date invalide !");
	            }
	            break;
	        case "telephone":
	            try {
	                int tel = Integer.parseInt(nouvelleValeur);
	                c.setTelephone(tel);
	            } catch (NumberFormatException e) {
	                throw new Exception("Téléphone invalide !");
	            }
	            break;
	        case "adresse": c.setAdresse(nouvelleValeur); break;
	        case "ville": c.setVille(nouvelleValeur); break;
	        case "email":
	            if (!nouvelleValeur.contains("@") || !nouvelleValeur.contains("."))
	                throw new Exception("Email invalide !");
	            c.setEmail(nouvelleValeur);
	            break;
	        case "categoriepermis": c.setCategoriepermis(nouvelleValeur); break;
	        case "examencodereussi": c.setExamencodereussi(Boolean.parseBoolean(nouvelleValeur)); break;
	        case "examenconduitreussi": c.setExamenconduitreussi(Boolean.parseBoolean(nouvelleValeur)); break;
	        default: throw new Exception("Champ invalide !");
	    }

	    return repo.update(c);
	}


	
	//calcul prixtotale
	public void CalculerPrix(Candidat c,int prix) {
		c.setPrixtotale(c.getPrixtotale()+prix);
		c.setReste(c.getPrixtotale()+prix);
		repo.update(c);
	}
	//calcul payement 
	public void payer(int cin, int montant) throws Exception {
        Candidat c = repo.getByCin(cin);
        if (c == null) {
            throw new Exception("Candidat introuvable !");
        }
        
        if (montant < 0 || montant>c.getReste()) {
            throw new Exception("le montant est invalide !");
        }
        c.setPrixpaye(c.getPrixpaye()+montant);
        c.setReste(c.getPrixtotale()-c.getPrixpaye());
        repo.update(c);
    }
	
}












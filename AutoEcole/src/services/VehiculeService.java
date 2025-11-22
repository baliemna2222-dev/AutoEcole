package services;

import java.time.LocalDate;
import java.util.List;

import entities.Reparation;
import entities.Vehicule;
import repositories.VehiculeRep;
import ui.TypeVehicule;

public class VehiculeService {
	private VehiculeRep repository= new VehiculeRep();
    
    public void ajouterVehicule(Vehicule v) {
        float kmRestant = 100000 - v.getKilometrageTotale();
        if (kmRestant < 0) kmRestant = 0;
        v.setNbkmrestant((int) kmRestant);

        repository.ajouter(v);
    }
    public boolean modifierChamp(int immatricule, String champ, String nouvelleValeur) {
        Vehicule v = repository.rechercher(immatricule);
        if (v == null) {
            System.out.println(" Véhicule non trouvé !");
            return false;
        }

        switch(champ.toLowerCase()) {
            case "type":
            	TypeVehicule type = TypeVehicule.valueOf(nouvelleValeur.toUpperCase());
                v.setType(type);
                break;
            case "prix":
                try {
                    int prix = Integer.valueOf(nouvelleValeur);
                    v.setPrix(prix);
                } catch(Exception e) {
                    System.out.println(" Valeur de prix invalide !");
                    return false;
                }
                break;
            case "kilometragetotale":
                try {
                    float km = Float.valueOf(nouvelleValeur);
                    v.setKilometrageTotale(km);
                    float kmRestant = 100000 - km;
                    if(kmRestant < 0) kmRestant = 0;
                    v.setNbkmrestant((int) kmRestant);
                } catch(Exception e) {
                    System.out.println(" Valeur de km invalide !");
                    return false;
                }
                break;
            case "datemiseenservice":
                try {
                    LocalDate date = LocalDate.parse(nouvelleValeur);
                    v.setDatemiseenservice(date);
                } catch(Exception e) {
                    System.out.println(" Date invalide !");
                    return false;
                }
                break;
            default:
                System.out.println(" Champ inconnu !");
                return false;
        }

        System.out.println(" Véhicule modifié !");
        return true;
    }
    public void supprimerVehicule(int immatricule) {
         repository.supprimer(immatricule);
    }
    public Vehicule rechercherVehicule(int immatricule) {
    	repository.displayVehicule(repository.rechercher(immatricule));
        return repository.rechercher(immatricule);
    }
    public List<Vehicule> getAllVehicules() {
    	return repository.getAll();
    }
    public void afficherTousVehicules() {
        repository.afficherTous();
    }
    public void afficherVehicule(Vehicule v) {
        if (v != null) {
            repository.displayVehicule(v);
        } else {
            System.out.println("❌ Véhicule introuvable !");
        }
    }
    
    public void afficheralerte () {
    	repository.getAlertes();
    }
    public void afficherreparation() {
    	repository.afficherrepartions();
    }
    public void ajouterrepartions(int matricule,Reparation r) {
    	repository.ajouterReparation(matricule, r);
    }
}



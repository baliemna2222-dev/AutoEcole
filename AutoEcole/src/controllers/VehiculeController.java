package controllers;

import java.util.List;

import entities.Vehicule;
import services.VehiculeService;
import ui.VehiculeUi;

public class VehiculeController {
	private VehiculeService service = new VehiculeService();
	private VehiculeUi vui = new VehiculeUi();
	public void ajouterVehicule() {
		Vehicule v = vui.saisirVehicule();
        service.ajouterVehicule(v);
    }  

    public boolean modifierVehiculeChamp() {
        int immatricule = vui.lireInt("Immatricule :");
        String champ = vui.lireString("Champ :");
        String valeur = vui.lireString("modification :");
    	return service.modifierChamp(immatricule, champ, valeur);
    }

    public void supprimerVehicule() {
    	int immatricule = vui.lireInt("Immatricule :");
         service.supprimerVehicule(immatricule);
    }

    public void rechercherVehicule() {
    	int immatricule = vui.lireInt("Immatricule :");
         Vehicule v =service.rechercherVehicule(immatricule);
         service.afficherVehicule(v);
    }
    public void afficherTousVehicules() {
        service.afficherTousVehicules();
    }

}

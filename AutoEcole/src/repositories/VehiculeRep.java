package repositories;
import entities.Vehicule;
import ui.TypeVehicule;

import java.util.ArrayList;
import java.util.List;
public class VehiculeRep {
	private List<Vehicule> motos = new ArrayList<>();
    private List<Vehicule> voitures = new ArrayList<>();
    private List<Vehicule> camions = new ArrayList<>();
    private List<Vehicule> autobus = new ArrayList<>();
    List<Vehicule> all = new ArrayList<>();
	    public boolean ajouter(Vehicule v) {
	    	for (Vehicule e : all) {
	            if (e.getImmatricule() ==v.getImmatricule()) {
	               System.out.println("Immatricule existe deja !");
	               return false ;
	            }}
	    	switch(v.getType()) {
            case MOTO: motos.add(v); break;
            case VOITURE: voitures.add(v); break;
            case CAMION: camions.add(v); break;
            case AUTOBUS: autobus.add(v); break;
        }
	    System.out.println("Véhicule ajouté dans  " + v.getType());
	    return true ;
	    }
	    
	    public Vehicule rechercher(int immatricule) {
	        for (Vehicule v : motos) {
	            if (v.getImmatricule() == immatricule) return v;
	        }
	        for (Vehicule v : voitures) {
	            if (v.getImmatricule() == immatricule) return v;
	        }
	        for (Vehicule v : camions) {
	            if (v.getImmatricule() == immatricule) return v;
	        }
	        for (Vehicule v : autobus) {
	            if (v.getImmatricule() == immatricule) return v;
	        }

	        return null; // si non trouvé
	    }
	    public boolean modifier(Vehicule v, Vehicule nouveau) {
	    	int immatricule = v.getImmatricule();
	    	List<Vehicule> liste;
	        switch (v.getType()) {
	            case MOTO: liste = motos; break;
	            case VOITURE: liste = voitures; break;
	            case CAMION: liste = camions; break;
	            default : liste = autobus; break;
	            }

	    	for (int i = 0; i < liste.size(); i++) {
	            if (liste.get(i).getImmatricule() == immatricule) {
	                liste.set(i, nouveau);
	                System.out.println("Véhicule modifié !");
	                return true;
	            }
	        }
	        System.out.println(" Véhicule non trouvé !");
	        return false;
	    }
	    public void supprimer(int immatricule) {
	    	Vehicule v = rechercher(immatricule);
	    	List<Vehicule> liste;
	        switch (v.getType()) {
	            case MOTO: liste = motos; break;
	            case VOITURE: liste = voitures; break;
	            case CAMION: liste = camions; break;
	            default : liste = autobus; break;
	            }
	        boolean test =false ;
	        for (int i = 0; i < liste.size(); i++) {
	        	
	            if (liste.get(i).getImmatricule() == immatricule) {
	                liste.remove(i);
	                System.out.println(" Véhicule supprimé !");
	                test= true;
	            }
	        }
	        if (!test)
	        System.out.println(" Véhicule non trouvé !");
	    }
	    public List<Vehicule> getAll() {
	    	all.clear();
	        all.addAll(motos);
	        all.addAll(voitures);
	        all.addAll(camions);
	        all.addAll(autobus);
	        return all ;}
	   
	    public void getListe(List<Vehicule> l) {
	    	for (Vehicule v : l) {
	            displayVehicule(v);
	        }
	    }
	    
	    
	    public void afficherTous() {
	    	System.out.println("===== LISTE DES VEHICULES =====");
	        for (Vehicule v : motos) {
	            displayVehicule(v);
	        }
	        System.out.println("================================");
	        for (Vehicule v : voitures) {
	            displayVehicule(v);
	        }
	        System.out.println("================================");
	        for (Vehicule v : camions) {
	            displayVehicule(v);
	        }
	        System.out.println("================================");
	        for (Vehicule v : motos) {
	            displayVehicule(v);
	        }
	        System.out.println("================================");
	    }
	    public void displayVehicule(Vehicule v) {
	    	if (v!=null)
	        System.out.println("----------------------------------------");
	        System.out.println("| Immatricule : " + v.getImmatricule());
	        System.out.println("| Type        : " + v.getType());
	        System.out.println("| Date mise en service : " + v.getDatemiseenservice());
	        System.out.println("| Prix        : " + v.getPrix() + " TND");
	        System.out.println("| Kilométrage total     : " + v.getKilometrageTotale() + " km");
	        System.out.println("| Km avant prochaine visite : " + v.getNbkmrestant() + " km");
	        System.out.println("----------------------------------------");
	    }
	    
	}


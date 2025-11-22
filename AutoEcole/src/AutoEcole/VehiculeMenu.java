package AutoEcole;

import entities.Reparation;
import entities.Vehicule;
import repositories.VehiculeRep;

import java.time.LocalDate;
import java.util.Scanner;

import controllers.VehiculeController;

public class VehiculeMenu {
	
		public static void main(String[] args) {
			
		
	    VehiculeController c = new VehiculeController();
	     Scanner sc = new Scanner(System.in);

	        int choix;
	        do {
	            System.out.println("\n===== MENU GESTION VEHICULES =====");
	            System.out.println("1. Ajouter un véhicule");
	            System.out.println("2. Modifier un véhicule");
	            System.out.println("3. Supprimer un véhicule");
	            System.out.println("4. Afficher tous les véhicules");
	            System.out.println("5. Ajouter une réparation");
	            System.out.println("6. Afficher les réparations");
	            System.out.println("7. Afficher les alertes");
	            System.out.println("0. Quitter");
	            System.out.print("Votre choix : ");
	            choix = sc.nextInt();
	            sc.nextLine(); 

	            switch (choix) {
	                case 1:
	                    c.ajouterVehicule();;
	                    break;
	                case 2:
	                    c.modifierVehiculeChamp();
	                    break;
	                case 3:
	                   c.supprimerVehicule();;
	                    break;
	                case 4:
	                    c.afficherTousVehicules();;
	                    break;
	                case 5:
	                   c.ajouterrepation();;
	                    break;
	                case 6:
	                   c.afficherReparations();;
	                    break;
	                case 7:
	                    c.afficherAlertes();;
	                    break;
	                case 0:
	                    System.out.println("Au revoir !");
	                    break;
	                default:
	                    System.out.println("Choix invalide !");
	            }

	        } while (choix != 0);
	    }


}

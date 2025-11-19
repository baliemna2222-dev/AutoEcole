package AutoEcole;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import controllers.CandidatController;


public class Application {
	
	public static void main(String[] args) {
		/*
	        try (FileWriter writer = new FileWriter("candidats.json")) {
	            writer.write("[]");
	            writer.flush();
	            System.out.println("Fichier JSON vidé !");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/
	        Scanner sc = new Scanner(System.in);
	        CandidatController controller = new CandidatController();
	        int choix = 0;

	        do {
	            System.out.println("========== MENU CANDIDATS ==========");
	            System.out.println("1. Ajouter un candidat");
	            System.out.println("2. Modifier un candidat");
	            System.out.println("3. Supprimer un candidat");
	            System.out.println("4. Rechercher un candidat");
	            System.out.println("5. Afficher tous les candidats");
	            System.out.println("6. Effectuer un paiement");
	            System.out.println("7. Quitter");
	            System.out.print("Votre choix : ");

	            try {
	                choix = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Erreur : Veuillez saisir un nombre !");
	                continue;
	            }

	            switch (choix) {
	                case 1:
	                    controller.creerCandidat();
	                    break;
	                case 2:
	                    controller.modifierChamp();
	                    break;
	                case 3:
	                    controller.supprimer();
	                    break;
	                case 4:
	                    controller.rechercher();
	                    break;
	                case 5:
	                    controller.afficherTous();
	                    break;
	                case 6:
	                    controller.payer();
	                    break;
	                case 7:
	                    System.out.println("Au revoir !");
	                    break;
	                default:
	                    System.out.println("Choix invalide. Réessayez !");
	            }

	            System.out.println(); 

	        } while (choix != 7);

	        sc.close();
	    }
	}

package AutoEcole;

import java.util.Scanner;
import controllers.CandidatController;
import controllers.SeanceController;

public class MenuSeance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidatController candidatController = new CandidatController();
        SeanceController seanceController = new SeanceController(candidatController);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU SÉANCES =====");
            System.out.println("1. Ajouter une séance");
            
            System.out.println("2. Modifier une séance");
            System.out.println("3. Supprimer une séance");
            System.out.println("4. Rechercher une séance");
            System.out.println("5. Afficher toutes les séances");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");
            String choix = sc.nextLine();

            switch (choix) {
                case "1":
                    seanceController.creerSeance();
                    break;
                case "2":
                    seanceController.modifierSeance();
                    break;
                case "3":
                    seanceController.supprimer();
                    break;
                case "4":
                    seanceController.rechercher();
                    break;
                case "5":
                    seanceController.afficherTous();
                    break;
                case "6":
                   candidatController.findCandidat();
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}

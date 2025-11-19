package AutoEcole;

import java.util.Scanner;
import controller.MoniteurController;
import entities.Moniteur;

public class menumoniteur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MoniteurController controller = new MoniteurController();

        int choix;
        boolean exit = false;

        do {
            System.out.println("\n===== Gestion des Moniteurs =====");
            System.out.println("1. Ajouter un moniteur");
            System.out.println("2. Supprimer un moniteur");
            System.out.println("3. Modifier un moniteur");
            System.out.println("4. Rechercher un moniteur");
            System.out.println("5. Afficher tous les moniteurs");
            System.out.println("6. Calculer le salaire d'un moniteur");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = Integer.parseInt(sc.nextLine());

            switch (choix) {
                case 1:
                    controller.creerMoniteur();
                    break;
                case 2:
                    controller.supprimerMoniteur();
                    break;
                case 3:
                    controller.modifierMoniteur();
                    break;
                case 4:
                    controller.rechercherMoniteur();
                    break;
                case 5:
                    controller.afficherTous();
                    break;
                case 6:
                    controller.calculerSalaire();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }

        } while (!exit);

        sc.close();
    }
}

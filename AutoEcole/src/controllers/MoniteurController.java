package controllers;

import entities.Moniteur;
import services.MoniteurServices;
import ui.MoniteurUi;

public class MoniteurController {

    private MoniteurServices service = new MoniteurServices();
    private MoniteurUi ui = new MoniteurUi();

    // Ajouter un moniteur avec saisie console et vérification
    public void creerMoniteur() {
        boolean ok = false;
        do {
            try {
                Moniteur m = ui.saisie();
                service.ajouter(m);
                System.out.println("Moniteur ajouté !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Supprimer un moniteur par CIN
    public void supprimerMoniteur() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                if (service.supprimer(cin)) {
                    System.out.println("Moniteur supprimé !");
                } else {
                    System.out.println("Moniteur introuvable !");
                }
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Rechercher et afficher un moniteur
    public void rechercherMoniteur() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                Moniteur m = service.chercher(cin);
                if (m != null) {
                    service.liste(); // ou afficher un seul moniteur via display
                } else {
                    System.out.println("Moniteur introuvable !");
                }
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Afficher tous les moniteurs
    public void afficherTous() {
        service.liste();
    }

    // Modifier un moniteur champ par champ
    public void modifierMoniteur() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                Moniteur m = service.chercher(cin);
                if (m == null) {
                    System.out.println("Moniteur introuvable !");
                    return;
                }
                
                System.out.println("Modifier un champ : nom, prenom, gmail, telephone, disponible, heures, typeseance");
                String champ = ui.saisirChamp("champ");
                String valeur = ui.saisirChamp("nouvelle valeur");

                Object nouvelleValeur;

                switch (champ.toLowerCase()) {
                    case "nom":
                    case "prenom":
                    case "gmail":
                    case "typeseance":
                        nouvelleValeur = valeur;
                        break;
                    case "cin":
                        nouvelleValeur = Long.parseLong(valeur);
                        break;
                    case "telephone":
                        nouvelleValeur = Integer.parseInt(valeur);
                        break;
                    case "disponible":
                        nouvelleValeur = Boolean.parseBoolean(valeur);
                        break;
                    case "heures":
                        nouvelleValeur = Double.parseDouble(valeur);
                        break;
                    default:
                        System.out.println("Champ invalide !");
                        return;
                }

                if (service.updateChamp(cin, champ, nouvelleValeur)) {
                    System.out.println("Moniteur modifié !");
                } else {
                    System.out.println("Erreur lors de la modification !");
                }

                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Calculer le salaire d’un moniteur
    public void calculerSalaire() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                Moniteur m = service.chercher(cin);
                if (m != null) {
                    int salaire = service.calculSalaire(m, m.getTypeSeance());
                    System.out.println("Salaire du moniteur : " + salaire + " DT");
                } else {
                    System.out.println("Moniteur introuvable !");
                }
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }
}

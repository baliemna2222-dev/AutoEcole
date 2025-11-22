package controllers;

import entities.Candidat;
import entities.Moniteur;
import services.MoniteurServices;
import ui.CandidatUi;
import ui.MoniteurUi;

public class MoniteurController {

    private MoniteurServices service = new MoniteurServices();
    private MoniteurUi ui = new MoniteurUi();

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

    public void rechercherMoniteur() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                Moniteur m = service.chercher(cin);
                if (m != null) {
                    service.liste(); 
                } else {
                    System.out.println("Moniteur introuvable !");
                }
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }
    
    public Moniteur findMoniteur() {
        boolean ok = false;
        do {
            try {
                double cin = MoniteurUi.saisirCIN();
                Moniteur c = service.chercher(cin);
                ok = true;
                return c;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
        return null ;
    }

    public void afficherTous() {
        service.liste();
    }

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
 public void calculerSalaire() {
        boolean ok = false;
        do {
            try {
                long cin = ui.saisirCIN();
                Moniteur m = service.chercher(cin);
                if (m != null) {
                    int salaire = service.calculSalaire(m);
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

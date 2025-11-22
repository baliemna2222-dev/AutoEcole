package controllers;

import java.util.Scanner;

import entities.Candidat;
import services.CandidatService;
import ui.CandidatUi;

public class CandidatController {
    private CandidatService cs = new CandidatService();

    public void creerCandidat() {
        boolean ok = false;
        do {
            try {
                Candidat c = CandidatUi.saisirCandidat();
                cs.ajouterCandidat(c);
                System.out.println("Candidat ajouté !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }


    public void modifier() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                Candidat c = cs.rechercher(cin);
            
                cs.modifierCandidat(c);
                System.out.println("Candidat modifié !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    public void supprimer() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                cs.supprimer(cin);
                System.out.println("Candidat supprimé !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    public void rechercher() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                Candidat c = cs.rechercher(cin);
                cs.afficher(c);
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    public Candidat findCandidat() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                Candidat c = cs.rechercher(cin);
                ok = true;
                return c;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
        return null ;
    }

    public void afficherTous() {
        cs.afficherTous();
    }
    public void payer() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                int montant = CandidatUi.saisirMontant();
                cs.payer(cin, montant);
                System.out.println("Paiement effectué !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }
    
    public void modifierChamp() {
        boolean ok = false;
        do {
            try {
                int cin = CandidatUi.saisirCIN();
                Candidat c = cs.rechercher(cin); // vérifie si le candidat existe

                String champ = CandidatUi.saisirChamp();
                String nouvelleValeur = CandidatUi.saisirNouvelleValeur(champ);

                cs.modifierCandidatChamp(cin, champ, nouvelleValeur); // modifie seulement le champ choisi
                System.out.println("Champ modifié !");
                ok = true;

            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
                System.out.println("Veuillez réessayer !");
            }
        } while (!ok);
    }

    }



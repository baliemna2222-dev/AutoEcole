package controllers;

import java.util.Scanner;

import entities.Candidat;
import entities.Seance;
import services.CandidatService;
import services.SeanceService;
import ui.SeanceUi;

public class SeanceController {
    private SeanceService seanceService = new SeanceService();
    private CandidatService candidatService=new CandidatService () ;
    private SeanceUi seanceUi;
    private Scanner sc = new Scanner(System.in);

    public SeanceController(CandidatController candidatController) {
        this.seanceUi = new SeanceUi(candidatController);
    }

    // Créer une séance avec vérification et répétition si erreur
    public void creerSeance() {
        boolean ok = false;
        do {
            try {
                Seance s = seanceUi.saisirSeance();
                seanceService.ajouterSeance(s);
                Candidat c = seanceService.rechercher(s.getNum()).getC();
                candidatService.CalculerPrix(c, s.getPrix());
                System.out.println("Séance ajoutée !");
                ok = true;
                
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Supprimer une séance
    public void supprimer() {
        boolean ok = false;
        do {
            try {
                int num = seanceUi.saisirNum();
                seanceService.supprimer(num);
                System.out.println("Séance supprimée !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Rechercher et afficher une séance
    public void rechercher() {
        boolean ok = false;
        do {
            try {
                int num = seanceUi.saisirNum();
                Seance s = seanceService.rechercher(num);
                seanceService.afficher(s);
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }

    // Afficher toutes les séances
    public void afficherTous() {
        seanceService.afficherTous();
    }

    // Modifier une séance entière
    public void modifierSeance() {
        boolean ok = false;
        do {
            try {
                int num = seanceUi.saisirNum();
                Seance s = seanceService.rechercher(num);
                System.out.println("Modification de la séance : " + num);
                
                // Réutiliser saisirChamp pour modifier un champ
                String champ = seanceUi.saisirChamp();
                Object nouvelleValeur = seanceUi.saisirNouvelleValeur(champ);
                
                seanceService.modifierSeanceChamp(num, champ, nouvelleValeur);
                System.out.println("Séance modifiée !");
                ok = true;
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage() + " Veuillez réessayer.");
            }
        } while (!ok);
    }
}

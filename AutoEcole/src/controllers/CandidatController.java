package controllers;

import java.util.Scanner;

import entities.Candidat;
import services.CandidatService;
import ui.CandidatUi;

public class CandidatController {
	private CandidatService cs=new CandidatService() ;
	public void ajouter (Candidat c) {
		try {
            cs.ajouterCandidat(c);
            System.out.println("Candidat ajouté !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	public void modifier(Candidat c) {
        try {
            cs.modifierCandidat(c);
            System.out.println(" Candidat modifié !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	public void supprimer(int cin) {
        try {
            cs.supprimer(cin);
            System.out.println(" Candidat supprimé !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	 public void rechercher(int cin) {
	        try {
	            Candidat c = cs.rechercher(cin);
	            System.out.println(c);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 public void afficherTous() {
	        cs.afficherTous();
	    }

	    public void payer(int cin, int montant) {
	        try {
	            cs.payer(cin, montant);
	            System.out.println(" Paiement effectué !");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
}

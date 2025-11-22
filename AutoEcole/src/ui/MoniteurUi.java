package ui;

import java.util.Scanner;
import entities.Moniteur;
public class MoniteurUi{

	    public static Moniteur saisie() {
	        Scanner sc = new Scanner(System.in);

	        String nom;
	        String prenom;
	        String gmail;
	       
	        String cinStr;
	        String telStr;

	        long CIN;
	        int telephone;
	        boolean disponible;
	        

	        // -------- Nom --------
	        do {
	            System.out.print("Entrer le nom (min 2 lettres) : ");
	            nom = sc.nextLine().trim();
	        } while (nom.length() < 2);

	        // -------- Prénom --------
	        do {
	            System.out.print("Entrer le prénom (min 2 lettres) : ");
	            prenom = sc.nextLine().trim();
	        } while (prenom.length() < 2);

	        // -------- CIN --------
	        do {
	            System.out.print("Entrer le CIN (8 chiffres) : ");
	            cinStr = sc.nextLine().trim();
	        } while (cinStr.length() != 8 || !cinStr.matches("\\d+"));

	        CIN = Long.parseLong(cinStr);


	        do {
	            System.out.print("Entrer Gmail : ");
	            gmail = sc.nextLine().trim();
	        } while (!gmail.endsWith("@gmail.com"));

	        do {
	            System.out.print("Entrer un numéro téléphone (8 chiffres) : ");
	            telStr = sc.nextLine().trim();
	        } while (telStr.length() != 8 || !telStr.matches("\\d+"));

	        telephone = Integer.parseInt(telStr);

	        return new Moniteur(nom, prenom, CIN, gmail, telephone);
	    }
	    public static long saisirCIN() {
	    	Scanner sc = new Scanner(System.in);
	        String cinStr;
	        long CIN;
	        do {
	            System.out.print("Entrer le CIN (8 chiffres) : ");
	            cinStr = sc.nextLine().trim();
	        } while (cinStr.length() != 8 || !cinStr.matches("\\d+"));
	        CIN = Long.parseLong(cinStr);
	        return CIN;
	    }
	    public static String saisirChamp(String champ) {
	    	Scanner sc = new Scanner(System.in);
	        System.out.print("Entrer nouvelle valeur pour " + champ + " : ");
	        return sc.nextLine();
	    }

	}


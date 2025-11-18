package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Candidat;
import entities.SeanceCode;
import services.CandidatService;

public class SeanceUi {
	 private CandidatService s;
	 private Scanner sc = new Scanner(System.in);
	 private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	 
	 
	
	 public  SeanceCode saisirSeance() {
		try {
		 System.out.print("CIN du candidat : ");
         int cin = sc.nextInt();
         sc.nextLine(); 

         Candidat c = s.rechercher(cin);
         c.setNbreseancecode(c.getNbreseancecode()+1); ;
         
         System.out.print("Numéro de la séance : ");
         int num = sc.nextInt();
         sc.nextLine();
         
         System.out.print("Date et heure  : ");
         String dateStr = sc.nextLine();
         LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
         
         SeanceCode seance = new SeanceCode(num, date,c);
         s.CalculerPrix(c, seance.getPrix());
         return seance ;
     } catch (Exception e) {
         System.out.println("Erreur : " + e.getMessage());
     } return null ;
		} 
	 
	 public static int saisirCIN () {
			Scanner sc = new Scanner(System.in);
			System.out.print("Entrez CIN : ");
	        return sc.nextInt();
			
			
		}
	 public static LocalDateTime saisirNouvelleDate() {
		 Scanner sc = new Scanner(System.in);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	        System.out.print("Nouvelle date et heure (dd/MM/yyyy HH:mm) : ");
	        String dateStr = sc.nextLine();
	        return LocalDateTime.parse(dateStr, formatter);
	    }
}


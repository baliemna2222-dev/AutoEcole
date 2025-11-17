package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Candidat;
import services.CandidatService;

public class SeanceCodeUi {
	 private CandidatService s;
	    private Scanner sc = new Scanner(System.in);
	    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	    public SeanceCodeUi(CandidatService s) {
	        this.s = s;
	    }
	public void saisir() {
		try {
		 System.out.print("CIN du candidat : ");
         int cin = sc.nextInt();
         sc.nextLine(); 

         Candidat c = s.rechercher(cin);
         
         System.out.print("Numéro de la séance : ");
         int num = sc.nextInt();
         sc.nextLine();
         
         System.out.print("Date et heure (dd/MM/yyyy HH:mm) : ");
         String dateStr = sc.nextLine();
         LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
         int prix = s.getPrixSeance(c.getCategoriepermis(), "code");
         System.out.println("Prix automatique pour cette séance : " + prix);

     
         SeanceCode seance = new SeanceCode(num, date, prix, c);
         c.ajouterSeanceCode(seance);

         System.out.println("✔ Séance de code ajoutée !");
         System.out.println("Prix total du candidat : " + c.getPrixtotale());
         System.out.println("Reste à payer : " + c.getReste());

     } catch (Exception e) {
         System.out.println("Erreur : " + e.getMessage());
     }
		}
}
}

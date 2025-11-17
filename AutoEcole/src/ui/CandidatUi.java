package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Candidat;

public class CandidatUi {
	public static Candidat saisir() {
		Scanner sc = new Scanner(System.in);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("CIN : ");
        int cin = Integer.parseInt(sc.nextLine());

        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Prenom : ");
        String prenom = sc.nextLine();

        System.out.print("Date de naissance (dd/MM/yyyy) : ");
        LocalDate datenaissance = LocalDate.parse(sc.nextLine(), df);

        System.out.print("Téléphone : ");
        int telephone = Integer.parseInt(sc.nextLine());

        System.out.print("Adresse : ");
        String adresse = sc.nextLine();

        System.out.print("Ville : ");
        String ville = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Catégorie permis : ");
        String categorie = sc.nextLine();

        System.out.print("Examen code réussi (true/false) : ");
        boolean codeReussi = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Examen conduite réussi (true/false) : ");
        boolean conduiteReussi = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Nombre séance code : ");
        int nbCode = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre séance conduite : ");
        int nbConduite = Integer.parseInt(sc.nextLine());

        // Creation du candidat
        Candidat c = new Candidat(cin, nom, prenom, datenaissance, telephone, adresse,
                ville, email, categorie, codeReussi, conduiteReussi, nbCode, nbConduite);

        return c;
	}
	
}

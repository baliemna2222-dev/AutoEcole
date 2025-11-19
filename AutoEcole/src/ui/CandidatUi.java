package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import entities.Candidat;

public class CandidatUi {
    public static Candidat saisirCandidat() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String nom;
        do {
            System.out.print("Nom : ");
            nom = sc.nextLine();
            if (nom.length() < 2 || !nom.matches("[a-zA-Z]+")) 
                System.out.println("Nom invalide, minimum 2 lettres et pas de chiffres.");
        } while (nom.length() < 2 || !nom.matches("[a-zA-Z]+"));

        String prenom;
        do {
            System.out.print("Prenom : ");
            prenom = sc.nextLine();
            if (prenom.length() < 2 || !prenom.matches("[a-zA-Z]+")) 
                System.out.println("Prenom invalide, minimum 2 lettres et pas de chiffres.");
        } while (prenom.length() < 2 || !prenom.matches("[a-zA-Z]+"));

        LocalDate datenaissance = null;
        do {
            System.out.print("Date de naissance (dd/MM/yyyy) : ");
            String input = sc.nextLine();
            try {
                datenaissance = LocalDate.parse(input, df);
            } catch (DateTimeParseException e) {
                System.out.println("Date invalide.");
            }
        } while (datenaissance == null);

        int cin = -1;
        do {
            try {
                System.out.print("CIN : ");
                cin = Integer.parseInt(sc.nextLine());
                if (cin < 10000000) System.out.println("CIN invalide.");
            } catch (NumberFormatException e) {
                System.out.println("CIN invalide.");
            }
        } while (cin <10000000);

        int telephone = -1;
        do {
            try {
                System.out.print("Téléphone : ");
                telephone = Integer.parseInt(sc.nextLine());
                if (telephone <= 0) System.out.println("Téléphone invalide.");
            } catch (NumberFormatException e) {
                System.out.println("Téléphone invalide.");
            }
        } while (telephone <= 0);

        String adresse;
        do {
            System.out.print("Adresse : ");
            adresse = sc.nextLine();
            if (adresse.isEmpty()) System.out.println("Adresse invalide.");
        } while (adresse.isEmpty());

        String ville;
        do {
            System.out.print("Ville : ");
            ville = sc.nextLine();
            if (ville.isEmpty()) System.out.println("Ville invalide.");
        } while (ville.isEmpty());

        String email;
        do {
            System.out.print("Email : ");
            email = sc.nextLine();
            if (!email.contains("@") || !email.contains(".")) System.out.println("Email invalide.");
        } while (!email.contains("@") || !email.contains("."));

        String categorie;
        do {
            System.out.print("Catégorie permis (A1, A, B, B+E, C, C+E, D, D+E, H, D1) : ");
            categorie = sc.nextLine().toUpperCase();

            if (!categorie.matches("A1|A|B|B\\+E|C|C\\+E|D|D\\+E|H|D1")) {
                System.out.println("Catégorie invalide !");
                categorie = ""; 
            }

        } while (categorie.isEmpty());

        boolean codeReussi = false;
        boolean conduiteReussi = false;

        while (true) {
            System.out.print("Examen code réussi (true/false) : ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                codeReussi = Boolean.parseBoolean(input);
                break;
            }
            System.out.println("Valeur invalide.");
        }

        while (true) {
            System.out.print("Examen conduite réussi (true/false) : ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                conduiteReussi = Boolean.parseBoolean(input);
                break;
            }
            System.out.println("Valeur invalide.");
        }

        return new Candidat(cin, nom, prenom, datenaissance, telephone, adresse,
                ville, email, categorie, codeReussi, conduiteReussi);
    }

    public static int saisirCIN() {
        Scanner sc = new Scanner(System.in);
        int cin = -1;
        do {
            try {
                System.out.print("Entrez CIN : ");
                cin = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("CIN invalide.");
            }
        } while (cin <= 0);
        return cin;
    }

    public static int saisirMontant() {
        Scanner sc = new Scanner(System.in);
        int montant = -1;
        do {
            try {
                System.out.print("Entrez le montant à payer : ");
                montant = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Montant invalide.");
            }
        } while (montant <= 0);
        return montant;
    }
    public static String saisirChamp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Champs disponibles :");
        System.out.println("1. Nom");
        System.out.println("2. Prenom");
        System.out.println("3. Date de naissance");
        System.out.println("4. Téléphone");
        System.out.println("5. Adresse");
        System.out.println("6. Ville");
        System.out.println("7. Email");
        System.out.println("8. Catégorie permis");
        System.out.println("9. Examen code réussi");
        System.out.println("10. Examen conduite réussi");
        System.out.print("Choisissez le numéro du champ à modifier : ");
        int choix = Integer.parseInt(sc.nextLine());

        switch (choix) {
            case 1: return "nom";
            case 2: return "prenom";
            case 3: return "datenaissance";
            case 4: return "telephone";
            case 5: return "adresse";
            case 6: return "ville";
            case 7: return "email";
            case 8: return "categoriepermis";
            case 9: return "examencodereussi";
            case 10: return "examenconduitreussi";
            default: 
                System.out.println("Choix invalide !");
                return saisirChamp(); 
        }
    }

    public static String saisirNouvelleValeur(String champ) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la nouvelle valeur pour " + champ + " : ");
        return sc.nextLine();
    }
}

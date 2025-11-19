package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controllers.CandidatController;
import entities.Candidat;
import entities.Seance;

public class SeanceUi {
    private CandidatController candidatController;
    private Scanner sc = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public SeanceUi(CandidatController candidatController) {
        this.candidatController = candidatController;
    }

    // Saisie complète d'une séance
    public Seance saisirSeance() {
        int num = saisirNum();
        String type = saisirType();
        LocalDateTime date = saisirDate();
        Candidat c = candidatController.findCandidat();
        int prix = calculerPrix(c, type);

        Seance seance = new Seance(type, num, date, c);
        seance.setPrix(prix);
        return seance;
    }

    // Saisie numéro de séance
    public int saisirNum() {
        int num;
        do {
            System.out.print("Numéro de la séance : ");
            num = sc.nextInt();
            sc.nextLine();
            if (num <= 0) System.out.println("Numéro invalide !");
        } while (num <= 0);
        return num;
    }

    // Saisie type de séance
    public String saisirType() {
        String type;
        do {
            System.out.print("Type de séance (Code / Conduite) : ");
            type = sc.nextLine().trim();
            if (!type.equalsIgnoreCase("Code") && !type.equalsIgnoreCase("Conduite")) {
                System.out.println("Type incorrect !");
            }
        } while (!type.equalsIgnoreCase("Code") && !type.equalsIgnoreCase("Conduite"));
        return type;
    }

    // Saisie date
    public LocalDateTime saisirDate() {
        LocalDateTime date = null;
        boolean ok = false;
        while (!ok) {
            try {
                System.out.print("Date et heure (dd/MM/yyyy HH:mm) : ");
                String str = sc.nextLine();
                date = LocalDateTime.parse(str, formatter);
                ok = true;
            } catch (Exception e) {
                System.out.println("Date invalide !");
            }
        }
        return date;
    }

    // Calcul du prix selon type et catégorie du candidat
    private int calculerPrix(Candidat c, String type) {
        int prix = 0;
        String cat = c.getCategoriepermis().toUpperCase();

        if (type.equalsIgnoreCase("Conduite")) {
            switch (cat) {
                case "A1": prix = 300; break;
                case "A": prix = 350; break;
                case "B": prix = 400; break;
                case "B+E": prix = 450; break;
                case "C": prix = 500; break;
                case "C+E": prix = 550; break;
                case "D": prix = 600; break;
                case "D+E": prix = 650; break;
                case "H": prix = 400; break;
                case "D1": prix = 350; break;
                default: prix = 0; break;
            }
        } else { // Code
            switch (cat) {
                case "A1": prix = 200; break;
                case "A": prix = 250; break;
                case "B": prix = 300; break;
                case "B+E": prix = 350; break;
                case "C": prix = 400; break;
                case "C+E": prix = 450; break;
                case "D": prix = 400; break;
                case "D+E": prix = 550; break;
                case "H": prix = 300; break;
                case "D1": prix = 250; break;
                default: prix = 0; break;
            }
        }
        return prix;
    }

    // Saisie d’un champ spécifique pour modification
    public String saisirChamp() {
        System.out.println("Champs disponibles :");
        System.out.println("1. Type");
        System.out.println("2. Prix");
        System.out.println("3. Date");
        System.out.println("4. Candidat");
        System.out.print("Choisissez le numéro du champ à modifier : ");
        int choix = Integer.parseInt(sc.nextLine());

        switch (choix) {
            case 1: return "type";
            case 2: return "prix";
            case 3: return "date";
            case 4: return "candidat";
            default:
                System.out.println("Choix invalide !");
                return saisirChamp(); // répète jusqu'à avoir un choix valide
        }
    }

    // Saisie de la nouvelle valeur selon le champ
    public Object saisirNouvelleValeur(String champ) {
        switch (champ.toLowerCase()) {
            case "type":
                return saisirType();
            case "prix":
                int prix;
                do {
                    System.out.print("Nouveau prix : ");
                    prix = Integer.parseInt(sc.nextLine());
                    if (prix < 0) System.out.println("Prix invalide !");
                } while (prix < 0);
                return prix;
            case "date":
                return saisirDate();
            case "candidat":
                System.out.println("Sélection du nouveau candidat :");
                return candidatController.findCandidat();
            default:
                System.out.println("Champ invalide !");
                return null;
        }
    }
}

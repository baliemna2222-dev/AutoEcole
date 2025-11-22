package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controllers.CandidatController;
import controllers.MoniteurController;
import entities.Candidat;
import entities.Moniteur;
import entities.Seance;

public class SeanceUi {
    private CandidatController candidatController;
    private MoniteurController mc ;
    private Scanner sc = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public SeanceUi(CandidatController candidatController) {
        this.candidatController = candidatController;
    }
    public Seance saisirSeance() {
        int num = saisirNum();
        String type = saisirType();
        LocalDate date = saisirDate();
        Candidat c = candidatController.findCandidat();
        int prix = calculerPrix(c, type);
        String heure =saisirHeure();
        Moniteur m = mc.findMoniteur();
        Seance seance = new Seance(type, num, date,heure, c,m);
        seance.setPrix(prix);
        return seance;
    }
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
    public LocalDate saisirDate() {
        LocalDate date = null;
        boolean ok = false;
        while (!ok) {
            try {
                System.out.print("Date (dd/MM/yyyy) : ");
                String str = sc.nextLine();
                date = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ok = true;
            } catch (Exception e) {
                System.out.println("Date invalide !");
            }
        }
        return date;
    }
    public String saisirHeure() {
        String heure = null;
        boolean valide = false;

        while (!valide) {
            try {
                System.out.print("Heure (HH:mm) : ");
                heure = sc.nextLine();
                if (!heure.matches("\\d{2}:\\d{2}")) {
                    throw new Exception("Format incorrect");
                }

                String[] parts = heure.split(":");
                int h = Integer.parseInt(parts[0]);
                int m = Integer.parseInt(parts[1]);
                if (h < 0 || h > 23 || m < 0 || m > 59) {
                    throw new Exception("Heure hors limite");
                }
                valide = true;

            } catch (Exception e) {
                System.out.println("Heure invalide ! (exemple valide : 08:30, 14:05, 23:59)");
            }
        }

        return heure;
    }
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
        } else { 
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
                return saisirChamp(); 
        }
    }

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

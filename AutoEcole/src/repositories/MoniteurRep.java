package repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Moniteur;
import entities.Seance;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoniteurRep {

    private Moniteur[] liste = new Moniteur[10];
    private int taille = 0;
    private int capaciteSeances = 50;
    private Seance[] seances=new Seance[capaciteSeances];
    private int nbSeances=0;
    
    
    private static final String FILE_PATH = "moniteurs.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private void ensureSeances() {
        if (nbSeances >= capaciteSeances) {
            capaciteSeances *= 2;
            Seance[] temp = new Seance[capaciteSeances];
            System.arraycopy(seances, 0, temp, 0, nbSeances);
            seances = temp;
        }
    }
    public void addSeance(Seance s) {
        ensureSeances();
        seances[nbSeances++] = s;
    }

    public void displaySeances() {
        System.out.println("=== Toutes les séances planifiées ===");
        for (int i = 0; i < nbSeances; i++) {
            Seance s = seances[i];
            System.out.println("Num: " + s.getNum());
            System.out.println("Type: " + s.getType());
            System.out.println("Date: " + s.getDate());
            System.out.println("Heure: " + s.getHeure());
            System.out.println("Moniteur: " + (s.getM() != null ? s.getM().getNom() : "non assigné"));
            System.out.println("-----------------------------------");
        }
    }
    public MoniteurRep() {
        chargerDepuisJson();
    }

    public void save(Moniteur m) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == m.getCIN()) {
                liste[i] = m;
                ecrireDansJson();
                return;
            }
        }

        if (taille == liste.length) agrandir();
        liste[taille++] = m;
        ecrireDansJson();
    }

    private void agrandir() {
        Moniteur[] nouveau = new Moniteur[liste.length + 10];
        for (int i = 0; i < taille; i++) {
            nouveau[i] = liste[i];
        }
        liste = nouveau;
    }

    public boolean update(long cin, Moniteur nouveau) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) {
                liste[i] = nouveau;
                ecrireDansJson();
                return true;
            }
        }
        return false;
    }

    public Moniteur find(double cin) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) return liste[i];
        }
        return null;
    }

    public boolean delete(long cin) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) {
                for (int j = i; j < taille - 1; j++) liste[j] = liste[j + 1];
                liste[taille - 1] = null;
                taille--;
                ecrireDansJson();
                return true;
            }
        }
        return false;
    }

    public void display(Moniteur m) {
        System.out.println("Nom: " + m.getNom());
        System.out.println("Prénom: " + m.getPrenom());
        System.out.println("CIN: " + m.getCIN());
        System.out.println("Gmail: " + m.getGmail());
        System.out.println("Téléphone: " + m.getTelephone());
        System.out.println("Disponible: " + m.isDisponible());
        System.out.println("Heures travailléesCode: " + m.getHeuresTravaillecode());
        System.out.println("Heures travailléesConduite: " + m.getHeuresTravailleconduite());
        System.out.println("Type de séance: " + m.getTypeSeance());
    }

    public void findAll() {
        for (int i = 0; i < taille; i++) display(liste[i]);
    }

    public int getTaille() {
        return taille;
    }

    private void ecrireDansJson() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Moniteur[] copie = new Moniteur[taille];
            for (int i = 0; i < taille; i++) copie[i] = liste[i];
            gson.toJson(copie, writer);
        } catch (IOException e) {
            System.out.println("Erreur d'écriture JSON : " + e.getMessage());
        }
    }

    private void chargerDepuisJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Moniteur[] data = gson.fromJson(reader, Moniteur[].class);
            if (data != null) {
                liste = new Moniteur[data.length + 10];
                taille = 0;
                for (Moniteur m : data) liste[taille++] = m;
            }
        } catch (IOException e) {
            System.out.println("Aucun fichier JSON détecté. (Première utilisation)");
        }
    }
}

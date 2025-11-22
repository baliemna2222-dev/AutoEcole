package repositories;

import java.io.*;
import java.time.LocalDate;
import com.google.gson.*;
import entities.Seance;

public class SeanceRep {

    private Seance[] seances;
    private int taille;
    private int capacite = 10;
    private final String fichier = "seances.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class,
                    (JsonSerializer<LocalDate>) (date, type, context) ->
                            new JsonPrimitive(date.toString()))
            .registerTypeAdapter(LocalDate.class,
                    (JsonDeserializer<LocalDate>)
                            (json, type, context) -> LocalDate.parse(json.getAsString()))
            .setPrettyPrinting()
            .create();

    public SeanceRep() {
        seances = new Seance[capacite];
        taille = 0;

        File file = new File(fichier);
        try {
            if (!file.exists() || file.length() == 0) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("[]");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Seance[] loaded = chargerDepuisJson();
        if (loaded != null) {
            for (Seance s : loaded) add(s);
        }
    }

    private void ensureCapacity() {
        if (taille >= capacite) {
            capacite *= 2;
            Seance[] temp = new Seance[capacite];
            System.arraycopy(seances, 0, temp, 0, taille);
            seances = temp;
        }
    }

    public void add(Seance s) {
        ensureCapacity();
        seances[taille++] = s;
        sauvegarderDansJson();
    }

    

    public Seance getByNum(int num) {
        for (int i = 0; i < taille; i++) {
            if (seances[i].getNum() == num) return seances[i];
        }
        return null;
    }

    public boolean deleteByNum(int num) {
        for (int i = 0; i < taille; i++) {
            if (seances[i].getNum() == num) {
                for (int j = i; j < taille - 1; j++) {
                    seances[j] = seances[j + 1];
                }
                seances[--taille] = null;
                sauvegarderDansJson();
                return true;
            }
        }
        return false;
    }

    public boolean update(Seance newSeance) {
        for (int i = 0; i < taille; i++) {
            if (seances[i].getNum() == newSeance.getNum()) {
                seances[i] = newSeance;
                sauvegarderDansJson();
                return true;
            }
        }
        return false;
    }

    private void sauvegarderDansJson() {
        try (FileWriter writer = new FileWriter(fichier)) {
            Seance[] arrToSave = new Seance[taille];
            System.arraycopy(seances, 0, arrToSave, 0, taille);
            gson.toJson(arrToSave, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Seance[] chargerDepuisJson() {
        try (FileReader reader = new FileReader(fichier)) {
            return gson.fromJson(reader, Seance[].class);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            return new Seance[0];
        }
    }

    public void display(Seance s) {
        if (s != null) {
            System.out.println("--------------------------------");
            System.out.println("Num : " + s.getNum());
            System.out.println("CIN Candidat : " + (s.getC() ));
            System.out.println("CIN Moniteur : " + (s.getMoniteur() ));
            System.out.println("Type : " + s.getType());
            System.out.println("Prix : " + s.getPrix());
            System.out.println("Date : " + (s.getDate() ));
            System.out.println("Heure : " + (s.getHeure() ));
            System.out.println("--------------------------------");
        } else {
            System.out.println("Séance introuvable !");
        }
    }

    public void displayAll() {
        if (taille == 0) {
            System.out.println("Aucune séance disponible.");
            return;
        }
        for (int i = 0; i < taille; i++) display(seances[i]);
    }
}

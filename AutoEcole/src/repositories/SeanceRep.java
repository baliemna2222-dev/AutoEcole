package repositories;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import entities.Seance;

public class SeanceRep {
    private Seance[] seances;
    private int taille;
    private int capacite = 10;
    private final String fichier = "seances.json";
    private Gson gson;

    public SeanceRep() {
        seances = new Seance[capacite];
        taille = 0;

        // Gson with LocalDateTime TypeAdapter
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                    private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    @Override
                    public void write(JsonWriter out, LocalDateTime value) throws IOException {
                        if (value != null) {
                            out.value(value.format(df));
                        } else {
                            out.nullValue();
                        }
                    }

                    @Override
                    public LocalDateTime read(JsonReader in) throws IOException {
                        String s = in.nextString();
                        return s != null && !s.isEmpty() ? LocalDateTime.parse(s, df) : null;
                    }
                })
                .create();

        // Create JSON file if missing
        File file = new File(fichier);
        try {
            if (!file.exists() || file.length() == 0) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("[]");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load existing seances from JSON
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

    // ===== CRUD METHODS =====
    public void add(Seance s) {
        ensureCapacity();
        seances[taille++] = s;
        sauvegarderDansJson();
    }

    public Seance[] getAll() {
        Seance[] result = new Seance[taille];
        System.arraycopy(seances, 0, result, 0, taille);
        return result;
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
                for (int j = i; j < taille - 1; j++) seances[j] = seances[j + 1];
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

    // ===== JSON HANDLING =====
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

    // ===== DISPLAY METHODS =====
    public void display(Seance s) {
        if (s != null) {
            System.out.println("===== Informations Séance =====");
            System.out.println("Num : " + s.getNum());
            System.out.println("Candidat CIN : " + (s.getC() != null ? s.getC().getCIN() : "Non assigné"));
            System.out.println("Type : " + s.getType());
            System.out.println("Prix : " + s.getPrix());
            System.out.println("Date : " + (s.getDate() != null ? s.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) : "Non défini"));
            System.out.println("================================");
        } else {
            System.out.println("Séance introuvable !");
        }
    }

    public void displayAll() {
        if (taille == 0) {
            System.out.println("Aucune séance à afficher.");
            return;
        }

        System.out.println("Num | CIN | Type | Prix | Date");
        System.out.println("----------------------------------------");
        for (int i = 0; i < taille; i++) display(seances[i]);
        System.out.println("----------------------------------------");
    }

    // ===== SEARCH BY NUMBER =====
    public Seance rechercherParNumero(int num) {
        return getByNum(num);
    }

    // ===== DELETE BY NUMBER =====
    public boolean supprimer(int num) {
        return deleteByNum(num);
    }

    // ===== ADD/UPDATE METHODS (for Service) =====
    public void ajouter(Seance s) {
        add(s);
    }
}

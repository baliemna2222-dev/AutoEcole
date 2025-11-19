package repositories;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import entities.Candidat;

public class CandidatRepository {
    private Candidat[] candidats;
    private int size;
    private int capacity = 10;
    private final String fichier = "candidats.json";
    private Gson gson;

    public CandidatRepository() {
        candidats = new Candidat[capacity];
        size = 0;

        // Créer le fichier JSON si vide ou inexistant
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

        // Gson avec TypeAdapter LocalDate
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new TypeAdapter<LocalDate>() {
                    private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    @Override
                    public void write(JsonWriter out, LocalDate value) throws IOException {
                        out.value(value.format(df));
                    }

                    @Override
                    public LocalDate read(JsonReader in) throws IOException {
                        return LocalDate.parse(in.nextString(), df);
                    }
                })
                .create();

        // Charger depuis JSON
        Candidat[] loaded = chargerDepuisJson();
        if (loaded != null) {
            for (Candidat c : loaded) add(c);
        }
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            Candidat[] newArray = new Candidat[capacity];
            System.arraycopy(candidats, 0, newArray, 0, size);
            candidats = newArray;
        }
    }

    public void add(Candidat c) {
        ensureCapacity();
        candidats[size++] = c;
        sauvegarderDansJson();
    }

    public void getAll() {
        Candidat[] result = new Candidat[size];
        for (int i = 0; i < size; i++) {
             display(candidats[i]);
    }}

    public Candidat getByCin(int cin) {
        for (int i = 0; i < size; i++) {
            if (candidats[i].getCIN() == cin) return candidats[i];
        }
        return null;
    }

    public boolean deleteByCin(int cin) {
        for (int i = 0; i < size; i++) {
            if (candidats[i].getCIN() == cin) {
                for (int j = i; j < size - 1; j++) candidats[j] = candidats[j + 1];
                candidats[--size] = null;
                sauvegarderDansJson();
                return true;
            }
        }
        return false;
    }

    public boolean update(Candidat newCandidat) {
        for (int i = 0; i < size; i++) {
            if (candidats[i].getCIN() == newCandidat.getCIN()) {
                candidats[i] = newCandidat;
                sauvegarderDansJson();
                return true;
            }
        }
        return false;
    }

    private void sauvegarderDansJson() {
        try (FileWriter writer = new FileWriter(fichier)) {
            Candidat[] arrToSave = new Candidat[size];
            System.arraycopy(candidats, 0, arrToSave, 0, size);
            gson.toJson(arrToSave, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Candidat[] chargerDepuisJson() {
        try (FileReader reader = new FileReader(fichier)) {
            return gson.fromJson(reader, Candidat[].class);
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            return new Candidat[0];
        }
    }

    // ==== DISPLAY METHOD (unchanged) ====
    public void display(Candidat c) {
        if (c != null) {
            System.out.println("===== Informations du Candidat =====");
            System.out.println("CIN : " + c.getCIN());
            System.out.println("Nom : " + c.getNom());
            System.out.println("Prénom : " + c.getPrenom());
            System.out.println("Date de naissance : " + c.getDatedenaissance());
            System.out.println("Téléphone : " + c.getTelephone());
            System.out.println("Adresse : " + c.getAdresse());
            System.out.println("Ville : " + c.getVille());
            System.out.println("Email : " + c.getEmail());
            System.out.println("Catégorie permis : " + c.getCategoriepermis());
            System.out.println("Examen code réussi : " + c.isExamencodereussi());
            System.out.println("Examen conduite réussi : " + c.isExamenconduitreussi());
            System.out.println("Nombre séance code : " + c.getNbreseancecode());
            System.out.println("Nombre séance conduite : " + c.getNbreseanceconduit());
            System.out.println("Prix total : " + c.getPrixtotale());
            System.out.println("Prix payé : " + c.getPrixpaye());
            System.out.println("Reste : " + c.getReste());
            System.out.println("===================================");
        } else {
            System.out.println("Candidat introuvable !");
        }
    }
    
}

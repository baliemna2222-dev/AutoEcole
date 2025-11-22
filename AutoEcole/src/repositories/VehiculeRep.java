package repositories;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import entities.Echeance;
import entities.Reparation;
import entities.Vehicule;
import ui.TypeVehicule;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VehiculeRep {
    private List<Vehicule> motos = new ArrayList<>();
    private List<Vehicule> voitures = new ArrayList<>();
    private List<Vehicule> camions = new ArrayList<>();
    private List<Vehicule> autobus = new ArrayList<>();
    List<Vehicule> all = new ArrayList<>();
    List<Reparation> reparations = new ArrayList<>();

    private final String VEHICULES_FILE = "vehicules.json";
    private final String REPARATIONS_FILE = "reparations.json";

    // Adapter Gson pour LocalDate
    static class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(formatter));
        }

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString(), formatter);
        }
    }

    public VehiculeRep() {
        loadVehicules();
        loadReparations();
    }

    public boolean ajouter(Vehicule v) {
        for (Vehicule e : all) {
            if (e.getImmatricule() == v.getImmatricule()) {
                System.out.println("Immatricule existe deja !");
                return false;
            }
        }
        switch (v.getType()) {
            case MOTO: motos.add(v); break;
            case VOITURE: voitures.add(v); break;
            case CAMION: camions.add(v); break;
            case AUTOBUS: autobus.add(v); break;
        }
        all.add(v);
        saveVehicules();
        System.out.println("Véhicule ajouté dans " + v.getType());
        return true;
    }

    public Vehicule rechercher(int immatricule) {
        for (Vehicule v : all) {
            if (v.getImmatricule() == immatricule) return v;
        }
        return null;
    }

    public boolean modifier(Vehicule v, Vehicule nouveau) {
        int immatricule = v.getImmatricule();
        List<Vehicule> liste;
        switch (v.getType()) {
            case MOTO: liste = motos; break;
            case VOITURE: liste = voitures; break;
            case CAMION: liste = camions; break;
            default: liste = autobus; break;
        }
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getImmatricule() == immatricule) {
                liste.set(i, nouveau);
                saveVehicules();
                System.out.println("Véhicule modifié !");
                return true;
            }
        }
        System.out.println("Véhicule non trouvé !");
        return false;
    }

    public void supprimer(int immatricule) {
        Vehicule v = rechercher(immatricule);
        if (v != null) {
            all.remove(v);
            switch (v.getType()) {
                case MOTO: motos.remove(v); break;
                case VOITURE: voitures.remove(v); break;
                case CAMION: camions.remove(v); break;
                default: autobus.remove(v); break;
            }
            saveVehicules();
            System.out.println("Véhicule supprimé !");
        } else {
            System.out.println("Véhicule non trouvé !");
        }
    }

    public List<Vehicule> getAll() {
        all.clear();
        all.addAll(motos);
        all.addAll(voitures);
        all.addAll(camions);
        all.addAll(autobus);
        return all;
    }

    public void getListe(List<Vehicule> l) {
        for (Vehicule v : l) displayVehicule(v);
    }

    public void afficherTous() {
        System.out.println("===== LISTE DES VEHICULES =====");
        for (Vehicule v : all) displayVehicule(v);
        System.out.println("================================");
    }

    public void displayVehicule(Vehicule v) {
        if (v != null) {
            System.out.println("----------------------------------------");
            System.out.println("| Immatricule : " + v.getImmatricule());
            System.out.println("| Type        : " + v.getType());
            System.out.println("| Date mise en service : " + v.getDatemiseenservice());
            System.out.println("| Prix        : " + v.getPrix() + " TND");
            System.out.println("| Kilométrage total     : " + v.getKilometrageTotale() + " km");
            System.out.println("| Km avant prochaine visite : " + v.getNbkmrestant() + " km");
            System.out.println("----------------------------------------");
        }
    }

    public void getAlertes() {
        List<String> alertes = new ArrayList<>();
        for (Vehicule v : all) {
            if (v.getEcheances() == null) continue;
            for (Echeance e : v.getEcheances()) {
                if (e == null) continue;
                if (e.estExpiree()) alertes.add("⚠️ EXPIREE | " + e.getType() + " | Vehicule: " + v.getImmatricule() + " | Date limite: " + e.getDateLimite());
                else if (e.estProche()) alertes.add("⚠️ PROCHAINE | " + e.getType() + " | Vehicule: " + v.getImmatricule() + " | Date limite: " + e.getDateLimite());
            }
        }
        for (String s : alertes) System.out.println(s);
    }

    public void ajouterReparation(int immatricule, Reparation r) {
        Vehicule v = rechercher(immatricule);
        if (v != null) {
            reparations.add(r);
            saveReparations();
            System.out.println("Réparation ajoutée au véhicule " + immatricule);
        } else {
            System.out.println("Véhicule introuvable !");
        }
    }

    public void afficherrepartions() {
        System.out.println("===== Réparations du véhicule =====");
        for (Reparation r : reparations) {
            System.out.println("----------------------------------------");
            System.out.println("| Immatricule Voiture : " + r.getMatricule());
            System.out.println("| Date        : " + r.getDate());
            System.out.println("| Description : " + r.getDescription());
            System.out.println("| Montant     : " + r.getMontant() + " TND");
            System.out.println("| Preuve      : " + r.getPreuve());
            System.out.println("----------------------------------------");
        }
    }

    // ----------------- JSON -----------------

    private void saveVehicules() {
        try (Writer writer = new FileWriter("vehicules.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            gson.toJson(all, writer);
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde véhicules : " + e.getMessage());
        }
    }

    private void loadVehicules() {
        try (Reader reader = new FileReader("vehicules.json")) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            Type listType = new TypeToken<List<Vehicule>>() {}.getType();
            all = gson.fromJson(reader, listType);
            if (all == null) all = new ArrayList<>();
            // remplir les listes par type
            motos.clear(); voitures.clear(); camions.clear(); autobus.clear();
            for (Vehicule v : all) {
                switch (v.getType()) {
                    case MOTO: motos.add(v); break;
                    case VOITURE: voitures.add(v); break;
                    case CAMION: camions.add(v); break;
                    default: autobus.add(v); break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠ Fichier véhicules non trouvé, création d'un nouveau.");
        } catch (IOException e) {
            System.out.println("Erreur chargement véhicules : " + e.getMessage());
        }
    }

    private void saveReparations() {
        try (Writer writer = new FileWriter("reparations.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            gson.toJson(reparations, writer);
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde réparations : " + e.getMessage());
        }
    }

    private void loadReparations() {
        try (Reader reader = new FileReader("reparations.json")) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            Type listType = new TypeToken<List<Reparation>>() {}.getType();
            reparations = gson.fromJson(reader, listType);
            if (reparations == null) reparations = new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.out.println("⚠ Fichier réparations non trouvé, création d'un nouveau.");
        } catch (IOException e) {
            System.out.println("Erreur chargement réparations : " + e.getMessage());
        }
    }
}

package repositories;

import entities.Moniteur;

public class MoniteurRep {

    private Moniteur[] liste = new Moniteur[10];
    private int taille = 0;

    // ============================
    //            SAVE
    // ============================

    public void save(Moniteur m) {
        // Vérifier update → CIN existe
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == m.getCIN()) {
                liste[i] = m;   // update
                return;
            }
        }

        // Sinon → ajout
        if (taille == liste.length) {
            agrandir();
        }

        liste[taille] = m;
        taille++;
    }

    private void agrandir() {
        Moniteur[] nouveau = new Moniteur[liste.length + 10];
        for (int i = 0; i < taille; i++) {
            nouveau[i] = liste[i];
        }
        liste = nouveau;
    }

    // ============================
    //            UPDATE
    // ============================

    public boolean update(long cin, Moniteur nouveau) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) {
                liste[i] = nouveau;
                return true;
            }
        }
        return false;
    }

    // ============================
    //            FIND
    // ============================

    public Moniteur find(long cin) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) {
                return liste[i];
            }
        }
        return null;
    }

    // ============================
    //            DELETE
    // ============================

    public boolean delete(long cin) {
        for (int i = 0; i < taille; i++) {
            if (liste[i].getCIN() == cin) {

                // décaler
                for (int j = i; j < taille - 1; j++) {
                    liste[j] = liste[j + 1];
                }

                liste[taille - 1] = null;
                taille--;
                return true;
            }
        }
        return false;
    }
    public void display(Moniteur m) {
            System.out.println(
                    "Nom: " + m.getNom() +
                    ", Prénom: " + m.getPrenom() +
                    ", CIN: " + m.getCIN() +
                    ", Gmail: " + m.getGmail() +
                    ", Téléphone: " + m.getTelephone() +
                    ", Disponible: " + m.isDisponible() +
                    ", Heures travaillées: " + m.getHeuresTravaillees() +
                    ", Type de séance: " + m.getTypeSeance()
            );
        }
    

    // ============================
    //            FIND ALL
    // ============================

    public void findAll() {
        for (int i = 0; i < taille; i++) {
            display(liste[i]) ;
        }
        
    }

    public int getTaille() {
        return taille;
    }
}

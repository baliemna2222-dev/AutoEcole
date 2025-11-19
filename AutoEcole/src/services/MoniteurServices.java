package services;
import entities.Moniteur;
import repositories.MoniteurRep;

	public class MoniteurServices {

	    private MoniteurRep repo = new MoniteurRep();

	    // ============================
	    //         AJOUTER
	    // ============================
	    public void ajouter(Moniteur m) {
	        repo.save(m);
	    }

	    // ============================
	    //         CHERCHER
	    // ============================
	    public Moniteur chercher(long cin) {
	        return repo.find(cin);
	    }

	    // ============================
	    //         SUPPRIMER
	    // ============================
	    public boolean supprimer(long cin) {
	        return repo.delete(cin);
	    }

	    public boolean updateChamp(long cin, String champ, Object nouvelleValeur) {

	        Moniteur m = repo.find(cin);

	        if (m == null) {
	            return false; // moniteur introuvable
	        }

	        switch (champ.toLowerCase()) {

	            case "nom":
	                m.setNom((String) nouvelleValeur);
	                break;

	            case "prenom":
	                m.setPrenom((String) nouvelleValeur);
	                break;

	            case "cin":
	                m.setCIN((Long) nouvelleValeur);
	                break;

	            case "gmail":
	                // casting obligatoire
	                m.setGmail((String) nouvelleValeur);
	                break;

	            case "telephone":
	                m.setTelephone((Integer) nouvelleValeur);
	                break;

	            case "disponible":
	                m.setDisponible((Boolean) nouvelleValeur);
	                break;

	            case "heures":
	                m.setHeuresTravaillees((Double) nouvelleValeur);
	                break;

	            case "typeseance":
	                m.setTypeSeance((String) nouvelleValeur);
	                break;

	            default:
	                return false; // champ inexistant
	        }

	        // Sauvegarder la modification
	        repo.save(m);
	        return true;
	    }
	    public void liste() {
	        repo.findAll();
	    }

    public int calculSalaire(Moniteur m,String type) {
    	    int tarif = 0;
    	    if (type.equals("code"))
            tarif = 8;
        else if (type.equals("conduite"))
            tarif = 12;
        else {
        	tarif = 0;
        }
        m.setSalaire(m.getSalaire()+tarif);
        repo.update(m.getCIN(), m);
        return m.getSalaire();
    }
    
}
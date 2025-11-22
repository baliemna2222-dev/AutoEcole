package services;
import entities.Moniteur;
import entities.Seance;
import repositories.MoniteurRep;

	public class MoniteurServices {

	    private MoniteurRep repo = new MoniteurRep();

	    public void ajouter(Moniteur m) {
	        repo.save(m);
	    }

	    public Moniteur chercher(double cin) {
	        return repo.find(cin);
	    }

	    public boolean supprimer(long cin) {
	        return repo.delete(cin);
	    }

	    public boolean updateChamp(long cin, String champ, Object nouvelleValeur) {

	        Moniteur m = repo.find(cin);

	        if (m == null) {
	            return false; 
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
	                m.setGmail((String) nouvelleValeur);
	                break;

	            case "telephone":
	                m.setTelephone((Integer) nouvelleValeur);
	                break;

	            case "disponible":
	                m.setDisponible((Boolean) nouvelleValeur);
	                break;
	            case "typeseance":
	                m.setTypeSeance((String) nouvelleValeur);
	                break;

	            default:
	                return false; 
	        }

	        repo.save(m);
	        return true;
	    }
	 /*   public boolean ajouterSeance(Moniteur m, Seance s) {
	    	repo.addSeance(s);
	    	
	    }*/
	   
	    
	    public void liste() {
	        repo.findAll();
	    }

    public int calculSalaire(Moniteur m) {
    	    int tarif = 0;
            tarif = (int) (8*m.getHeuresTravaillecode())+(int) (12*m.getHeuresTravailleconduite());              
        m.setSalaire(tarif);
        repo.update(m.getCIN(), m);
        return m.getSalaire();
    }
    
}
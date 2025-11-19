package entities;

public class Moniteur {
	
    private String nom;
    private String prenom;
    private long CIN;
    private String gmail;
    private int telephone ;
    private boolean disponible; 
    private double heuresTravaillees;
    private String typeSeance;
    private int salaire ;

	

	public Moniteur(String nom, String prenom, long cIN, String gmail, int telephone, boolean disponible) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.gmail = gmail;
		this.telephone = telephone;
		this.disponible = disponible;
		this.heuresTravaillees = 0;
		this.typeSeance = "";
		this.salaire=0 ;
	}

	
	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
    	    return nom;
    	    }
   
    public void setNom(String nom) { 
    	    this.nom = nom;
    	    }
    public String getPrenom() {
	    return prenom;
	    }

public void setPrenom(String prenom) { 
	    this.prenom = prenom;
	    }
    public long getCIN() {
    	   return CIN;
    }
    public void setCIN(long CIN) { 
	    this.CIN =CIN;
	    }
    
  
    

    public boolean isDisponible() {
    	    return disponible; 
    	}
    
    public void setDisponible(boolean disponible) {
    	    this.disponible = disponible; 
    	    }


	public double getHeuresTravaillees() {
		return heuresTravaillees;
	}


	public void setHeuresTravaillees(double heuresTravaillees) {
		this.heuresTravaillees = heuresTravaillees;
	}


	public String getTypeSeance() {
		return typeSeance;
	}


	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}
}

package entities;

import java.time.LocalDate;

public class Candidat {
	//info
		private int CIN ;
		private String nom ; 
		private String prenom ;
		private LocalDate datedenaissance ;
		private int telephone ;
		private String adresse ;
		private String ville ;
		private String email ;
		
		//info sur le permis
		private String categoriepermis ;
		private boolean examencodereussi ; 
		private boolean examenconduitreussi ; 
		private int nbreseancecode ;
		private int nbreseanceconduit ;
		
		private int prixtotale ; 
		private int prixpaye ;
		private int reste ;
	
		
	public Candidat(int cIN, String nom, String prenom, LocalDate datedenaissance, int telephone, String adresse,
			String ville, String email, String categoriepermis, boolean examencodereussi, boolean examenconduitreussi,
			int nbreseancecode, int nbreseanceconduit) {
		super();
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.datedenaissance = datedenaissance;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
		this.categoriepermis = categoriepermis;
		this.examencodereussi = examencodereussi;
		this.examenconduitreussi = examenconduitreussi;
		this.nbreseancecode = nbreseancecode;
		this.nbreseanceconduit = nbreseanceconduit;
		this.prixtotale = 0;
		this.prixpaye=0;
		this.reste=0 ;
		
	}



	public int getCIN() {
		return CIN;
	}



	public void setCIN(int cIN) {
		CIN = cIN;
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



	public LocalDate getDatedenaissance() {
		return datedenaissance;
	}



	public void setDatedenaissance(LocalDate datedenaissance) {
		this.datedenaissance = datedenaissance;
	}



	public int getTelephone() {
		return telephone;
	}



	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCategoriepermis() {
		return categoriepermis;
	}



	public void setCategoriepermis(String categoriepermis) {
		this.categoriepermis = categoriepermis;
	}



	public boolean isExamencodereussi() {
		return examencodereussi;
	}



	public void setExamencodereussi(boolean examencodereussi) {
		this.examencodereussi = examencodereussi;
	}



	public boolean isExamenconduitreussi() {
		return examenconduitreussi;
	}



	public void setExamenconduitreussi(boolean examenconduitreussi) {
		this.examenconduitreussi = examenconduitreussi;
	}



	public int getNbreseancecode() {
		return nbreseancecode;
	}



	public void setNbreseancecode(int nbreseancecode) {
		this.nbreseancecode = nbreseancecode;
	}



	public int getNbreseanceconduit() {
		return nbreseanceconduit;
	}



	public void setNbreseanceconduit(int nbreseanceconduit) {
		this.nbreseanceconduit = nbreseanceconduit;
	}



	public int getPrixtotale() {
		return prixtotale;
	}



	public void setPrixtotale(int prixtotale) {
		this.prixtotale = prixtotale;
	}
	

	public int getPrixpaye() {
		return prixpaye;
	}



	public void setPrixpaye(int prixpaye) {
		this.prixpaye = prixpaye;
	}



	public int getReste() {
		return reste;
	}



	public void setReste(int reste) {
		this.reste = reste;
	}



	@Override
	public String toString() {
		return "Candidat [CIN=" + CIN + ", nom=" + nom + ", prenom=" + prenom + ", datedenaissance=" + datedenaissance
				+ ", telephone=" + telephone + ", adresse=" + adresse + ", ville=" + ville + ", email=" + email
				+ ", categoriepermis=" + categoriepermis + ", examencodereussi=" + examencodereussi
				+ ", examenconduitreussi=" + examenconduitreussi + ", nbreseancecode=" + nbreseancecode
				+ ", nbreseanceconduit=" + nbreseanceconduit + ", prixtotale=" + prixtotale + ", prixpaye=" + prixpaye
				+ ", reste=" + reste + "]";
	}

	
	
	
	
	
}

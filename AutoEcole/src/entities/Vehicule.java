package entities;

import java.time.LocalDate;

import ui.TypeVehicule;

public class Vehicule {
	public Vehicule(TypeVehicule type, int immatricule, LocalDate datemiseenservice, int prix, float kilometrageTotale,
			float nbkmrestant) {
		super();
		this.type = type;
		
		this.immatricule = immatricule;
		this.datemiseenservice = datemiseenservice;
		this.prix = prix;
		this.kilometrageTotale = kilometrageTotale;
		this.nbkmrestant = nbkmrestant;
	}
	private TypeVehicule type ;
	private int immatricule ; 
	private LocalDate datemiseenservice ;
	private int prix ; 
	private float kilometrageTotale ;
	private float nbkmrestant ;
	public TypeVehicule getType() {
		return type;
	}
	public void setType(TypeVehicule type) {
		this.type = type;
	}

	public int getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(int immatricule) {
		this.immatricule = immatricule;
	}
	public LocalDate getDatemiseenservice() {
		return datemiseenservice;
	}
	public void setDatemiseenservice(LocalDate datemiseenservice) {
		this.datemiseenservice = datemiseenservice;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public float getKilometrageTotale() {
		return kilometrageTotale;
	}
	public void setKilometrageTotale(float kilometrageTotale) {
		this.kilometrageTotale = kilometrageTotale;
	}
	public float getNbkmrestant() {
		return nbkmrestant;
	}
	public void setNbkmrestant(float nbkmrestant) {
		this.nbkmrestant = nbkmrestant;
	}
	
	
}

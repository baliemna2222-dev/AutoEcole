package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ui.TypeVehicule;
public class Vehicule {
	public Vehicule() {}
	public Vehicule(TypeVehicule type, int immatricule, LocalDate datemiseenservice, int prix, float kilometrageTotale,
			float nbkmrestant,List<Echeance> e) {
		super();
		this.type = type;
		
		this.immatricule = immatricule;
		this.datemiseenservice = datemiseenservice;
		this.prix = prix;
		this.kilometrageTotale = kilometrageTotale;
		this.nbkmrestant = nbkmrestant;
		this.echeances=e;
	
		
	}
	private TypeVehicule type ;
	private int immatricule ; 
	private LocalDate datemiseenservice ;
	private int prix ; 
	private float kilometrageTotale ;
	private float nbkmrestant ;
	private List<Echeance> echeances = new ArrayList<>();

	
	public List<Echeance> getEcheances() {
		return echeances;
	}
	public void setEcheances(List<Echeance> echeances) {
		this.echeances = echeances;
	}
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

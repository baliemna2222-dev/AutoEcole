package entities;

import java.time.LocalDate;

public class Reparation {
	public Reparation(LocalDate date, String description, float montant, String preuve) {
		super();
		this.date = date;
		this.description = description;
		this.montant = montant;
		this.preuve = preuve;
		this.matricule=0;
		
	}
	private LocalDate date;
    private String description;
    private float montant;
    private String preuve;
    private int matricule ;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getPreuve() {
		return preuve;
	}
	public void setPreuve(String preuve) {
		this.preuve = preuve;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
    
    
}

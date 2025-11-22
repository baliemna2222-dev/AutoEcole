package entities;

import java.time.LocalDate;

public class Echeance {
	private TypeEcheance  type; 
    private LocalDate dateLimite;
    private float kmRestant ;
    private boolean realise;
    public Echeance(TypeEcheance type) {
        this.type = type;
        this.realise = false;
    }
    
	public float getKmRestant() {
		return kmRestant;
	}

	public void setKmRestant(float kmRestant) {
		this.kmRestant = kmRestant;
	}

	public TypeEcheance getType() {
		return type;
	}
	public void setType(TypeEcheance type) {
		this.type = type;
	}
	public LocalDate getDateLimite() {
		return dateLimite;
	}
	public void setDateLimite(LocalDate dateLimite) {
		this.dateLimite = dateLimite;
	}
	
	public boolean isRealise() {
		return realise;
	}
	public void setRealise(boolean realise) {
		this.realise = realise;
	}
	public boolean estExpiree() {
        return LocalDate.now().isAfter(dateLimite);
    }

    public boolean estProche() {
        switch(type) {
            case VIGNETTE: return LocalDate.now().plusDays(15).isAfter(dateLimite);
            case VISITE_TECHNIQUE: return LocalDate.now().plusDays(20).isAfter(dateLimite);
            case ASSURANCE: return LocalDate.now().plusDays(10).isAfter(dateLimite);
            case VIDANGE: return kmRestant < 500 || LocalDate.now().isAfter(dateLimite);
            default: return false;
        }
    }
    
}


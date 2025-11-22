package ui;

public enum TypeVehicule {
	MOTO,
    VOITURE,
    CAMION,
    AUTOBUS;

    public static TypeVehicule fromString(String type) {
        switch(type.toUpperCase()) {
            case "MOTO": return MOTO;
            case "VOITURE": return VOITURE;
            case "CAMION": return CAMION;
            case "AUTOBUS": return AUTOBUS;
            default: return null;
        } }
        
    
}


package ui;

import java.time.LocalDate;
import java.util.Scanner;

import entities.Vehicule;

public class VehiculeUi {

	    Scanner sc = new Scanner(System.in);
	    public Integer lireInt(String msg) {
	        while (true) {
	            System.out.print(msg + " ");
	            String input = sc.next();

	            if (input.equalsIgnoreCase("q")) return null; 
	            try {
	                int number = Integer.valueOf(input); 
	                if (number < 0) {
	                    System.out.println("Valeur négative interdite !");
	                } else {
	                    return number;
	                }
	            } catch (Exception e) {
	                System.out.println("Donnée invalide ! Vous devez entrer un nombre entier.");
	            }
	        }
	    }
	    public Float lireFloat(String msg) {
	        while (true) {
	            System.out.print(msg + " ");
	            String input = sc.next();

	            if (input.equalsIgnoreCase("q")) return null;

	            try {
	                float number = Float.valueOf(input);
	                if (number < 0) {
	                    System.out.println("⚠ Valeur négative interdite !");
	                } else {
	                    return number;
	                }
	            } catch (Exception e) {
	                System.out.println("❌ Donnée invalide ! Vous devez entrer un nombre réel.");
	            }
	        }
	    }
	    public String lireString(String msg) {
	        while (true) {
	            System.out.print(msg + " ");
	            String input = sc.nextLine().trim();
	            if (!input.isEmpty()) {
	                return input;
	            } else {
	                System.out.println("Champ obligatoire !");
	            }
	        }
	    }
	    public LocalDate lireLocalDate(String msg) {
	        while (true) {
	            System.out.print(msg + "  : ");
	            String input = sc.nextLine().trim();
	            try {
	                LocalDate date = LocalDate.parse(input);
	                if (date.isAfter(LocalDate.now())) {
	                    System.out.println("La date ne peut pas être dans le futur !");
	                } else {
	                    return date;
	                }
	            } catch (Exception e) {
	                System.out.println("Format de date invalide !");
	            }
	        }
	    }

	    public Vehicule saisirVehicule() {
	    	
	        System.out.println("\n===== SAISIE VEHICULE =====");

	        TypeVehicule type = null;
	        while (type == null) {
	            System.out.print("Type du véhicule  : ");
	            String input = sc.next().trim();
	            if (input.equalsIgnoreCase("q")) return null;  

	            try {
	                type = TypeVehicule.valueOf(input.toUpperCase());   
	                } catch (IllegalArgumentException e) {
	                System.out.println("Type invalide ! Veuillez saisir MOTO, VOITURE, CAMION ou AUTOBUS.");
	   
	            }
	        }
	        Integer immatricule = lireInt("Immatricule :");
	        if (immatricule == null) return null;
	        
	        LocalDate dateService = null;
	        boolean test = true;

	        while (test) {
	            System.out.print("Date mise en service : ");
	            String input = sc.next();

	            if (input.equalsIgnoreCase("q")) return null;  // quitter

	            try {
	                dateService = LocalDate.parse(input);  
	                test = false;         
	                } catch (Exception e) {
	                System.out.println("❌ Date invalide ! Veuillez réessayer.");
	            }
	        }

	        Integer prix = lireInt("Prix :");
	        if (prix == null) return null;

	        Float kmTotale = lireFloat("Kilométrage total :");
	        if (kmTotale == null) return null;
	        
	        float kmr = 100000-kmTotale ;
	        if (kmr<0) {
	        	kmr=0 ;
	        }
	        Vehicule v = new Vehicule(type, immatricule, dateService, prix, kmTotale,kmr);
	        System.out.println("📌 Km restants avant visite : " + v.getNbkmrestant());
	        return v ;
	    }
	}


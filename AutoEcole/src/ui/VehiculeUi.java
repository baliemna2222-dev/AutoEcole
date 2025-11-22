package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Echeance;
import entities.Reparation;
import entities.TypeEcheance;
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
	    	List<Echeance> l=new ArrayList<>() ;
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
	        for (int i = 0; i < 4; i++) {
	            TypeEcheance te = null;
	            LocalDate d = null;
	            float k=0 ;
	            switch(i) {
	                case 0:
	                    te = TypeEcheance.VIGNETTE;
	                    d = LocalDate.of(LocalDate.now().getYear(), 1, 31); 
	                    break;
	                case 1:
	                    te = TypeEcheance.VISITE_TECHNIQUE;
	                    int y =LocalDate.now().getYear()-dateService.getYear();
	                    if (y>=3) {
	                    	if(y%2==0) {
	                        d= LocalDate.of(LocalDate.now().getYear()+1, 1, 1);
	                    	}else {
	                    		d= LocalDate.of(LocalDate.now().getYear(), 1, 1);}
	                    } else if (y >= 10) {
	                    	 d= LocalDate.of(LocalDate.now().getYear()+1, 1, 1);
	                    }
	                    break;
	                case 2:
	                    te = TypeEcheance.VIDANGE;
	                    k=kmr;
	                    break;
	                case 3:
	                    te = TypeEcheance.ASSURANCE;
	                    d = LocalDate.of(LocalDate.now().getYear(), dateService.getMonth(), dateService.getDayOfMonth()); 
	                    break;
	            }
	            Echeance c= new Echeance(te);
	            c.setDateLimite(d);
	            c.setKmRestant(k);
	            l.add(c);
	        }
	        
	        
	    
	        
	        Vehicule v = new Vehicule(type, immatricule, dateService, prix, kmTotale,kmr,l);
	        return v ;
	    }
	    
	    public Reparation saisirReparation(int immatricule) {
	    	System.out.println("\n===== SAISIE RÉPARATION =====");
	    	
	        LocalDate date = null;
	        while (date == null) {
	            System.out.print("Date de la réparation : ");
	            String input = sc.next().trim();
	            if (input.equalsIgnoreCase("q")) return null;
	            try {
	                date = LocalDate.parse(input);
	            } catch (Exception e) {
	                System.out.println("❌ Date invalide !");
	            }
	        }
	        
	        sc.nextLine(); 
	        String description = "";
	        while (description.isEmpty()) {
	            System.out.print("Description de la réparation : ");
	            description = sc.nextLine().trim();
	            if (description.equalsIgnoreCase("q")) return null;
	            if (description.isEmpty())
	                System.out.println("⚠ Champ obligatoire !");
	        }

	       
	        Float montant = null;
	        while (montant == null) {
	            System.out.print("Montant de la facture : ");
	            String input = sc.next();
	            if (input.equalsIgnoreCase("q")) return null;
	            try {
	                montant = Float.valueOf(input);
	                if (montant < 0) {
	                    System.out.println("❌ Valeur négative interdite !");
	                    montant = null;
	                }
	            } catch (Exception e) {
	                System.out.println("❌ Donnée invalide !");
	            }
	        }

	        sc.nextLine();
	        System.out.print("Chemin du fichier scanné (preuve) [laisser vide si aucune] : ");
	        String preuve = sc.nextLine().trim();
	        if (preuve.equalsIgnoreCase("q")) return null;
	        if (preuve.isEmpty()) preuve = "Aucune preuve jointe";

	        Reparation r= new Reparation(date, description, montant, preuve);
	        r.setMatricule(immatricule);
	        return r;
	    }
	    
	}


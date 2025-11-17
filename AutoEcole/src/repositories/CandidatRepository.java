package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Candidat;

public class CandidatRepository {
	private List<Candidat> candidats = new ArrayList<>() ;
	
	public void add(Candidat c) {
		candidats.add(c);
		}
	public void getAll() {
        for (int i = 0 ; i<candidats.size();i++) {
        	System.out.println(candidats.get(i));
        	System.out.println("-------------");
        }
    }
	
	
	public Candidat getByCin(int cin) {
        for (Candidat c : candidats) {
            if (c.getCIN() == cin)
                return c;
        }
        return null;
    }
	  public boolean deleteByCin(int cin) {
	        Candidat c = getByCin(cin);
	        if (c != null) {
	            candidats.remove(c);
	            return true;
	        }
	        return false;
	    }
	
	public boolean update(Candidat newCandidat) {
        for (int i = 0; i < candidats.size(); i++) {
            if (candidats.get(i).getCIN() == newCandidat.getCIN()) {
                candidats.set(i, newCandidat);
                return true;
            }
        }
        return false;
    }
	public void display(Candidat c) {
		// TODO Auto-generated method stub
		System.out.println(c);
		
	}
	
}






























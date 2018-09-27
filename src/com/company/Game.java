package com.company;
import java.util.*;

public class Game {

	public static void initialize() {

	}
	
	/*public static void tour(Joueur j) {
		System.out.println(j.getBateaux().elements());
		for (Bateau b : j.getBateaux().elements().) {
			if
		}
		if(j.getBateaux().isEmpty());
	}*/
	
	
    public static void main(String[] args) {
        Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();      
        Croiseur c1 = new Croiseur(2, 3, true);
        Torpilleur t1 = new Torpilleur(5, 8, false);
        SousMarin s1 = new SousMarin(3,6,false);
        Croiseur c2 = new Croiseur(2, 3, true);
        Torpilleur t2 = new Torpilleur(5, 8, false);
        SousMarin s2 = new SousMarin(3,6,false);
        J1.ajouterbateau(c1);
        J1.ajouterbateau(t1);
        J1.ajouterbateau(s1);
        J2.ajouterbateau(c2);
        J2.ajouterbateau(t2);
        J2.ajouterbateau(s2);
        //tour(J1);
        
        J1.tir(2,3,J2);
        System.out.println(J1);
        c1.avancer(2, 3);
        System.out.println("_____________");
        System.out.println(J1);
       
        
        //J1.getBateaux().el


    }
}

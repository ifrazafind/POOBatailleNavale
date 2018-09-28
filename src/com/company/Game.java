package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
	

	public static void initialyze(Joueur[] js) {
		for(int i=0; i<js.length;i++) {
			setup(js[i],i+1);
		}
	}
	
	//
	public static void setup(Joueur j,int nb) {
		System.out.print("Joueur "+nb+"\n");

        j.montrergrille();

        System.out.print("Placer PorteAvion\n");
        PorteAvion p = new PorteAvion(j.lignebateau(), j.colonebateau(), j.orienterbateau());
        j.ajouterbateau(p);
        j.montrergrille();

        
        System.out.print("Placer Croiseur\n");
        Croiseur c = new Croiseur(j.lignebateau(), j.colonebateau(), j.orienterbateau());
        j.ajouterbateau(c);
        j.montrergrille();

        System.out.print("Placer ContreTorpilleur\n");
        ContreTorpilleur ct = new ContreTorpilleur(j.lignebateau(), j.colonebateau(), j.orienterbateau());
        j.ajouterbateau(ct);
        j.montrergrille();

        System.out.print("Placer SousMarin\n");
        SousMarin s = new SousMarin(j.lignebateau(), j.colonebateau(), j.orienterbateau());
        j.ajouterbateau(s);
        j.montrergrille();

        System.out.print("Placer Torpilleur\n");
        Torpilleur t = new Torpilleur(j.lignebateau(), j.colonebateau(), j.orienterbateau());
        j.ajouterbateau(t);
        j.montrergrille();

        System.out.flush();
	}
	
	public static void deplacement(Joueur j) {
		boolean avance=false;
		Scanner sc = new Scanner(System.in);
		Bateau b = j.choixbateau();
		System.out.println(b);
		System.out.print("où deplacer le bateau (2 cases de deplacement max):");
		while(!avance) {
			System.out.print("X : ");
			int x = sc.nextInt();
			System.out.print("Y : ");
			int y =sc.nextInt();
			avance =b.avancer(x, y);
		}
		j.modifiergrille(b);
	}
	
	public static boolean tirer(Joueur[] js, int i) {
		Scanner sc = new Scanner(System.in);
		System.out.print("où tirer :");
		System.out.print("X : ");
		int x = sc.nextInt();
		System.out.print("Y : ");
		int y =sc.nextInt();
		return js[i].tir(x, y, js[(i+1)%2]);
	}
	
	public static void testDetruit(Joueur j) {
		 for(int i =0;i<j.getBateaux().size();i++){
	            if(j.getBateaux().get(i).estdetruit()) {
					System.out.println("Votre "+j.getBateaux().get(i).toString().split("\\(")[0]+" coulé!");
					j.enleverbateau(j.getBateaux().get(i));
	            }
		 }
	}
	
    public static void main(String[] args) throws InterruptedException, IOException {
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        Joueur tableauJoueur[] = {joueur1,joueur2};
    	initialyze(tableauJoueur);
    	boolean touche=true;
    	
    	while(true) {
    		for(int i =0;i<tableauJoueur.length;i++) {
    			System.out.println("Joueur :"+(i+1));
    			testDetruit(tableauJoueur[i]);
    			if(tableauJoueur[i].aPerdu()) {
    				System.out.println("VICTOIRE DU JOUEUR "+(i+1)%2);
    				return;
    			}	
    			tableauJoueur[i].montrergrille();
    			System.out.println(tableauJoueur[i]);
    			if(!touche) {
    				System.out.println("phase de déplacement");
    				deplacement(tableauJoueur[i]);
    			}
				System.out.println("phase de tir");
				touche = tirer(tableauJoueur,i);
				if(touche) {
					System.out.println("touché!");
				}else {
					System.out.println("raté");
				}
    		}	
    	}
/*
 * Bateau bateauselec = tableauJoueur[i].choixbateau();
 
        Joueur tableauJoueur[] = {joueur1};

        for (int i = 0; i<tableauJoueur.length;i++) {

            
           

            

        	
        	
        	
            System.out.println("Entrer les coordonnees de tirs");
            System.out.print("X : ");
            Scanner sc = new Scanner(System.in) ;
            int x = sc.nextInt();
            System.out.print("Y : ");
            int y = sc.nextInt();
            j.tir(y,x,j);
            System.out.println(j);
            TimeUnit.SECONDS.sleep(2);

        /*J1.tir(2,3,J2);
        System.out.println(J2);
        c1.avancer(3, 4);
        System.out.println("_____________");
        System.out.println(J1);


        }  //J1.getBateaux().el
    }*/
    }
}

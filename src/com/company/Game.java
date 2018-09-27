package com.company;

import java.util.concurrent.TimeUnit;


public class Game {

    public static void initialize() {

	}
	
    public static void main(String[] args) throws InterruptedException {

        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        Joueur tableauJoueur[] = {joueur1, joueur2};

        for (int i = 0; i<tableauJoueur.length;i++) {

            System.out.print("Joueur " + i + "\n");

            tableauJoueur[i].montrergrille();

            System.out.print("Placer PorteAvion\n");
            PorteAvion p = new PorteAvion(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(p);
            tableauJoueur[i].montrergrille();

            System.out.print("Placer Croiseur\n");
            Croiseur c = new Croiseur(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(c);
            tableauJoueur[i].montrergrille();

            System.out.print("Placer ContreTorpilleur\n");
            ContreTorpilleur ct = new ContreTorpilleur(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(ct);
            tableauJoueur[i].montrergrille();

            System.out.print("Placer SousMarin\n");
            SousMarin s = new SousMarin(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(s);
            tableauJoueur[i].montrergrille();

            System.out.print("Placer Torpilleur\n");
            Torpilleur t = new Torpilleur(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(t);
            tableauJoueur[i].montrergrille();


            TimeUnit.SECONDS.sleep(2);

        /*Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();
        System.out.println("Type de bateaux : ");
        System.out.println(" 1 : ContreTorpilleur \n 2 : Croiseur \n 3 : Porte Avion \n 4 : Sous-Marin \n 5 : Torpilleur \n");
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
        System.out.println(J2);
        c1.avancer(3, 4);
        System.out.println("_____________");
        System.out.println(J1);*/


            //J1.getBateaux().el

        }
    }
}

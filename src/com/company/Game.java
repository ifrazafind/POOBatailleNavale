package com.company;

import java.util.concurrent.TimeUnit;


public class Game {
	
    public static void main(String[] args) throws InterruptedException {

        Joueur joueur1 = new Joueur();
       // Joueur joueur2 = new Joueur();

        Joueur tableauJoueur[] = {joueur1};

        for (int i = 0; i<tableauJoueur.length;i++) {

            System.out.print("Joueur 1\n");

            joueur1.montrergrille();

            System.out.print("Placer PorteAvion\n");
            PorteAvion p = new PorteAvion(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(p);
            tableauJoueur[i].montrergrille();

            System.out.print("Placer Croiseur\n");
            Croiseur c = new Croiseur(tableauJoueur[i].lignebateau(), tableauJoueur[i].colonebateau(), tableauJoueur[i].orienterbateau());
            tableauJoueur[i].ajouterbateau(c);
            tableauJoueur[i].montrergrille();

            /*System.out.print("Placer ContreTorpilleur\n");
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
            tableauJoueur[i].montrergrille();*/


            TimeUnit.SECONDS.sleep(2);

        /*J1.tir(2,3,J2);
        System.out.println(J2);
        c1.avancer(3, 4);
        System.out.println("_____________");
        System.out.println(J1);*/


        }  //J1.getBateaux().el
    }
}

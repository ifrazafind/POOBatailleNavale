package com.company;

public class Main {

    public static void main(String[] args) {
        Joueur J = new Joueur();
        Croiseur c = new Croiseur(2, 3, true);
        Torpilleur t = new Torpilleur(5, 8, false);
        SousMarin s = new SousMarin(3,6,false);
        J.ajouterbateau(c);
        J.ajouterbateau(t);
        J.ajouterbateau(s);
        J.coup(2,3);
        System.out.println(J);
    }
}

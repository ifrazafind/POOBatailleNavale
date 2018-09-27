package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Joueur {
    private Vector<Bateau> bateaux = new Vector<>();

	public Vector<Bateau> getBateaux() {
		return bateaux;
	}


    private int[][] grille = new int[10][10];

    public Joueur() {
    }

    public int lignebateau() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une ligne :");
        int str = sc.nextInt();
        System.out.println("Vous avez saisi : " + str);
        return str;
    }

    public int colonebateau() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une colone :");
        int str = sc.nextInt();
        System.out.println("Vous avez saisi : " + str);
        return str;
    }

    public boolean orienterbateau() {
        Scanner sc = new Scanner(System.in);
        System.out.println("il est horizontal ? true/false :");
        String str2 = sc.next();
        System.out.println("Vous avez saisi : " + str2);
        boolean bool = false;
        if (str2.equals("true")) {
            bool = true;
        }

        return bool;
    }

    public void montrergrille() {
        System.out.print("  0 1 2 3 4 5 6 7 8 9\n");

        for(int i = 0; i < this.grille.length; ++i) {
            System.out.print(i + " ");

            for(int j = 0; j < this.grille[i].length; ++j) {
                System.out.print(this.grille[i][j] + " ");
            }

            System.out.println();
        }

    }

    public void ajouterbateau(Bateau b) {
        if (!this.bateaux.contains(b)) {
            this.bateaux.add(b);
        }

    }

    public void enleverbateau(Bateau b) {
        if (this.bateaux.contains(b)) {
            this.bateaux.remove(b);
        }

    }

    public void tir(int x, int y, Joueur j) {
        for(int i = 0; i < j.bateaux.size(); ++i) {
            ((Bateau)j.bateaux.get(i)).touche(x, y);
        }

    }

    public String toString() {
        String res = "";

        for(int i = 0; i < this.bateaux.size(); ++i) {
            res = res + ((Bateau)this.bateaux.get(i)).toString() + '\n';
        }

        return res;
    }
    
}

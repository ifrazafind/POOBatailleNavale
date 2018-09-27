package com.company;

import java.util.Vector;

public class Joueur {
    private Vector<Bateau> bateaux = new Vector<>();

	public Vector<Bateau> getBateaux() {
		return bateaux;
	}

	public Joueur() {
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

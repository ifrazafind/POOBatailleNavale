package com.company;

public class Bateau {
    private boolean horizontal;
    private boolean tirHorizontal;
    private Element[] element;
    private int portee;

    public Bateau(int x, int y, boolean h, int taille, int p, boolean th) {
        this.horizontal = h;
        this.portee = p;
        this.tirHorizontal = th;
        this.element = new Element[taille];
        int i;
        if (this.horizontal) {
            for (i = 0; i < taille; ++i) {
                this.element[i] = new Element(x + i, y);
            }
        } else {
            for (i = 0; i < taille; ++i) {
                this.element[i] = new Element(x, y + i);
            }
        }

    }

    public void avancer(int x, int y) {
        for (int i = 0; i < this.element.length; ++i) {
            this.element[i].avancer(x, y);
        }

    }

    public void touche(int x, int y) {
        for (int i = 0; i < this.element.length; ++i) {
            this.element[i].touche(x, y);
        }

    }

    public boolean estdetruit() {
        boolean res = true;

        for (int i = 0; i < this.element.length && res; ++i) {
            res = res && this.element[i].isDetruit();
        }

        return res;
    }

    public String toString() {
        String s = "(" + this.element[0].getabcisse() + "," + this.element[0].getordonnee() + ")";

        for (int i = 0; i < this.element.length; ++i) {
            s = s + this.element[i].toString();
        }

        return s;
    }
}

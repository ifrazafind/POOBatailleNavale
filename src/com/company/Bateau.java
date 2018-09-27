package com.company;

public class Bateau {
    private boolean horizontal;
    private boolean tirHorizontal;
    private Element[] element;
    private int portee;
    private int posX;
    private int posY;
    private int longueur;
    protected int nb;
    private String initial ;

    public Bateau(int x, int y, boolean h, int taille, int p, String init) {
        this.horizontal = h;
        this.portee = p;
        this.longueur = taille ;
        this.element = new Element[taille];
        this.initial = init ;
        this.posX = x ;
        this.posY = y ;
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
    	char hor = 'h';
    	if(!horizontal) {
    		hor= 'v';
    	}
        String s = "(" + this.element[0].getabcisse() + "," + this.element[0].getordonnee() + "," + hor +")";

        for (int i = 0; i < this.element.length; ++i) {
            s = s + this.element[i].toString();
        }

        return s;
    }


    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    public String getInit() {
        return this.initial;
    }

    public boolean getOrientation() {
        return this.horizontal;
    }

    public int getTaille() {
        return this.longueur;
    }

    public void setX(int newX) {
        this.posX = newX;
    }

    public void setY(int newY) {
        this.posY = newY;
    }
}

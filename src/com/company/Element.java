package com.company;

import jdk.jfr.Unsigned;

public class Element {
    private int abcisse;
    private int ordonnee;
    private boolean detruit;

    public Element(int i, int j) {
        this.abcisse = i;
        this.ordonnee = j;
        this.detruit = false;
    }

    public int getabcisse() {
        return this.abcisse;
    }

    public int getordonnee() {
        return this.ordonnee;
    }

    public void touche(int i, int j) {
        if (this.abcisse == i && this.ordonnee == j && !this.detruit) {
            this.detruit = true;
        }

    }

    public void avancer(int i, int j) {
    	int dx = 0, dy=0, x=0, y=0;
    	if(abcisse-i<=2 && abcisse-i>=-2 && ordonnee-j<=2 && ordonnee-j>=-2) {
    		dx = abcisse-i;
    		dy = ordonnee-j;
    	}
    	if(dx<0)
    		x =dx*(-1);
    	if(dy<0)
    		y=dy*(-1);

    	if(x+y<=2) {
    		this.abcisse -= dx;
            this.ordonnee -= dy;
    	}
    }

    public boolean isDetruit() {
        return this.detruit;
    }

    public String toString() {
        String s = "";
        if (!this.detruit) {
            s = "O";
        } else if (this.detruit) {
            s = "X";
        }

        return s;
    }
}

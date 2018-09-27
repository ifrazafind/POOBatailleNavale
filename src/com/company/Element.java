package com.company;

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
        if (i >= -2 && i <= 2 && j >= -2 && j <= 2) {
            this.abcisse += i;
            this.ordonnee += j;
        }

    }

    public boolean isDetruit() {
        return this.detruit;
    }

    public String toString() {
        String s = "";
        if (!this.detruit) {
            s = "o";
        } else if (this.detruit) {
            s = "x";
        }

        return s;
    }
}

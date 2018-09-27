package com.company;

public class Croiseur extends Bateau {
    public Croiseur(int x, int y, boolean h) {
        super(x, y, h, 4, 2, !h);
    }

    public String toString() {
        return "croiseur" + super.toString();
    }
}

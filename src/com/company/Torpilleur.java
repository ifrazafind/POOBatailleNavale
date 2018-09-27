package com.company;

public class Torpilleur extends Bateau {
    public Torpilleur(int x, int y, boolean h) {
        super(x, y, h, 2, 5, h);
    }

    public String toString() {
        return "Torpilleur" + super.toString();
    }
}

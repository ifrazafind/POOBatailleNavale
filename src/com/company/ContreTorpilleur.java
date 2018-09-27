package com.company;

public class ContreTorpilleur extends Bateau {
    public ContreTorpilleur(int x, int y, boolean h) {
        super(x, y, h, 3, 2, h);
    }

    public String toString() {
        return "Contre torpilleur" + super.toString();
    }
}

package com.company;

public class PorteAvion extends Bateau {
    public PorteAvion(int x, int y, boolean h) {
        super(x, y, h, 5, 2, !h);
    }

    public String toString() {
        return "Porte avion" + super.toString();
    }
}

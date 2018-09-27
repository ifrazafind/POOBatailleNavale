package com.company;

public class SousMarin extends Bateau {
    public SousMarin(int x, int y, boolean h) {
        super(x, y, h, 3, 4, h);
    }

    public String toString() {
        return "Sous marin" + super.toString();
    }
}

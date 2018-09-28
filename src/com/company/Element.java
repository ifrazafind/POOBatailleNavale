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
    
    public void setAbcisse(int abcisse) {
		this.abcisse = abcisse;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

    public boolean touche(int i, int j) {
        if (this.abcisse == j && this.ordonnee == i && !this.detruit) {
            this.detruit = true;
            return true;
        }
        return false;

    }

    public boolean avancer(int dx, int dy) {
    	int x=0, y=0;
    	if(dx<0)
    		x =dx*(-1);
    	if(dy<0)
    		y=dy*(-1);

    	if(x+y<=2) {
    		this.abcisse += dy;
            this.ordonnee += dx;
            return true;
    	}
    	return false;
    }

    public boolean isDetruit() {
        return this.detruit;
    }

    public String toString() {
        String s = "";
        s="["+this.ordonnee+"/"+this.abcisse+"]";
        if (!this.detruit) {
            s += "O";
        } else if (this.detruit) {
            s += "X";
        }

        return s;
    }
}

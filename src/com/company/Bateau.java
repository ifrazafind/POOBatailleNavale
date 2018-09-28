package com.company;

public class Bateau {
    private boolean horizontal;
    private boolean tirHorizontal;
    private Element[] element;
    public Element[] getElement() {
		return element;
	}

	private int portee;
    protected int nb;
    private String initial ;

    public Bateau(int x, int y, boolean h, int taille, int p, String init) {
        this.horizontal = h;
        this.portee = p;
        this.element = new Element[taille];
        this.initial = init ;
       
        if (this.horizontal) {
            for (int i = 0; i < taille; ++i) {
                this.element[i] = new Element(y + i, x);
            }
        } else {
            for (int i = 0; i < taille; ++i) {
                this.element[i] = new Element(y, x + i);
            }
        }
    }

    public boolean avancer(int x, int y) {
    	int dx, dy;
    	if(x>this.element[0].getordonnee()) {
    		dx= this.element[0].getordonnee()+x;
    	}else {
    		dx = this.element[0].getordonnee()-x;
    	}
    	
    	if(x>this.element[0].getabcisse()) {
    		dy= this.element[0].getabcisse()+y;
    	}else {
    		dy = this.element[0].getabcisse()-y;
    	}
    	
    	int compte = 0;
        for(int i = 0; i < this.element.length; ++i) {
            boolean test = false;
        	 test = this.element[i].avancer(dx, dy);
        	 if(test)
        		 compte+=1;
        }
        if(compte==this.element.length)
        	return true;
        return false;
    }

    public boolean touche(int x, int y) {
    	boolean touche= false;
        for (int i = 0; i < this.element.length; ++i) {
        	touche = this.element[i].touche(x, y);
        	if(touche)
        		return touche;
        }
        return touche;
    }

    public boolean estdetruit() {
        int vie=2;
        for (int i = 0; i < this.element.length && vie>0; ++i) {
            if(this.element[i].isDetruit())
            	vie-=1;
        }
        if(vie==0)
        	return true;
        return false;
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
        return this.element[0].getordonnee();
    }

    public int getY() {
        return this.element[0].getabcisse();
    }

    public String getInit() {
        return this.initial;
    }

    public boolean getOrientation() {
        return this.horizontal;
    }

    public int getTaille() {
        return this.element.length;
    }

    public void setX(int newX) {
        //this.element[0].setAbcisse(newX);
        if (this.horizontal) {
            for (int i = 0; i < this.element.length; ++i) {
                this.element[i].setOrdonnee(newX);
            }
        } else {
            for (int i = 0; i < this.element.length; ++i) {
                this.element[i].setOrdonnee(newX+i);
            }
        }
        
    }

    public void setY(int newY) {
        //this.element[0].setOrdonnee(newY);
        if (this.horizontal) {
            for (int i = 0; i < this.element.length; ++i) {
                this.element[i].setAbcisse(newY+i);
            }
        } else {
            for (int i = 0; i < this.element.length; ++i) {
                this.element[i].setAbcisse(newY);
            }
        }
    }
}

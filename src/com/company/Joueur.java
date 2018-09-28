package com.company;


import java.util.Scanner;
import java.util.Vector;

public class Joueur {
    private Vector<Bateau> bateaux = new Vector<>();

	public Vector<Bateau> getBateaux() {
		return bateaux;
	}


    public String[][] grille = new String[10][10];

    public Joueur() {
    }

    public int lignebateau() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez saisir une ligne :");
        try {
        	int result = sc.nextInt();
            System.out.println("Vous avez saisi : " + result);
            return result;
		} catch (Exception e) {
			System.out.println("entier entre 0 et 9 seulement");
			this.lignebateau();
		} 
		return 0;
    }

    public int colonebateau() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez saisir une colone :");
        try {
        	 int result = sc.nextInt();
             System.out.println("Vous avez saisi : " + result);
             return result;
		} catch (Exception e) {
			System.out.println("entier entre 0 et 9 seulement");
			this.colonebateau();
		}  
        return 0;
    }

    public boolean orienterbateau() {
        Scanner sc = new Scanner(System.in);
        System.out.print("il est horizontal ? true/false :");
        String str2 = sc.next();
        System.out.println("Vous avez saisi : " + str2);
        boolean bool = false;
        if (str2.equals("true")) {
            bool = true;
        }

        return bool;
    }

    public void montrergrille() {
        System.out.print("  0 1 2 3 4 5 6 7 8 9\n");

        for(int i = 0; i < grille.length; ++i) {
            System.out.print(i + " ");
            for(int j = 0; j < grille[i].length; ++j) {
                if (grille[i][j] == null)
                    System.out.print("~ ");
                else
                    System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    public void modifiergrille(Bateau b) {
    	for(int i = 0; i < grille.length; ++i) {
    		for(int j = 0; j < grille[i].length; ++j) {
    			if (grille[i][j] == b.getInit()) {
    				grille[i][j] = null;
    			}
    			for(int k = 0; k<b.getElement().length;k++) {
    				grille[b.getElement()[k].getordonnee()][b.getElement()[k].getabcisse()] = b.getInit();
    			}
    		}
    	}
    }

    public void ajouterbateau(Bateau b) {
        if (!this.bateaux.contains(b)) {
            while (b.getX() + b.getTaille()*(b.getOrientation() ? 0 : 1) > 10 || b.getX() < 0) {
                System.out.println("Position ligne incorrect\n");
                b.setX(this.lignebateau());
            }


            while(b.getY() + b.getTaille()*(b.getOrientation() ? 1 : 0) > 10 || b.getY() < 0) {
                System.out.print("Position colonne incorect\n");
                b.setY(this.colonebateau());
            }
            boolean test = true ;

            int i;
            if (b.getOrientation()== false) {
                for(i = 0; i < b.getTaille(); ++i) {
                    if (grille[b.getX() + i][b.getY()] == null && test)
                        test = true;
                    else {
                        test = false ;
                    }
                }
                if (test == true) {
                    for (i = 0; i < b.getTaille(); ++i) {
                        grille[b.getX() + i][b.getY()] = b.getInit();
                    }
                }
                else {
                    System.out.println("place occupée");
                    b.setX(this.lignebateau());
                    b.setY(this.colonebateau());
                    ajouterbateau(b);
                }
            } else {
                for(i = 0; i < b.getTaille(); ++i) {
                    if (grille[b.getX()][b.getY() + i] == null)
                        test = true;
                    else {
                        test = false ;
                    }
                }
                if (test == true) {
                    for (i = 0; i < b.getTaille(); ++i) {
                        grille[b.getX()][b.getY() + i] = b.getInit();
                    }
                }
                else {
                        System.out.println("place occupée");
                        b.setX(this.lignebateau());
                        b.setY(this.colonebateau());
                        ajouterbateau(b);
                }
            }
            this.bateaux.add(b);
        }

    }
    
    public void enleverbateau(Bateau b) {
        if (this.bateaux.contains(b)) {
            this.bateaux.remove(b);
        }

    }

    public Bateau choixbateau(){
        boolean test = false;
        Bateau selec=null;
        System.out.println("Vos bateaux :");
        for(int i =0;i<bateaux.size();i++){
            System.out.println(bateaux.get(i).toString().split("\\(")[0] +" : "+bateaux.get(i).getInit());

        }

        while(test==false){
            Scanner sc = new Scanner(System.in);
            System.out.print("Quel bateau choisir (donner initiale):");
            String choix = sc.next();

            for(int i =0;i<bateaux.size();i++){
                if (bateaux.get(i).getInit().equals(choix)){
                    selec = bateaux.get(i);
                    test=true;
                }
            }
        }
        return selec;
    }
    
    public boolean tir(int x, int y, Joueur j) {
    	boolean touche=false;
        for(int i = 0; i < j.bateaux.size(); ++i) {
            touche = ((Bateau)j.bateaux.get(i)).touche(x, y);
        }
        return touche;
    }
    
    public boolean aPerdu() {
    	if(bateaux.isEmpty())
    		return true;
    	return false;
    }

    public String toString() {
        String res = "";

        for(int i = 0; i < this.bateaux.size(); ++i) {
            res = res + ((Bateau)this.bateaux.get(i)).toString() + '\n';
        }

        return res;
    }
    
}

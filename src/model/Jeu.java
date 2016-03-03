package model;

import model.Joueurs.Humains.Humains;
import model.Joueurs.IA;
import model.Joueurs.Joueurs;
import org.lwjgl.Sys;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by bobol on 20/11/15.
 */
public class Jeu {

    /* ------------------------------------------------------
    *   Attributs de la classe Jeu                          *
    * ------------------------------------------------------*/

    private Joueurs j1,j2;
    private Plateau plateau;
    private int nbManches;
    public static Scanner sc = new Scanner(System.in);

     /* -----------------------------------------------------*
     *   Constructeur                                        *
     *------------------------------------------------------*/

    public Jeu(Humains h1, Humains h2){
        j1 = h1;
        j2 = h2;
        plateau = new Plateau();
    }

    public Jeu( ) {

    }


    /* -----------------------------------------------------*
    *   Méthodes                                            *
    * ------------------------------------------------------*/
    
    //Fonctions random qui permet de choisir
    public Joueurs choixJoueurCommence(Joueurs j1, Joueurs j2) {
        Random aleatoire;
        // nbJoueur = joueur qui commence
        int nbJoueur;

        aleatoire = new Random();
        // select un nombre entre 1 et 2
        nbJoueur = aleatoire.nextInt(2);
        System.out.println("nbJoueur : " + nbJoueur);
        switch (nbJoueur) {
            // si 0 j1 commence
            case 0 :
                return j1;
            // si 1 j2 commence
            case 1 :
                return j2;
            default:
                break;
        }
        return null;
    }

    //pas utilisée
    public void setFigureJoueur(Joueurs joueurs, int figure){
        joueurs.setFigure(figure);
        if(joueurs == j1){
            switch(figure){
                case 1:
                    j2.setFigure(2);
                    break;
                case 2:
                    j2.setFigure(1);
                    break;
            }
        }
        else{
            switch(figure){
                case 1:
                    j1.setFigure(2);
                    break;
                case 2:
                    j1.setFigure(1);
                    break;
            }
        }
    }
    
    
    // Choisi le joueur qui commence et qui choisi sa figure
    // retourne le joueur qui commence
    /*public Joueurs choixFigureJoueur(Joueurs j1, Joueurs j2) {
        Joueurs joueurs;
        int figure;
        joueurs = choixJoueurCommence(j1,j2);
        System.out.println(joueurs.getNomJoueur() + " vous commencez.");
        System.out.println("Veuillez choisir votre symbole : \npour rond entrez 1 \npour croix entrez 2.");
        figure = sc.nextInt();
        while (figure < 1 || figure > 2) {
            System.out.println("Vous n'avez pas entré le bon chiffre !");
            System.out.println("Veuillez choisir votre symbole : \npour rond entrer 1 \npour croix entrer 2.");
            figure = sc.nextInt();
        }
        setFigureJoueur(joueurs,figure);
        return joueurs;
    }*/

    //pas encore utilisée
    public void nombreManche() {
        int manche;
        manche = new Scanner(System.in).nextInt();
        while (manche % 2 == 1) {
            setManche(manche);
        }
    }
    
    
    //Faire une boucle de jeu (while cdt de victoire est false)
    /*public void jouer(){
        Cases casestemp;
        Joueurs joueur1,joueur2;
        int verif,i,j,k,l,peutJouer;
        joueur1 = choixFigureJoueur(j1,j2);
        if(joueur1 == j1){
            joueur2 = j2;
        }else{
            joueur2 = j1;
        }
        System.out.println("Joueur 1 : \n" + joueur1);
        System.out.println("Joueur 2 : \n" + joueur2);
        //retourne un int pour savoir qui gagne
        verif = plateau.verifVictoireJoueurFigure();
        /*verifVictoireJoueurFigure
        * Boucle de jeu
        *   1) Le joueur qui commence prend un cube
        *   2) choixPossible vérifie toutes les possibilités qu'a le joueur
        *   3) On fait d'abord bouger les pieces pour que le joueur puisse mettre son cube a à i1,j1 qui est un choix valide
        *   4) On place finalement le cube aux coordonnée i1,j1 choisi par le joueur
         */
    /*
        while(verif == 0){
            //tour du joueur 1
            System.out.println("Au tour du joueur 1");
            System.out.println("entrer coordonnée x du premier cube :");
            i =sc.nextInt();
            System.out.println("entrer coordonnée y du premier cube :");
            j = sc.nextInt();
            casestemp = joueur1.verifCube(i,j,plateau);
            while (casestemp == null) {
                System.out.println("entrer un entier pour i :");
                i = sc.nextInt();
                System.out.println("entrer un entier pour j :");
                j = sc.nextInt();
                casestemp = joueur1.verifCube(i,j,plateau);
            }
            System.out.println("casestemp : "+casestemp.getFigure());
            System.out.println("casetemp :" +casestemp.getFigure());
            System.out.println("entrer coordonnée x du deuxième cube :");
            k = sc.nextInt();
            System.out.println("entrer coordonnée y du deuxième cube :");
            l =sc.nextInt();
            // faire un for qui check lequel des choix possible
            plateau.bougerPiece(i,j,k,l);
            peutJouer = joueur1.placerCube(k,l,casestemp,plateau);
            while (peutJouer == 0) {
                System.out.println("entrer coordonnée x du deuxième cube :");
                k = sc.nextInt();
                System.out.println("entrer coordonnée y du deuxième cube :");
                l =sc.nextInt();
                // faire un for qui check lequel des choix possible
                plateau.bougerPiece(i,j,k,l);
                peutJouer = joueur1.placerCube(k,l,casestemp,plateau);
            }
            System.out.println("plateau :"+plateau.getPlateauIJ(k,l).getFigure());

            for ( int m = 0; m < plateau.getDimension_i(); m++) {
                for (int y = 0; y < plateau.getDimension_j(); y++) {
                    System.out.print(plateau.getPlateauIJ(m,y).getFigure() + "|");
                }
                System.out.println("");
            }
            verif = plateau.verifVictoireJoueurFigure();
            if (verif == 1) {
                System.out.println(joueur1.getNomJoueur() + " a Gagné !!!!!!!!!!!");
                return;
            }
            System.out.println("_____________________________");
            System.out.println("Au tour du joueur 2");
            //tour du joueur 2
            System.out.println("entrer un entier pour i :");
            i = sc.nextInt();
            System.out.println("entrer un entier pour j :");
            j = sc.nextInt();
            casestemp = joueur2.verifCube(i,j,plateau);
            while (casestemp == null) {
                System.out.println("entrer un entier pour i :");
                i = sc.nextInt();
                System.out.println("entrer un entier pour j :");
                j = sc.nextInt();
                casestemp = joueur2.verifCube(i,j,plateau);
            }
            System.out.println("casetemp :" +casestemp.getFigure());
            System.out.println("entrer un entier pour k :");
            k = sc.nextInt();
            System.out.println("entrer un entier pour l :");
            l =sc.nextInt();
            plateau.bougerPiece(i,j,k,l);
            peutJouer = joueur2.placerCube(k,l,casestemp,plateau);
            while (peutJouer == 0) {
                System.out.println("entrer un entier pour k :");
                k = sc.nextInt();
                System.out.println("entrer un entier pour l :");
                l =sc.nextInt();
                plateau.bougerPiece(i,j,k,l);
                peutJouer = joueur2.placerCube(k,l,casestemp,plateau);
            }

            for ( int m = 0; m < plateau.getDimension_i(); m++) {
                for (int y = 0; y < plateau.getDimension_j(); y++) {
                    System.out.print(plateau.getPlateauIJ(m,y).getFigure() + "|");
                }
                System.out.println("");
            }
            System.out.println("_____________________________");
            System.out.println("verif = " + verif);
            verif = plateau.verifVictoireJoueurFigure();
        }
        if (verif == 1) {
            System.out.println(joueur1.getNomJoueur() + " a Gagné !!!!!!!!!!!");
        }
        else if (verif == 2) {
            System.out.println(joueur2.getNomJoueur() + " a Gagné !!!!!!!!!!!!");
        }
    }

    /* -----------------------------------------------------*
    *   Méthodes get                                        *
    * ------------------------------------------------------*/
    
    public Joueurs getJ1() {
        return j1;
    }

    public Joueurs getJ2() {
        return j2;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    /* -----------------------------------------------------*
    *   Méthodes set                                         *
    * ------------------------------------------------------*/
    
    public void setManche(int manche) {
        this.nbManches = manche;
    }

    public void setJoueurs(Humains h1, Humains h2){
        j1 = h1;
        j2 = h2;
    }

    public void setJoueurIa(Humains h1, IA ia) {
        j1 = h1;
        j2 = ia;
    }
    
    
    
    

    public static void main(String[] args) {
        Jeu jeu = new Jeu(new Humains("Adam"),new Humains("Clement"));
        for (int i = 0; i < jeu.plateau.getDimension_i(); i++) {
            for (int j = 0; j < jeu.plateau.getDimension_j(); j++) {
                System.out.print(jeu.plateau.getPlateauIJ(i, j).getFigure() + "|");
            }
            System.out.println("");
        }
        System.out.println("_____________________________");
        //jeu.jouer();
    }
}



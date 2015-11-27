package model;

import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by bobol on 20/11/15.
 */
public class Jeu {
    private Joueurs j1,j2;
    private Plateau plateau;

    public Jeu(Humains h1, Humains h2){
        j1 = h1;
        j2 = h2;
        plateau = new Plateau();
    }

    public int chiffreAleatoireJoueur() {
        Random aleatoire;
        int nbaleatoire;

        aleatoire = new Random();
        nbaleatoire = aleatoire.nextInt(2);
        return nbaleatoire;
    }


    public Joueurs choixJoueurCommence(Joueurs j1, Joueurs j2) {
        int nbJoueur;

        nbJoueur = chiffreAleatoireJoueur();
        System.out.println("nbJoueur : " + nbJoueur);
        switch (nbJoueur) {
            case 0 :
                return j1;
            case 1 :
                return j2;
            default:
                break;
        }
        return null;
    }

    public Joueurs choixFigureJoueur(Joueurs j1, Joueurs j2) {
        Joueurs joueurs;
        int figure;
        joueurs = choixJoueurCommence(j1,j2);
        System.out.println(joueurs.getNomJoueur() + " vous commencez.");
        System.out.println("Veuillez choisir votre symbole : \npour rond entrer 1 \npour croix entrer 2.");
        figure = new Scanner(System.in).nextInt();
        if (figure < 1 || figure > 2) {
            System.out.println("Vous n'avez pas entré le bon chiffre !");
        }
        else {
            joueurs.setFigure(figure);
        }
        return joueurs;
    }
}

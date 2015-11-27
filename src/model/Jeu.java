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
    // Choisi le joueur qui commence et qui choisi sa figure
    // retourne le joueur qui commence
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
    //Faire une boucle de jeu (while cdt de victoire est false)
}

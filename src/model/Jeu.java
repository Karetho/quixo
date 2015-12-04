package model;

import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by bobol on 20/11/15.
 */
public class Jeu {
    private Joueurs j1,j2;
    private Plateau plateau;
    private int nbManches;
    public static Scanner sc = new Scanner(System.in);
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
    public Joueurs choixFigureJoueur(Joueurs j1, Joueurs j2) {
        Joueurs joueurs;
        int figure;
        joueurs = choixJoueurCommence(j1,j2);
        System.out.println(joueurs.getNomJoueur() + " vous commencez.");
        System.out.println("Veuillez choisir votre symbole : \npour rond entrer 1 \npour croix entrer 2.");
        figure = sc.nextInt();
        if (figure < 1 || figure > 2) {
            System.out.println("Vous n'avez pas entré le bon chiffre !");
        }
        else {
            setFigureJoueur(joueurs,figure);
        }
        return joueurs;
    }

    public void nombreManche() {
        int manche;
        manche = new Scanner(System.in).nextInt();
        while (manche % 2 == 1) {
            setManche(manche);
        }
    }
    //Faire une boucle de jeu (while cdt de victoire est false)
    public int jouer(){
        List<int[]> choixPossible = new LinkedList<>();
        Joueurs joueur1,joueur2;
        int verif,i,j,k,l;
        joueur1 = choixFigureJoueur(j1,j2);
        if(joueur1 == j1){
            joueur2 = j2;
        }else{
            joueur2 = j1;
        }
        //retourne un int pour savoir qui gagne
        verif = plateau.verifVictoireJoueurFigure();
        /*verifVictoireJoueurFigure
        * Boucle de jeu
        *   1) Le joueur qui commence prend un cube
        *   2) choixPossible vérifie toutes les possibilités qu'a le joueur
        *   3) On fait d'abord bouger les pieces pour que le joueur puisse mettre son cube a à i1,j1 qui est un choix valide
        *   4) On place finalement le cube aux coordonnée i1,j1 choisi par le joueur
         */
        while(verif == 0){
            //tour du joueur 1
            i = sc.nextInt();
            j = sc.nextInt();
            //joueur1.prendreCube(i,j,plateau);
            //choixPossible = plateau.choixPossible(i,j);
            k = sc.nextInt();
            l = sc.nextInt();
            // faire un for qui check lequel des choix possible
            //plateau.bougerPiece(i,j,k,l);
            joueur1.placerCube(k,l);
            //tour du joueur 2
            i = sc.nextInt();
            j = sc.nextInt();
            //joueur2.prendreCube(i,j,plateau);
            //choixPossible = plateau.choixPossible(i,j);
            k = sc.nextInt();
            l = sc.nextInt();
            //plateau.bougerPiece(i,j,k,l);
            joueur2.placerCube(k,l);
        }
        return verif;
    }

    public void setManche(int manche) {
        this.nbManches = manche;
    }
}

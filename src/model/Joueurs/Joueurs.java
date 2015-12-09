package model.Joueurs;

import model.Cases;
import model.Plateau;

/**
 * Created by Skygix on 12/11/2015.
 */
public abstract class Joueurs {

    //type du figure du joueur (rond, croix) rond = 1 croix = 2
    protected int figure;

    //Nom du joueur
    protected String nomJoueur;

    //ID du joueur : 0 = humain | 1 = bot
    protected int typeId;

    public Joueurs(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public  abstract Cases prendreCube(int i, int j, Plateau plateau);

    public  abstract void placerCube(int i, int j,Cases cases, Plateau plateau);

    public String getNomJoueur() { return nomJoueur;}

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }


    public abstract void changerFigure();

    public int getFigure() {
        return figure;
    }
}

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

    //False si le joueur n'a pas joué
    protected boolean dejaJoue;

    public Joueurs(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public  abstract Cases prendreCube(int i, int j, Plateau plateau, Cases cases);

    public  abstract int placerCube(int i, int j,Cases cases, Plateau plateau,Joueurs joueursAdverse);

    public abstract Cases verifCube(int i, int j, Plateau plateau);

    public String getNomJoueur() { return nomJoueur;}

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public void setDejaJoue(boolean dejaJoue) {
        this.dejaJoue = dejaJoue;
    }

    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }

    public abstract void changerFigure();

    public int getFigure() {
        return figure;
    }

    public boolean getDejaJoue() {
        return dejaJoue;
    }
}

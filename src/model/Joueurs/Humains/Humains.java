package model.Joueurs.Humains;


import model.Joueurs.Joueurs;

/**
 * Created by Skygix on 12/11/2015.
 */
public class Humains extends Joueurs {

    public Humains() {
        super("Humain");
        figure = 0;
    }

    public Humains(String s) {
        super(s);
        figure = 0;
    }
    // prends une cases de coordonnées (i,j) et supprime la case a cet emplacement
    @Override
    public void prendreCube(int i, int j) {

    }
    // place une case sur une coordonées (i,j)
    @Override
    public void placerCube(int i, int j) {

    }
    // décale les autres cases pour remplir l'espace vide
    @Override
    public void bougerPiece(int i, int j) {

    }

    public void setFigure(int figure){this.figure =figure;}

    public String getNomJoueur() { return super.getNomJoueur();}

    public void setNomJoueur(String nomJoueur) { super.setNomJoueur(nomJoueur); }

    @Override
    public void changerFigure() {

    }
}

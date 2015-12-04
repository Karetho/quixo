package model.Joueurs.Humains;


import model.Cases;
import model.Joueurs.Joueurs;
import model.Plateau;

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
    public Cases prendreCube(int i, int j, Plateau plateau) {
        Cases casestemp = new Cases(); //cases temporaire qui va recevoir les attributs de la case de coordonées (i,j)
        casestemp.setFigure( plateau.getPlateauIJ(i,j).getFigure());
        plateau.setPlateauIJ(i,j,3);
        return casestemp;

    }
    // place une case sur une coordonées (i,j)
    @Override
    public void placerCube(int i1, int j1) {

    }

    public void setFigure(int figure){this.figure =figure;}

    public String getNomJoueur() { return super.getNomJoueur();}

    public void setNomJoueur(String nomJoueur) { super.setNomJoueur(nomJoueur); }

    @Override
    public void changerFigure() {

    }
}

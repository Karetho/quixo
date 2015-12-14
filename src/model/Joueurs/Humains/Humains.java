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
    public Cases prendreCube(int i, int j, Plateau plateau,Cases casestemp) {
        casestemp.setFigure( plateau.getPlateauIJ(i,j).getFigure());
        plateau.setPlateauIJ(i,j,3);
        return casestemp;

    }
    // place une case sur une coordonées (i,j)
    /*
    *  TODO : Méthode a refaire on peut jouer n'importe ou on veux il faut juste voir le choix de coupPossible
    *  Utiliser la méthode dans le plateau de choixPossible pour voir si c'est possible
    */
    @Override
    public int placerCube(int i1, int j1, Cases cases, Plateau plateau,Joueurs joueursAdverse) {
        for (int i = 0; i < plateau.getDimension_i(); i++) {
            for (int j = 0; j < plateau.getDimension_j(); j++) {
                if (plateau.getPlateauIJ(i,j).getFigure() == 3) {
                    plateau.getPlateauIJ(i,j).setFigure(0);
                }
            }
        }
       if (plateau.getPlateauIJ(i1,j1).getFigure() == 0 || plateau.getPlateauIJ(i1,j1).getFigure() == this.getFigure()) {
           plateau.getPlateauIJ(i1, j1).setFigure(cases.getFigure());
           return 1;
       }
        else {
           System.out.println("Vous ne pouvez pas jouer ici !!!!!!!!");
           return 0;
       }
    }

    @Override
    public Cases verifCube(int i, int j, Plateau plateau) {
        Cases casestemp = new Cases(); //cases temporaire qui va recevoir les attributs de la case de coordonées (i,j)
        if (plateau.getPlateauIJ(i,j).getFigure() == 0) {
            plateau.getPlateauIJ(i,j).setFigure(this.figure);
            casestemp = prendreCube(i,j,plateau,casestemp);
            return casestemp;
        }
        else if (plateau.getPlateauIJ(i,j).getFigure() == this.figure) {
            casestemp = prendreCube(i, j, plateau,casestemp);
            return casestemp;
        }
        else {
            System.out.println("Cette case n'est pas neutre et ne vous appartient pas !");
            return null;
        }
    }


    public void setFigure(int figure){this.figure =figure;}

    public String getNomJoueur() { return super.getNomJoueur();}

    public void setNomJoueur(String nomJoueur) { super.setNomJoueur(nomJoueur); }

    @Override
    public void changerFigure() {

    }
}

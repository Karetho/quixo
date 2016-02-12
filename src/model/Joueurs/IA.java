package model.Joueurs;

import model.Cases;
import model.Plateau;
import model.Joueurs.Joueurs;

/**
 * Created by Bobol on 10/02/2016.
 */
public class IA extends Joueurs {

    public IA() {
        super("IA");
        figure =2;
        typeId= 1;
    }

    @Override
    public Cases prendreCube(int i, int j, Plateau plateau, Cases casestemp) {
        if(plateau.getPlateauIJ(i,j).getFigure() == 0){
            casestemp.setFigure(figure);
        }else{
            casestemp.setFigure( plateau.getPlateauIJ(i,j).getFigure());
        }
        plateau.setPlateauIJFigure(i,j,3);
        return casestemp;
    }

    @Override
    public void placerCube(int i, int j, Cases cases, Plateau plateau) {
        plateau.getPlateauIJ(i, j).setFigure(cases.getFigure());
    }

    @Override
    public Cases verifCube(int i, int j, Plateau plateau) {
        Cases casestemp = new Cases(); //cases temporaire qui va recevoir les attributs de la case de coordonées (i,j)
        if (plateau.getPlateauIJ(i,j).getFigure() == 0) {
            plateau.getPlateauIJ(i,j).setFigure(2);
            casestemp = prendreCube(i,j,plateau,casestemp);
            return casestemp;
        }
        else if (plateau.getPlateauIJ(i,j).getFigure() == 2) {
            casestemp = prendreCube(i, j, plateau,casestemp);
            return casestemp;
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void setFigure(int figure) {
        this.figure = figure;
    }
}

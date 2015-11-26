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

    @Override
    public void prendreCube(int i, int j) {

    }

    @Override
    public void placerCube(int i, int j) {

    }

    @Override
    public void bougerPiece(int i, int j) {

    }

    public void setFigure(int figure){this.figure =figure;}

    public String getNomJoueur() { return super.getNomJoueur();}

    public void setNomJoueur(String nomJoueur) { super.setNomJoueur(nomJoueur); }
}

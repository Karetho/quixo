package model;

import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;

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
}

package controller;

import model.Jeu;
import model.Joueurs.Joueurs;
import model.Plateau;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.command.Control;


/**
 * Created by Roland on 12-Dec-15.
 */
public class ControlMenu {
    private Jeu jeu;
    int x,y;
    public ControlMenu(Jeu jeu){
        this.jeu = jeu;
    }
    public void choisirFigure(){
        // On prends les coordonnées en x et y du click de la souris
        // x = axe des i dans le plateau niveau model
        // y = axe des j dans le plateau niveau model
        Joueurs joueur = jeu.choixFigureJoueur(jeu.getJ1(), jeu.getJ2());
        if (joueur == jeu.getJ1()) {
            jeu.getJ2().setDejaJoue(true);
        } else if (joueur == jeu.getJ2()) {
            jeu.getJ1().setDejaJoue(true);
        }
    }
}

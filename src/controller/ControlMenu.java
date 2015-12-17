package controller;

import model.Jeu;
import model.Joueurs.Joueurs;
import model.Plateau;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.state.StateBasedGame;
import view.Jeu_v;


/**
 * Created by Roland on 12-Dec-15.
 */
public class ControlMenu {
    private Jeu jeu;
    int x,y;
    public ControlMenu(Jeu jeu){
        this.jeu = jeu;
    }
    public void choixFigure(int x, int y,Joueurs joueur,StateBasedGame game){
        if((x > 150 && x < 250) && (y > 300 && y < 400)){
            if (joueur == jeu.getJ1()) {
                jeu.getJ2().setFigure(2);;
            } else if (joueur == jeu.getJ2()) {
                jeu.getJ1().setFigure(2);
            }
            joueur.setFigure(1);
            game.enterState(Jeu_v.ID);
        }
        else if((x > 400 && x < 500) && (y > 300 && y < 400)){
            if (joueur == jeu.getJ1()) {
                jeu.getJ2().setFigure(1);;
            } else if (joueur == jeu.getJ2()) {
                jeu.getJ1().setFigure(1);
            }
            joueur.setFigure(2);
            game.enterState(Jeu_v.ID);
        }
    }
    public void choisirFigure(GameContainer gc, StateBasedGame game,Joueurs joueur){
        Input input = gc.getInput();
        // On prends les coordonnées en x et y du click de la souris
        x = input.getMouseX();
        y = input.getMouseY();
        // x = axe des i dans le plateau niveau model
        // y = axe des j dans le plateau niveau model
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            choixFigure(x,y,joueur,game);
            if (joueur == jeu.getJ1()) {
                jeu.getJ2().setDejaJoue(true);
                jeu.getJ1().setDejaJoue(false);
            } else if (joueur == jeu.getJ2()) {
                jeu.getJ1().setDejaJoue(true);
                jeu.getJ2().setDejaJoue(false);
            }
        }
    }
}

package controller;

import model.Jeu;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import view.Fenetre;

/**
 * Created by Roland on 04-Dec-15.
 */
public class ControlPlateau {
    private Jeu jeu;
    private Plateau plateau;
    private Fenetre fen;
    int x,y;

    public ControlPlateau(Plateau plateau, Jeu jeu) throws SlickException {
        this.plateau = plateau;
        this.jeu = jeu;
    }
    public void debutPartie(GameContainer gc){
        Input input = gc.getInput();
    }
    public void clickCases(GameContainer gc) throws SlickException {
        Input input = gc.getInput();
        // On prends les coordonnées en x et y du click de la souris
        // x = axe des i dans le plateau niveau model
        // y = axe des j dans le plateau niveau model
        x = input.getMouseX();
        y = input.getMouseY();
        if((x > 100 && x < 600) && (y > 100 && y < 600)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                // notre plateau niveau vu commence a 100 et fini a 600 d'ou le -100
                x-=100;
                y-=100;
                // On prends l'arrondi au minimum de la division de x/100 et de y/100
                if (jeu.getJ1().getFigure() == 1){
                    plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(1);
                }else if(jeu.getJ1().getFigure() == 2){
                    plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(2);
                }else if(jeu.getJ2().getFigure() == 1){
                    plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(1);
                }else if(jeu.getJ2().getFigure() == 2){
                    plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(2);
                }
            }
        }
    }
}

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
    public void clickCases(GameContainer gc) throws SlickException {
        Input input = gc.getInput();
        x = input.getMouseX();
        y = input.getMouseY();
        if((x > 100 && x < 600) && (y > 100 && y < 600)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                x-=100;
                y-=100;
                System.out.println("toto");
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(2);
            }
        }
    }
}

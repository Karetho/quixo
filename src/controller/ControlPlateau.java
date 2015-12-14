package controller;

import model.Cases;
import model.Jeu;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.opengl.SlickCallable;
import view.Fenetre;

/**
 * Created by Roland on 04-Dec-15.
 */
public class ControlPlateau {
    private Jeu jeu;
    private Plateau plateau;
    int newX,newY,x,y,i = 1;
    private Cases caseTemp;

    public ControlPlateau(Plateau plateau, Jeu jeu){
        this.plateau = plateau;
        this.jeu = jeu;
    }
    public void clickCases(GameContainer gc) throws SlickException {
        Input input = gc.getInput();
        // On prends les coordonnées en x et y du click de la souris
        // x = axe des i dans le plateau niveau model
        // y = axe des j dans le plateau niveau model
        x = input.getMouseX();
        y = input.getMouseY();
        /*System.out.println("x = " + x);
        System.out.println("y = " + y);*/

        // Verification si le clic est sur la couronne ou pas
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (((x > 500 && x < 600) && (y > 100 && y < 600)) || // colonne de droite
                    ((x > 100 && x < 200) && (y > 100 && y < 600)) || // colonne de gauche
                            ((x > 100 && x < 600) && (y > 100 && y < 200)) || // ligne du haut
                                    ((x > 100 && x < 600) && (y > 500 && y < 600))) { // ligne du bas
                // notre plateau niveau vu commence a 100 et fini a 600 d'ou le -100
                x-=100;
                y-=100;
                // On prends l'arrondi au minimum de la division de x/100 et de y/100
                if(i == 1){
                    if(jeu.getJ1().getDejaJoue()){
                        //prendre le cube et le placer autre part pour pousser les cubes (jouerCoup)
                        caseTemp = jeu.getJ2().verifCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100), plateau);
                        //plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(1);
                    }else if(jeu.getJ2().getDejaJoue()) {
                        caseTemp = jeu.getJ1().verifCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100), plateau);
                        //plateau.getPlateauIJ(Math.floorDiv(x, 100), Math.floorDiv(y, 100)).setFigure(2);
                    }
                    System.out.println("Premier coup du joueur : "+i);
                    newX = x;
                    newY = y;
                    i++;
                }
                else if (i == 2){
                    // faire sous newX et newY les nouvelles coordonnées
                    plateau.bougerPiece(Math.floorDiv(x, 100), Math.floorDiv(y, 100),newX,newY);
                    if(jeu.getJ1().getDejaJoue()){
                        //prendre le cube et le placer autre part pour pousser les cubes (jouerCoup)
                        jeu.getJ2().placerCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100),caseTemp, plateau,jeu.getJ1());
                        //plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(1);
                        jeu.getJ1().setDejaJoue(false);
                        jeu.getJ2().setDejaJoue(true);
                    }else if(jeu.getJ2().getDejaJoue()) {
                        jeu.getJ1().placerCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100),caseTemp, plateau,jeu.getJ2());
                        //plateau.getPlateauIJ(Math.floorDiv(x, 100), Math.floorDiv(y, 100)).setFigure(2);
                        jeu.getJ2().setDejaJoue(false);
                        jeu.getJ1().setDejaJoue(true);
                    }
                    System.out.println("Deuxieme coup du joueur :"+i);
                    i = 1;
                    System.out.println("Changement de joueur");
                }
            }
        }
    }
}

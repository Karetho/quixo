package controller;

import model.Cases;
import model.Jeu;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.opengl.SlickCallable;
import view.Fenetre;

import java.util.List;

/**
 * Created by Roland on 04-Dec-15.
 */
public class ControlPlateau {
    private Jeu jeu;
    private Plateau plateau;
    int oldX,oldY,x,y,i = 1;
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
        // Verification si le clic est sur la couronne ou pas
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (((x > 500 && x < 600) && (y > 100 && y < 600)) || // colonne de droite
                    ((x > 100 && x < 200) && (y > 100 && y < 600)) || // colonne de gauche
                            ((x > 100 && x < 600) && (y > 100 && y < 200)) || // ligne du haut
                                    ((x > 100 && x < 600) && (y > 500 && y < 600))) { // ligne du bas
                // notre plateau niveau vu commence a 100 et fini a 600 d'ou le -100
                x-=100;
                y-=100;
                System.out.println("x = " + Math.floorDiv(x,100));
                System.out.println("y = " + Math.floorDiv(y,100));
                // On prends l'arrondi au minimum de la division de x/100 et de y/100
                if(i == 1){
                    if(jeu.getJ1().getDejaJoue()){
                        //prendre le cube et le placer autre part pour pousser les cubes (jouerCoup)
                        //caseTemp = jeu.getJ2().verifCube( Math.floorDiv(y, 100),Math.floorDiv(x, 100), plateau);
                        caseTemp = jeu.getJ2().verifCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100), plateau);
                        //plateau.getPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100)).setFigure(1);
                    }else if(jeu.getJ2().getDejaJoue()) {
                        //caseTemp = jeu.getJ1().verifCube( Math.floorDiv(y, 100),Math.floorDiv(x, 100), plateau);
                        caseTemp = jeu.getJ1().verifCube(Math.floorDiv(x, 100), Math.floorDiv(y, 100), plateau);
                        //plateau.getPlateauIJ(Math.floorDiv(x, 100), Math.floorDiv(y, 100)).setFigure(2);
                    }
                    if(caseTemp != null){
                        System.out.println("Premier coup du joueur : "+i);
                        oldX = x;
                        oldY = y;
                        i++;
                    }
                }
                else if (i == 2){
                    List<int[]> choix = plateau.choixPossible( Math.floorDiv(oldX, 100),Math.floorDiv(oldY, 100));
                    //List<int[]> choix = plateau.choixPossible(Math.floorDiv(oldY, 100), Math.floorDiv(oldX, 100));
                    // faire sous oldX et oldY les anciennes coordonnées du premier clic
                    if(Math.floorDiv(oldX, 100) != Math.floorDiv(x, 100) || Math.floorDiv(oldY, 100) != Math.floorDiv(y, 100)){
                        //plateau.bougerPiece(Math.floorDiv(oldX, 100),Math.floorDiv(oldY, 100),Math.floorDiv(x, 100), Math.floorDiv(y, 100));
                        if(jeu.getJ1().getDejaJoue()){
                            //prendre le cube et le placer autre part pour pousser les cubes (jouerCoup)
                            for (int j = 0; j < choix.size(); j++) {
                                //if(choix.get(j)[0] ==  Math.floorDiv(y, 100)&& choix.get(j)[1] ==Math.floorDiv(x, 100)){
                                if(choix.get(j)[0] == Math.floorDiv(x, 100) && choix.get(j)[1] == Math.floorDiv(y, 100)){
                                    //plateau.bougerPiece(Math.floorDiv(oldY, 100),Math.floorDiv(oldX, 100), Math.floorDiv(y, 100),Math.floorDiv(x, 100));
                                    plateau.bougerPiece(Math.floorDiv(oldX, 100),Math.floorDiv(oldY, 100),Math.floorDiv(x, 100), Math.floorDiv(y, 100));
                                    //plateau.setPlateauIJ(Math.floorDiv(y,100),Math.floorDiv(x,100),caseTemp);
                                    plateau.setPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100),caseTemp);
                                    jeu.getJ1().setDejaJoue(false);
                                    jeu.getJ2().setDejaJoue(true);
                                    System.out.println("Deuxieme coup du joueur :"+i);
                                    i = 1;
                                    System.out.println("Changement de joueur");
                                }else{
                                    System.out.println("x = " + Math.floorDiv(x,100));
                                    System.out.println("y = " + Math.floorDiv(y,100));
                                }
                            }
                        }else if(jeu.getJ2().getDejaJoue()) {
                            for (int j = 0; j < choix.size(); j++) {
                                //if(choix.get(j)[0] ==  Math.floorDiv(y, 100)&& choix.get(j)[1] ==Math.floorDiv(x, 100)){
                                if(choix.get(j)[0] == Math.floorDiv(x, 100) && choix.get(j)[1] == Math.floorDiv(y, 100)){
                                //plateau.bougerPiece(Math.floorDiv(oldY, 100),Math.floorDiv(oldX, 100), Math.floorDiv(y, 100),Math.floorDiv(x, 100));
                                plateau.bougerPiece(Math.floorDiv(oldX, 100),Math.floorDiv(oldY, 100),Math.floorDiv(x, 100), Math.floorDiv(y, 100));
                                //plateau.setPlateauIJ(Math.floorDiv(y,100),Math.floorDiv(x,100),caseTemp);
                                plateau.setPlateauIJ(Math.floorDiv(x,100),Math.floorDiv(y,100),caseTemp);
                                    jeu.getJ2().setDejaJoue(false);
                                    jeu.getJ1().setDejaJoue(true);
                                    System.out.println("Deuxieme coup du joueur :"+i);
                                    i = 1;
                                    System.out.println("Changement de joueur");
                                }
                            }
                        }
                    }else{
                        i = 2;
                        System.out.println("Peut pas jouer");
                    }
                }
            }
            if(plateau.verifVictoireJoueurFigure() != 0){
                System.out.println("Gagné");
            }
        }
    }
}

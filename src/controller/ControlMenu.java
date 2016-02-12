package controller;

import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.IA;
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
    Joueurs joueur;
    public ControlMenu(Jeu jeu){
        this.jeu = jeu;
    }
    public void choixFigure(int x, int y,StateBasedGame game){
        if((x > 400 && x < 500) && (y > 300 && y < 400)){
            Humains h1 = new Humains("Joueur 1");
            Humains h2 = new Humains("Joueur 2");
            jeu.setJoueurs(h1,h2);
            jeu.getJ1().setFigure(1);
            jeu.getJ2().setFigure(2);

            game.enterState(Jeu_v.ID);
        }
        else if((x > 700 && x < 800) && (y > 300 && y < 400)){
            Humains h1 = new Humains("Joueur 1");
            Humains h2 = new Humains("Joueur 2");
            jeu.setJoueurs(h1,h2);
            jeu.getJ1().setFigure(2);
            jeu.getJ2().setFigure(1);

            game.enterState(Jeu_v.ID);
        }
        else if((x > 500 && x < 600) && (y > 450 && y < 550)) {
            Humains h1 = new Humains("Joueur 1");
            IA ia = new IA();
            jeu.setJoueurIa(h1,ia);
            jeu.getJ1().setFigure(1);
            jeu.getJ2().setFigure(2);

            game.enterState(Jeu_v.ID);
        }
    }
    public void choisirFigure(GameContainer gc, final StateBasedGame game){
        Input input = gc.getInput();
        // On prend les coordonnées en x et y du clic de la souris
        x = input.getMouseX();
        y = input.getMouseY();
        // x = axe des i dans le plateau niveau model
        // y = axe des j dans le plateau niveau model
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            final Thread t1 = new Thread(){
                @Override
                public void run(){
                    choixFigure(x,y,game);
                    try {
                        this.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (jeu.getJ2().getTypeId() == 1) {
                        jeu.getJ1().setDejaJoue(false);
                        jeu.getJ2().setDejaJoue(true);
                    } else {
                        joueur = jeu.choixJoueurCommence(jeu.getJ1(),jeu.getJ2());
                        if (joueur == jeu.getJ1()) {
                            jeu.getJ2().setDejaJoue(true);
                            jeu.getJ1().setDejaJoue(false);
                        } else if (joueur == jeu.getJ2()) {
                            jeu.getJ1().setDejaJoue(true);
                            jeu.getJ2().setDejaJoue(false);
                        }
                    }
                }
            };
            t1.start();


        }
    }
}

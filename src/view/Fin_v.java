package view;

import controller.ControlFin;
import controller.ControlMenu;
import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;

/**
 * Created by Roland on 12-Dec-15.
 */
public class Fin_v extends BasicGameState {
    //le menu a un ID de 0
    public static final int ID = 2;
    private Image background;
    private StateBasedGame game;
    private ControlFin controlFin;
    private Jeu jeu;
    private Plateau plateau;
    private String message;
    private int choix;
    private TrueTypeFont font;


    public Fin_v(ControlFin controlFin,Jeu jeu, Plateau plateau){
        this.controlFin = controlFin;
        this.jeu=jeu;
        this.plateau=plateau;

    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.game = stateBasedGame;
        // il faut rajouter un background propre si possible
        background = new Image("image/Fond.jpg");
        Font awtFont = new Font("Times New Roman", Font.BOLD, 50);
        font = new TrueTypeFont(awtFont, false);

    }


    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        choix = plateau.verifVictoireJoueurFigure();
        if (jeu.getJ1().getFigure()==choix)font.drawString(300, 300, "Bravo joueurs 2 as gagne !", Color.black);
        else {

//            font.drawString("Bravo joueurs 2 as gagné !", 300, 300);
            font.drawString(300, 300, "Bravo joueurs 2 as gagne !", Color.black);
//            graphics.setColor(Color.black);


        }



    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}

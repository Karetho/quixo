package view;

import controller.ControlMenu;
import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
//import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;


/**
 * Created by Roland on 12-Dec-15.
 */
public class Menu_v extends BasicGameState {
    //le menu a un ID de 0
    public static final int ID = 1;
    private Image background,caseRond,caseCroix,iaChoice,multi;
    private StateBasedGame game;
    private ControlMenu controlMenu;
    private Jeu jeu;
    Joueurs joueur = null;
    private TrueTypeFont font;
    private Font font1;


    public Menu_v(Jeu jeu,ControlMenu controlMenu){
        this.jeu = jeu;
        this.controlMenu = controlMenu;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.game = stateBasedGame;
        // il faut rajouter un background propre si possible
        background = new Image("image/debut.jpg");
        caseRond = new Image("image/rond.png");
        caseCroix = new Image("image/croix.png");
        iaChoice = new Image("image/iaChoice.jpg");
        //multi = new Image("image/multi.png");
        setInput(new Input(Input.MOUSE_LEFT_BUTTON));
        font1 = new Font("Comic Sans MS", java.awt.Font.BOLD, 35);
        font = new TrueTypeFont(font1, false);
    }
    /*
        TODO : Créer une autre vue, faire un autre background plus clair pour le menu
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        caseRond.draw(400,300);
        caseCroix.draw(700,300);
        iaChoice.draw(500,450);
       // multi.draw(750,450);
        //graphics.setColor(Color.red);
        //graphics.drawString(joueur.getNomJoueur()+" commence la partie",200,200);
        //graphics.drawString("Appuyez sur une des cases pour choisir votre figure",200,250);
        font.drawString(150,250,"Le joueur n°1 appuie sur une des cases pour choisir sa figure",Color.black);
    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controlMenu.choisirFigure(gameContainer,game);
    }
}

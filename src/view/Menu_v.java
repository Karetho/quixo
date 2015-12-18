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
class Menu_v extends BasicGameState {
    //le menu a un ID de 0
    public static final int ID = 0;
    private Image background,caseRond,caseCroix;
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
        setInput(new Input(Input.MOUSE_LEFT_BUTTON));
        joueur = jeu.choixJoueurCommence(jeu.getJ1(),jeu.getJ2());
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
        //graphics.setColor(Color.red);
        //graphics.drawString(joueur.getNomJoueur()+" commence la partie",200,200);
        font.drawString(400,150,joueur.getNomJoueur()+" commence la partie",Color.white);
        //graphics.drawString("Appuyez sur une des cases pour choisir votre figure",200,250);
        font.drawString(200,250,"Il appuie sur une des cases pour choisir sa figure",Color.white);
    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controlMenu.choisirFigure(gameContainer,game,joueur);
    }
}

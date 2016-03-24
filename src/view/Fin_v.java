package view;

import controller.ControlFin;
import controller.ControlMenu;
import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;

/**
 * Created by Roland on 12-Dec-15.
 */
public class Fin_v extends BasicGameState {
    //le menu a un ID de 0
    public static final int ID =3 ;
    private Image background;
    private StateBasedGame game;
    private ControlFin controlFin;
    private ControlMenu controlMenu;
    private Jeu jeu;
    private Plateau plateau;
    private String message;
    private int choix;
    private TrueTypeFont font;


    public Fin_v(ControlFin controlFin, Jeu jeu, Plateau plateau, ControlMenu controlMenu){
        this.controlFin = controlFin;
        this.jeu=jeu;
        this.plateau=plateau;
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
        background = new Image("image/end.jpg");
        Font awtFont = new Font("Trebuchet", Font.BOLD, 50);
        font = new TrueTypeFont(awtFont, false);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        choix = plateau.verifVictoireJoueurFigure();
        if (jeu.getJ1().getFigure()==choix){
            font.drawString(300, 150, "Bravo, victoire du joueur 1 !", Color.black);
        }
        else {
//            font.drawString("Bravo joueurs 2 as gagné !", 300, 300);
            font.drawString(300, 150, "Bravo, victoire du joueur 2 !", Color.black);
//            graphics.setColor(Color.black);
        }
        font.drawString(300, 570, "Appuyez sur Echap pour quitter", Color.black);
        font.drawString(230, 620, "Appuyez sur Entree pour recommencer", Color.black);
    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if(input.isKeyPressed(Input.KEY_ENTER)){
            for (int j = 0; j < plateau.getDimension_i(); j++) {
                for (int k = 0; k < plateau.getDimension_j(); k++) {
                    plateau.setPlateauIJFigure(j,k,0);
                }
            }
            Joueurs joueur = jeu.choixJoueurCommence(jeu.getJ1(),jeu.getJ2());
            controlMenu.choisirFigure(gameContainer,stateBasedGame);
            stateBasedGame.enterState(0);
        }
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }
    }
}

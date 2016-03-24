package view;

import controller.ControlAccueil;
import controller.ControlMulti;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;


/**
 * Created by Roland on 24-Mar-16.
 */
public class Multi_v extends BasicGameState {

    //menu multi a un ID de 4
    public static final int ID = 4;
    private final ControlMulti controlMulti;
    private Image background;
    private StateBasedGame game;
    private TrueTypeFont font;
    private Font font1;
    private Font font2;
    private TrueTypeFont font3;


    public Multi_v(ControlMulti controlMulti) {
        this.controlMulti = controlMulti;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        game = stateBasedGame;
        // il faut rajouter un background propre si possible
        background = new Image("image/debut.jpg");
        setInput(new Input(Input.MOUSE_LEFT_BUTTON));
        font1 = new Font("Comic Sans MS", java.awt.Font.BOLD, 50);
        font = new TrueTypeFont(font1, false);
        font2 = new Font("Comic Sans MS", Font.BOLD, 30);
        font3 = new TrueTypeFont(font2, false);
    }

    /*
        TODO : Créer une autre vue, faire un autre background plus clair pour le menu
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, org.newdawn.slick.Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        font3.drawString(800, 300, "Host", Color.white);
        font3.drawString(600, 300, "Client", Color.white);
        font3.drawString(700, 400, "Retour", Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controlMulti.choisirMenu(gameContainer, game);
    }
}


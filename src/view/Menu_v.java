package view;

import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Roland on 12-Dec-15.
 */
class Menu_v extends BasicGameState {
    //le menu a un ID de 0
    public static final int ID = 0;
    private Image background;
    private StateBasedGame game;
    private Jeu jeu;

    public Menu_v(Jeu jeu){
        this.jeu = jeu;
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
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());

        graphics.drawString("Joueur",300,300);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
    @Override
    public void keyReleased(int key, char c) {
        if(Input.KEY_ESCAPE == key){
            jeu.getJ1().setFigure(1);

            game.enterState(Jeu_v.ID);
        }

    }
}

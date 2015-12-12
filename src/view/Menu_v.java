package view;

import controller.ControlMenu;
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
    private Image background,caseRond,caseCroix;
    private StateBasedGame game;
    private ControlMenu controlMenu;
    private Jeu jeu;
    Joueurs joueur = null;

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
        background = new Image("image/Fond.jpg");
        caseRond = new Image("image/caseRond.png");
        caseCroix = new Image("image/caseCroix.png");
        setInput(new Input(Input.MOUSE_LEFT_BUTTON));
        joueur = jeu.choixJoueurCommence(jeu.getJ1(),jeu.getJ2());
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        caseRond.draw(150,300);
        caseCroix.draw(400,300);
        graphics.setColor(Color.red);
        graphics.drawString(joueur.getNomJoueur()+" commence la partie",200,200);
        graphics.drawString("Appuyez sur une des cases pour choisir votre figure",200,250);
    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controlMenu.choisirFigure(gameContainer,game,joueur);
    }
}

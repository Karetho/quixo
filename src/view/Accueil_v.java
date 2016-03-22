package view;

import controller.ControlAccueil;
import controller.ControlMenu;
import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Joueurs.Joueurs;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
//import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;


/**
 * Created by Roland on 12-Dec-15.
 */
public class Accueil_v extends BasicGameState {
    //l'accueil a un ID de 0
    public static final int ID = 0;
    private final ControlAccueil controlAccueil;
    private Image background;
    private StateBasedGame game;
    private TrueTypeFont font;
    private Font font1;
    private Font font2;
    private TrueTypeFont font3;


    public Accueil_v(ControlAccueil controlAccueil){
        this.controlAccueil = controlAccueil;
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
        font2 = new Font("Comic Sans MS",Font.BOLD,30);
        font3 = new TrueTypeFont(font2,false);
    }
    /*
        TODO : Créer une autre vue, faire un autre background plus clair pour le menu
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        //graphics.draw(background,0,0,gameContainer.getWidth(),gameContainer.getHeight());
        font.drawString(400,150,"Quixo",Color.white);
        font3.drawString(600,250,"Solo",Color.white);
        font3.drawString(600,300,"Multi",Color.white);
        font3.drawString(600,350,"Quitter",Color.white);
        //graphics.flush();

        //graphics.setColor(Color.red);
        //graphics.drawString(joueur.getNomJoueur()+" commence la partie",200,200);
        //graphics.drawString("Appuyez sur une des cases pour choisir votre figure",200,250);
        //font.drawString(200,250,"Le joueur n°1 appuie sur une des cases pour choisir sa figure",Color.white);
    }
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controlAccueil.choisirMenu(gameContainer,game);
    }
}

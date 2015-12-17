package view;
import controller.ControlFin;
import controller.ControlMenu;
import controller.ControlPlateau;
import model.Jeu;
import model.Joueurs.Joueurs;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Fenetre extends StateBasedGame {
    private ControlPlateau controlPlateau;
    private ControlMenu controlMenu;
    private Jeu jeu;
    private Plateau plateau;
    private ControlFin controlFin;

    private float x = 0, y = 0;

    public Fenetre(ControlPlateau controlPlateau, Jeu jeu, Plateau plateau, ControlMenu controlMenu, ControlFin controlFin) throws SlickException {
        super("Quixo");
        this.controlPlateau = controlPlateau;
        this.controlMenu = controlMenu;
        this.jeu = jeu;
        this.plateau = plateau;
        this.controlFin = controlFin;


    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Menu_v(jeu,controlMenu));
        addState(new Jeu_v(controlPlateau,jeu,plateau));
        addState(new Fin_v(controlFin,jeu,plateau,controlMenu));
    }
}

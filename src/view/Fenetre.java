package view;
import controller.ControlAccueil;
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

    private ControlAccueil controlAccueil   ;

    public Fenetre(ControlAccueil controlAccueil,ControlPlateau controlPlateau, Jeu jeu, Plateau plateau, ControlMenu controlMenu, ControlFin controlFin) throws SlickException {
        super("Quixo");
        this.controlAccueil = controlAccueil;
        this.controlPlateau = controlPlateau;
        this.controlMenu = controlMenu;
        this.jeu = jeu;
        this.plateau = plateau;
        this.controlFin = controlFin;
    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Accueil_v(controlAccueil));
        addState(new Menu_v(jeu,controlMenu));
        addState(new Jeu_v(controlPlateau,jeu,plateau));
        addState(new Fin_v(controlFin,jeu,plateau,controlMenu));
    }
}

package view;
import controller.ControlMenu;
import controller.ControlPlateau;
import model.Jeu;
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
    private Image caseNeutre, caseRond, caseCroix, flecheDroite, flecheGauche, flecheHaut, flecheBas;
    private Image bouger;

    private float x = 0, y = 0;

    public Fenetre(ControlPlateau controlPlateau,Jeu jeu,Plateau plateau,ControlMenu controlMenu) throws SlickException {
        super("Quixo");
        this.controlPlateau = controlPlateau;
        this.controlMenu = controlMenu;
        this.jeu = jeu;
        this.plateau = plateau;
    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Menu_v(jeu,controlMenu));
        addState(new Jeu_v(controlPlateau,jeu,plateau));
    }
}

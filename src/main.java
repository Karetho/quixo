import controller.*;
import model.Jeu;
import model.Plateau;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import view.Fenetre;

/**
 * Created by Roland on 26-Nov-15.
 */
public class main {

    public static void main(String[] args) throws SlickException {
        Plateau modelPlateau = new Plateau();
        ControlFin controlFin = new ControlFin();
        ControlAccueil controlAccueil = new ControlAccueil();
        Jeu jeu = new Jeu();
        ControlMulti controlMulti = new ControlMulti();
        ControlPlateau plateau = new ControlPlateau(modelPlateau, jeu);
        ControlMenu controlMenu = new ControlMenu(jeu);
        new AppGameContainer(new Fenetre(controlMulti,controlAccueil,plateau,jeu,modelPlateau,controlMenu,controlFin), 1200, 700, false).start();
    }
}

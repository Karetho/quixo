import controller.ControlPlateau;
import model.Jeu;
import model.Joueurs.Humains.Humains;
import model.Plateau;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import view.Fenetre;

/**
 * Created by Roland on 26-Nov-15.
 */
public class main {

    public static void main(String[] args) throws SlickException {
        Humains h1 = new Humains("Alice");
        Humains h2 = new Humains("Bob");
        Plateau modelPlateau = new Plateau();
        Jeu jeu = new Jeu(h1,h2);
        ControlPlateau plateau = new ControlPlateau(modelPlateau, jeu);
        new AppGameContainer(new Fenetre(plateau,jeu,modelPlateau), 700, 700, false).start();
    }
}

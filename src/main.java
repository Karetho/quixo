import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import view.Fenetre;

/**
 * Created by Roland on 26-Nov-15.
 */
public class Main {

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new Fenetre(), 700, 700, false).start();
    }
}

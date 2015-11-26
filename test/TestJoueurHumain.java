import junit.framework.Assert;
import model.Joueurs.Humains.Humains;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Roland on 09-Nov-15.
 */
public class TestJoueurHumain {
    // test si le joueur a gagner
    @Test
    public void testJoueurGagne(){
    }
    // test si le cube est bien celui du joueur
    @Test
    public void testChangerSigne(){
        Humains humain = new Humains("joueur 1");
        humain.changerSigne();
        Mockito.when(humain.changerSigne()).then('1');

    }
}

import model.Joueurs.Humains.Humains;
import org.junit.*;
import org.mockito.Mockito;

import java.util.Random;

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
    public void testChangerFigure(){
        Humains humain = new Humains("joueur 1");
        Random rand = Mockito.mock(Random.class);
        Mockito.when(rand.nextInt(1)).thenReturn(1);
        humain.changerFigure();
        Assert.assertEquals(1,humain.getFigure());
    }
}

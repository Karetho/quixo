import model.Jeu;
import model.Joueurs.Humains.Humains;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by bobol on 20/11/15.
 */
public class TestJeu {

    @Test
    public void testchoixJoueurCommence() {
        Humains h1 = new Humains("Joueur 1");
        Humains h2 = new Humains("Joueur 2");
        Jeu jeu = new Mockito().mock(Jeu.class);
        Mockito.when(jeu.choixJoueurCommence(h1,h2)).thenReturn(h1);
        Assert.assertEquals(h1,jeu.choixJoueurCommence(h1,h2));
    }
}

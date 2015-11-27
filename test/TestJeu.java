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
        Mockito.when(jeu.chiffreAleatoireJoueur()).thenReturn(1);
        Assert.assertEquals(1,jeu.chiffreAleatoireJoueur());
        Mockito.when(jeu.choixJoueurCommence(h1,h2)).thenReturn(h2);
        Assert.assertEquals(h2,jeu.choixJoueurCommence(h1,h2));
    }
}

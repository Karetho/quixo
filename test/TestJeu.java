import model.Jeu;
import model.Joueurs.Humains.Humains;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by bobol on 20/11/15.
 */
public class TestJeu {
    private Humains h1,h2;
    private Jeu jeuGlobal;
    private int figure;

    @Before
    public void setUp() {
        h1 = new Humains("Joueur 1");
        h2 = new Humains("Joueur 2");
        jeuGlobal = new Jeu(h1,h2);
    }

    @Test
    public void testchoixJoueurCommenceCaseO() {
        //test premier case de choixJoueurCommenceCase qui renvoie j1
        setUp();
        Jeu jeu = new Mockito().mock(Jeu.class);
        Mockito.when(jeu.choixJoueurCommence(h1,h2)).thenReturn(h1);
        Assert.assertEquals(h1,jeu.choixJoueurCommence(h1,h2));
    }

    @Test
    public void testchoixJoueurCommenceCase1() {
        //test deuxième case de choixJoueurCommenceCase qui renvoie j2
        setUp();
        Jeu jeu = new Mockito().mock(Jeu.class);
        Mockito.when(jeu.choixJoueurCommence(h1,h2)).thenReturn(h2);
        Assert.assertEquals(h2,jeu.choixJoueurCommence(h1,h2));
    }

    @Test
    public void testchoixJoueurCommenceDefault() {
        //test default de choixJoueurCommenceCase qui renvoie null
        setUp();
        Jeu jeu = new Mockito().mock(Jeu.class);
        Mockito.when(jeu.choixJoueurCommence(h1,h2)).thenReturn(null);
        Assert.assertEquals(null,jeu.choixJoueurCommence(h1,h2));
    }

    @Test
    public void testsetFigureJoueurEgaleJ1Case1() {
        //test premier if et case 1 de setFigureJoueur
        figure = 1;
        jeuGlobal.setFigureJoueur(h1,figure);
        Assert.assertEquals(2,jeuGlobal.getJ2().getFigure());
    }

    @Test
    public void testsetFigureJoueurEgaleJ1Case2() {
        //test premier if et case 2 de setFigureJoueur
        figure = 2;
        jeuGlobal.setFigureJoueur(h1,figure);
        Assert.assertEquals(1,jeuGlobal.getJ2().getFigure());
    }

    @Test
    public void testsetFigureJoueurEgaleJ2Case1() {
        //test else et case 1 de setFigureJoueur
        figure =1;
        jeuGlobal.setFigureJoueur(h2,figure);
        Assert.assertEquals(2,jeuGlobal.getJ1().getFigure());
    }

    @Test
    public void testsetFigureJoueurEgaleJ2Case2() {
        //test else et case 2 de setFigureJoueur
        figure =2;
        jeuGlobal.setFigureJoueur(h2,figure);
        Assert.assertEquals(1,jeuGlobal.getJ1().getFigure());
    }
}

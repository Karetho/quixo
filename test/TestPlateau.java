
import model.Joueurs.Humains.Humains;
import model.Plateau;
import org.junit.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Roland on 26-Nov-15.
 */
public class TestPlateau {
    Humains joueur;
    Plateau plateau;
    @Before
    public void setUp(){
        joueur = new Humains();
        plateau = new Plateau();
    }

    //Teste si le joueur a gagne
    @Test
    public void testSiJoueurGagne(){
        setUp();
    }
    //Teste le décalement des cubes sur la ligne
    @Test
    public void testDecaleCases(){
        setUp();

    }
    //Montre les choix possibles que peux avoir le joueur
    @Test
    public void testChoixPossibleCorner1(){
        //Teste le corner en haut a droite
        setUp();
        List liste = new LinkedList<>();
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,0});
        //liste.add(new int[]{0,4});
        //Premier test sur un corner
        joueur.prendreCube(0,0);
        Assert.assertEquals(liste,plateau.choixPossible(0,0));
    }@Test
    public void testChoixPossibleCorner2(){
        //Teste le corner en bas a gauche
        setUp();
        List liste = new LinkedList<>();
        liste.add(new int[]{4,0});
        liste.add(new int[]{0,4});
        //liste.add(new int[]{0,4});
        //Premier test sur un corner
        joueur.prendreCube(4,4);
        Assert.assertEquals(liste,plateau.choixPossible(4,4));
    }
    @Test
    public void testChoixPossibleCorner3(){
        //Teste le corner en bas a gauche
        setUp();
        List liste = new LinkedList<>();
        liste.add(new int[]{4,4});
        liste.add(new int[]{0,4});
        //liste.add(new int[]{0,4});
        //Premier test sur un corner
        joueur.prendreCube(4,0);
        Assert.assertEquals(liste,plateau.choixPossible(4,0));

    }
    @Test
    public void testChoixPossibleCorner4(){
        //Teste le corner en haut a droite
        setUp();
        List liste = new LinkedList<>();
        liste.add(new int[]{4,4});
        liste.add(new int[]{4,0});
        //liste.add(new int[]{0,4});
        //Premier test sur un corner
        joueur.prendreCube(0,4);
        Assert.assertEquals(liste,plateau.choixPossible(0,4));

    }
    @Test
    public void testChoixPossibleGauche(){
        setUp();
        //Deuxieme test sur une case du milieu sans les corners
        List liste = new LinkedList<>();
        liste.add(new int[]{2,4});
        liste.add(new int[]{4,0});
        liste.add(new int[]{0,0});
        joueur.prendreCube(2,0);
        Assert.assertEquals(liste,plateau.choixPossible(2,0));
    }
    @Test
    public void testChoixPossibleDroite(){
        setUp();
        //Deuxieme test sur une case du milieu
        List liste = new LinkedList<>();
        liste.add(new int[]{0,2});
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,4});
        joueur.prendreCube(2,4);
        Assert.assertEquals(liste,plateau.choixPossible(2,4));
    }@Test
    public void testChoixPossibleHaut(){
        setUp();
        //Deuxieme test sur une case du milieu
        List liste = new LinkedList<>();
        liste.add(new int[]{4,2});
        liste.add(new int[]{0,4});
        liste.add(new int[]{0,0});
        joueur.prendreCube(0,2);
        Assert.assertEquals(liste,plateau.choixPossible(0,2));
    }@Test
    public void testChoixPossibleBas(){
        setUp();
        //Deuxieme test sur une case du milieu
        List liste = new LinkedList<>();
        liste.add(new int[]{0,2});
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,4});
        joueur.prendreCube(4,2);
        Assert.assertEquals(liste,plateau.choixPossible(4,2));
    }
}

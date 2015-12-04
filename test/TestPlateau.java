import model.Joueurs.Humains.Humains;
import model.Plateau;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
    public void testVerifGagneJoueurFigure(){
        setUp();
        Mockito.mock(Plateau.class);

    }
    //Teste le décalement des cubes sur la ligne
    @Test
    public void testDecaleCases(){
        setUp();

    }
    //Montre les choix possibles que peux avoir le joueur
    @Test
    public void testChoixPossibleCorner1(){
        //Teste le corner en haut a gauche (0,0) ou en bas a droite (4,4)
        setUp();
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,0});

        //joueur.prendreCube(0,0,plateau);
        List <int[]> liste1 = plateau.choixPossible(0,0);
        for (int i = 0; i < liste.size(); i++) {
            Assert.assertArrayEquals(liste1.get(i),liste.get(i));
        }
        //joueur.prendreCube(4,4,plateau);
        List <int[]> liste2 = plateau.choixPossible(4,4);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }
    @Test
    public void testChoixPossibleCorner2(){
        //Teste le corner en bas a gauche (4,0) ou en haut a droite (0,4)
        setUp();
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{0,0});
        liste.add(new int[]{4,4});
        //joueur.prendreCube(4,0,plateau);
        List <int[]> liste1 = plateau.choixPossible(4,0);
        for (int i = 0; i < liste.size(); i++) {
            Assert.assertArrayEquals(liste1.get(i),liste.get(i));
        }
        //joueur.prendreCube(0,4,plateau);
        List <int[]> liste2 = plateau.choixPossible(0,4);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }

    }
    @Test
    public void testChoixPossibleGauche(){
        setUp();
        //Deuxieme test sur une case du milieu gauche sans les corners
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{2,4});
        liste.add(new int[]{4,0});
        liste.add(new int[]{0,0});
        //joueur.prendreCube(2,0,plateau);
        List <int[]> liste2 = plateau.choixPossible(2,0);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }
    @Test
    public void testChoixPossibleDroite(){
        setUp();
        //Deuxieme test sur une case du milieu
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{2,0});
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,4});
        //joueur.prendreCube(2,4,plateau);
        List <int[]> liste2 = plateau.choixPossible(2,4);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }
    @Test
    public void testChoixPossibleHaut(){
        setUp();
        //Deuxieme test sur une case du milieu
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{4,2});
        liste.add(new int[]{0,4});
        liste.add(new int[]{0,0});
        //joueur.prendreCube(0,2,plateau);
        List <int[]> liste2 = plateau.choixPossible(0,2);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }@Test
    public void testChoixPossibleBas(){
        setUp();
        //Deuxieme test sur une case du milieu
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{0,2});
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,4});
        //joueur.prendreCube(4,2,plateau);
        List <int[]> liste2 = plateau.choixPossible(4,2);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }

    //Test bougerPiece
    @Test
    public void testBougerPiece() {
        setUp();
    }
}

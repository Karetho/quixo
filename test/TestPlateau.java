
import model.Joueurs.Humains.Humains;
import model.Plateau;
import org.junit.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


/**
 * Created by Roland on 26-Nov-15.
 */
public class TestPlateau {
    //Teste si le joueur a gagne
    @Test
    public void testSiJoueurGagne(){
        Humains joueur = new Humains();
        Plateau plateau = new Plateau();
    }
    //Teste le décalement des cubes sur la ligne
    @Test
    public void testDecaleCases(){
        Plateau plateau = new Plateau();

    }
    //Montre les choix possibles que peux avoir le joueur
    @Test
    public void testChoixPossible(){
        List liste = new LinkedList<>();
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,0});
        //liste.add(new int[]{0,4});
        Humains joueur = new Humains();
        Plateau plateau = new Plateau();
        //Premier test sur un corner
        joueur.prendreCube(0,0);
        Assert.assertEquals(liste,plateau.choixPossible(0,0));
        //Deuxieme test sur une case du milieu
        List liste1 = new LinkedList<>();
        liste1.add(new int[]{2,4});
        liste1.add(new int[]{4,0});
        liste1.add(new int[]{0,0});
        joueur.prendreCube(2,0);
        Assert.assertEquals(liste,plateau.choixPossible(2,0));
    }
}

import model.Cases;
import model.Joueurs.Humains.Humains;
import model.Plateau;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Roland on 09-Nov-15.
 */
public class TestHumain {
    private Humains humains;
    private Plateau plateau;
    private Cases cases;

    @Before
    public void setUp(){
        humains = new Humains();
        plateau = new Plateau();
        cases = new Cases();
    }

    // test si le joueur a gagner

    //@Test
    /*public void TestprendreCube(){
        //test si la cases retournée par la méthode posséde les mêmes attributs que la case supprimée
        setUp();
        int i = 3; int j = 3;
        plateau.getPlateauIJ(i,j).setFigure(0);
        cases = humains.prendreCube(i,j,plateau);
        Assert.assertEquals(0,cases.getFigure());
        Assert.assertEquals(3,plateau.getPlateauIJ(i,j).getFigure());


    }
*/
   /* @Test
    public void TestplacerCube() {
        //test si la case placée par la méthode posséde les mêmes attributs que la case prise
        setUp();
        int i =4; int j = 2;
        cases.setFigure(2);
        humains.placerCube(i,j,cases,plateau);
        Assert.assertEquals(2,plateau.getPlateauIJ(i,j).getFigure());
    }*/
}

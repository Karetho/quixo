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
    private Cases case_temp;
    private String[] tabTostring;

    @Before
    public void setUp(){
        humains = new Humains();
        plateau = new Plateau();
        cases = new Cases();
        case_temp = new Cases();
    }

    @Test
    public void TestprendreCubeFigureCaseRetournée(){
        //test si la case retournée par la méthode posséde les mêmes attributs que la case supprimée
        setUp();
        int i = 3,j = 3;
        humains.setFigure(2);
        cases = humains.prendreCube(i,j,plateau,case_temp);
        Assert.assertEquals(humains.getFigure(),cases.getFigure());
    }

    @Test
    public void TestprendreCubeFigureCaseSupprimée(){
        //test si la case supprimée par la méthode est de figure vide : 3
        setUp();
        int i = 3,j = 3;
        cases = humains.prendreCube(i,j,plateau,case_temp);
        Assert.assertEquals(3, plateau.getPlateauIJ(i, j).getFigure());
    }

    @Test
    public void TestplacerCube() {
        //test si la case placée dans le plateau posséde la même figure que la case prise
        setUp();
        int i = 2,j = 4;
        cases.setFigure(2);
        humains.placerCube(i,j,cases,plateau);
        Assert.assertEquals(cases.getFigure(),plateau.getPlateauIJ(i,j).getFigure());

    }

    @Test
    public void TestverifCubeFigureEgale0() {
        //test le premier if de la méthode verifCube avec figure = 0
        setUp();
        int i = 0,j = 2;
        plateau.getPlateauIJ(i,j).setFigure(0);
        humains.setFigure(1);
        cases = humains.verifCube(i,j,plateau);
        Assert.assertEquals(humains.getFigure(),cases.getFigure());
    }

    @Test
    public void TestverifCubeFigureEgaleFigureHumain() {
        //test le deuxième if de la méthode verifCube avec figure égale à celle de l'humain
        setUp();
        int i = 3, j = 4;
        humains.setFigure(2);
        plateau.getPlateauIJ(i,j).setFigure(humains.getFigure());
        cases = humains.verifCube(i,j,plateau);
        Assert.assertEquals(humains.getFigure(),cases.getFigure());
    }

    @Test
    public void TestverifCubeFigurePasEgale() {
        //test le else de la méthode verifCube avec figure égale à celle de l'adversaire et qui renvoie null
        setUp();
        int i = 0,j = 3;
        humains.setFigure(1);
        plateau.getPlateauIJ(i,j).setFigure(2);
        cases = humains.verifCube(i,j,plateau);
        Assert.assertEquals(null,cases);
    }

    @Test
    public void TesttoStringRenvoiNom() {
        //test la méthode toString renvoi bien le nom
        setUp();
        String infosHumains;
        humains.setFigure(1);
        infosHumains = humains.toString();
        tabTostring = infosHumains.split("\n");
        Assert.assertEquals("Nom : "+humains.getNomJoueur(),tabTostring[0]);
    }

    @Test
    public void TesttoStringRenvoiFigure() {
        //test la méthode toString renvoi bien le nom de la figure
        setUp();
        String infosHumains;
        humains.setFigure(1);
        infosHumains = humains.toString();
        tabTostring = infosHumains.split("\n");
        Assert.assertEquals("Figure : "+humains.getNomFigure(),tabTostring[1]);
    }

    @Test
    public void TesttoStringRenvoiDejaJoue() {
        //test la méthode toString renvoi bien si deja joué
        setUp();
        String infosHumains;
        humains.setFigure(1);
        infosHumains = humains.toString();
        tabTostring = infosHumains.split("\n");
        Assert.assertEquals("Deja joué : "+humains.getDejaJoue(),tabTostring[2]);
    }
}

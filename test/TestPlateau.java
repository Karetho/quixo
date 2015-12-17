import model.Joueurs.Humains.Humains;

import model.Cases;
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
    Plateau plateau2;
    @Before
    public void setUp(){
        joueur = new Humains();
        plateau = new Plateau();
        plateau2 = new Plateau();
    }


    @Test
    public void testVerifGagneJoueurFigureVertical(){
        //test méthode VerifGagneJoueurFigure verticalement
        setUp();
        Plateau plateau = new Plateau();
        Cases tab_plateau[][]=plateau.getPlateau();

        tab_plateau[0][0].setFigure(1);
        tab_plateau[1][0].setFigure(1);
        tab_plateau[2][0].setFigure(1);
        tab_plateau[3][0].setFigure(1);
        tab_plateau[4][0].setFigure(1);
        int result=plateau.verifVictoireJoueurFigure();
        Assert.assertEquals(1,result);


    }

    @Test
    public void testVerifGagneJoueurFigureHorizontal(){
        //test méthode VerifGagneJoueurFigure horizontalement
        setUp();
        Plateau plateau = new Plateau();
        Cases tab_plateau[][]=plateau.getPlateau();

        tab_plateau[3][0].setFigure(2);
        tab_plateau[3][1].setFigure(2);
        tab_plateau[3][2].setFigure(2);
        tab_plateau[3][3].setFigure(2);
        tab_plateau[3][4].setFigure(2);
        int result=plateau.verifVictoireJoueurFigure();
        Assert.assertEquals(2,result);


    }

    @Test
    public void testVerifGagneJoueurFigureDiagonaleGauchDroite(){
        //test méthode VerifGagneJoueurFigure en diagonale de gauche à droite
        setUp();
        Plateau plateau = new Plateau();
        Cases tab_plateau[][]=plateau.getPlateau();

        tab_plateau[0][0].setFigure(1);
        tab_plateau[1][1].setFigure(1);
        tab_plateau[2][2].setFigure(1);
        tab_plateau[3][3].setFigure(1);
        tab_plateau[4][4].setFigure(1);
        int result=plateau.verifVictoireJoueurFigure();
        Assert.assertEquals(1,result);
    }
    @Test
    public void testVerifGagneJoueurFigureDiagonaleDroiteGauche(){
        //test méthode VerifGagneJoueurFigure en diagonale de droite à gauche
        setUp();
        Plateau plateau = new Plateau();
        Cases tab_plateau[][]=plateau.getPlateau();

        tab_plateau[4][4].setFigure(2);
        tab_plateau[3][3].setFigure(2);
        tab_plateau[2][2].setFigure(2);
        tab_plateau[1][1].setFigure(2);
        tab_plateau[0][0].setFigure(2);
        int result=plateau.verifVictoireJoueurFigure();
        Assert.assertEquals(2,result);


    }

   //Montre les choix possibles que peux avoir le joueur
    @Test
    public void testChoixPossibleCorner1(){
        //Teste le corner en haut a gauche (0,0) ou en bas a droite (4,4)
        setUp();
        List <int[]> liste = new LinkedList<>();
        liste.add(new int[]{0,4});
        liste.add(new int[]{4,0});

        List <int[]> liste1 = plateau.choixPossible(0,0);
        for (int i = 0; i < liste.size(); i++) {
            Assert.assertArrayEquals(liste1.get(i),liste.get(i));
        }

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

        List <int[]> liste1 = plateau.choixPossible(4,0);
        for (int i = 0; i < liste.size(); i++) {
            Assert.assertArrayEquals(liste1.get(i),liste.get(i));
        }

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
        liste.add(new int[]{4,0});
        liste.add(new int[]{4,4});

        List <int[]> liste2 = plateau.choixPossible(4,2);
        for (int j = 0; j < liste.size(); j++) {
            Assert.assertArrayEquals(liste2.get(j),liste.get(j));
        }
    }

    //Test bougerPiece
    @Test
    public void testBougerPieceHorizontalMemeLigneJInferieur() {
        //test sur côté horizontal sur la même ligne avec j < j1
        setUp();
        int i = 0,j = 2, i1 = i, j1 = 4;
        for (int k = j+1; k < 5; k++) {
            plateau2.getPlateau()[i][k-1].setFigure(plateau2.getPlateau()[i][k].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(), plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceHorizontalMemeLigneJSuperieur() {
        //test sur côté horizontal sur la même ligne avec j > j1
        setUp();
        int i = 0,j = 3, i1 = i, j1 = 2;
        for (int k = j-1; k >=0; k--) {
            plateau2.getPlateau()[i][k+1].setFigure(plateau2.getPlateau()[i][k].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceHorizontalMemeColonneIInferieur() {
        //test sur côté horizontal sur la même ligne avec i > i1
        setUp();
        int i = 2,j = 1, i1 = 3, j1 = j;
        for (int k = i+1; k <5; k++) {
            plateau2.getPlateau()[k-1][j].setFigure(plateau2.getPlateau()[k][j].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceJEgal0OuEgal4MemeColonneIInferieur() {
        //test avec j == 0 ou j== 4 j == j1 et i < i1
        setUp();
        int i = 1,j = 4, i1 = 3, j1 = j;
        for (int k = i+1; k <5; k++) {
            plateau2.getPlateau()[k-1][j].setFigure(plateau2.getPlateau()[k][j].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceJEgal0OuEgal4MemeColonneISuperieur() {
        //test avec j == 0 ou j== 4 j == j1 et i > i1
        setUp();
        int i = 3,j = 4, i1 = 1, j1 = j;
        for (int k = i-1; k >=0; k--) {
            plateau2.getPlateau()[k+1][j].setFigure(plateau2.getPlateau()[k][j].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceJEgal0OuEgal4MemeLigneJInferieur() {
        //test avec j == 0 ou j== 4 i == i1 et j < j1
        setUp();
        int i = 1,j = 0, i1 = 1, j1 = 2;
        for (int k = j+1; k <5; k++) {
            plateau2.getPlateau()[i][k-1].setFigure(plateau2.getPlateau()[i][k].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }

    @Test
    public void testBougerPieceJEgal0OuEgal4MemeLigneJSuperieur() {
        //test avec j == 0 ou j== 4 i == i1 et j > j1
        setUp();
        int i = 1,j = 4, i1 = 1, j1 = 2;
        for (int k = j-1; k >=0; k--) {
            plateau2.getPlateau()[i][k+1].setFigure(plateau2.getPlateau()[i][k].getFigure());
        }
        plateau.bougerPiece(i,j,i1,j1);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                Assert.assertEquals(plateau2.getPlateau()[k][l].getFigure(),plateau.getPlateau()[k][l].getFigure());
            }
        }
    }
}

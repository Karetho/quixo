package model;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bobol on 20/11/15.
 */
public class Plateau {
    private Cases[][] plateau;
    private final int dimension_i = 5;
    private final int dimension_j = 5;


    public Plateau(){
        plateau = new Cases[dimension_i][dimension_j];
        for (int i = 0; i < dimension_i; i++) {
            for (int j = 0; j < dimension_j; j++) {
                plateau[i][j] = new Cases();
            }
        }
    }
    // Verification des lignes de figures retourne false si pas de cases
    public int verifVictoireJoueurFigure(){
        int result = 0;
        int j = 0;
        int i=0;
        boolean condition = false;

        //Test si il y a 5 cases identiques alignées verticalement
        for ( i=0 ; i<5 ; i++){
            condition = false;
            while (j<5 && condition==false) {
                if (j!=0){
                    if (plateau[i][j].getFigure()!=plateau[i][j-1].getFigure()) {
                        condition=true;
                    }else if (j==5){
                        result=plateau[i][j].getFigure();
                        return result;
                    }
                }
            }
        }

        //Test si il y a 5 cases identiques alignées horizontalement
        for ( j=0 ; j<5 ; j++){
            condition = false;
            while (i<5 && condition==false) {
                if (i!=0){
                    if (plateau[i][j].getFigure()!=plateau[i-1][j].getFigure()) {
                        condition=true;
                    }else if (i==5){
                        result=plateau[i][j].getFigure();
                        return result;
                    }
                }
            }
        }

        //Test si il y a 5 cases identiques alignées en diagonale de gauche à droite
        i=0;
        condition=false;
        while (i<5 && condition==false) {
            if (i!=0){
                if (plateau[i][i].getFigure()!=plateau[i-1][i-1].getFigure()) {
                    condition=true;
                }else if (i==5){
                    result=plateau[i][i].getFigure();
                    return result;
                }
            }
        }

        //Test si il y a 5 cases identiques aligné en diagonale de droite à gauche
        j=5;
        for ( i=0 ; i<5 ; i++){
            condition = false;
            while (j>0 && condition==false) {
                if (j!=0){
                    if (plateau[i][j].getFigure()!=plateau[i-1][j+1].getFigure()) {
                        condition=true;
                    }else if (j==5){
                        result=plateau[i][j].getFigure();
                        return result;
                    }
                }
            }
        }

        result=0;
        return result;
    }
    // Affiche les différentes possibilités que le joueur a apres avoir pris un cube
    public List <int[]> choixPossible(int i, int j) {
        List <int[]> retour = new LinkedList<>();
        //Le cube déplacé est dans la bordure du haut
        if(i == 0 && (j > 0 && j < 4)){
            retour.add(new int[]{4,j});
            retour.add(new int[]{0,4});
            retour.add(new int[]{0,0});
        }
        //Le cube déplacé est dans la bordure du bas
        else if(i == 4 && (j < 4 && j > 0)){
            retour.add(new int[]{0,j});
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans la bordure de gauche
        else if((i > 0 && i < 4) && j == 0){
            retour.add(new int[]{i,4});
            retour.add(new int[]{4,0});
            retour.add(new int[]{0,0});
        }
        //Le cube déplacé est dans la bordure droite
        else if((i > 0 && i < 4) && j == 4){
            retour.add(new int[]{i,0});
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans le corner haut gauche (0,0) ou Le cube déplacé est dans le corner bas droite (4,4)
        else if((i == 0 && j == 0) || (i == 4 && j == 4)){
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,0});
        }
        //Le cube déplacé est dans le corner haut droite (0,4) ou Le cube déplacé est dans le corner bas gauche (4,0)
        else if((i == 0 && j == 4) ||(i == 4 && j == 0)){
            retour.add(new int[]{0,0});
            retour.add(new int[]{4,4});
        }
        return retour;
    }

    // décale les autres cases pour remplir l'espace vide
    public void bougerPiece(int i,int j,int i1, int j1) {
        List<int[]> retour;
        int i_arrive,j_arrive;
        if (plateau[i][j].getFigure() == 3) {
            retour = choixPossible(i,j);
            for(int k = 0;k < retour.size(); k++){
                if(retour.get(k)[0] == i1 && retour.get(k)[1] == j1){
                    i_arrive = retour.get(k)[0];
                    j_arrive = retour.get(k)[1];
                    for (int l = 0; l < i_arrive ; l++) {
                        for (int m = 0; m < j_arrive; m++) {
                            plateau[l][m] = plateau[l+1][m+1];
                        }
                    }
                    plateau[i_arrive][j_arrive].setFigure(3);
                }
            }
        }
    }

    public Cases getPlateauIJ(int i, int j) {
        return plateau[i][j];
    }

    public void setPlateauIJ(int i, int j,int figure) {
        plateau[i][j].setFigure(figure);
    }

    public int getDimension_i() {
        return dimension_i;
    }

    public int getDimension_j() {
        return dimension_j;
    }

}

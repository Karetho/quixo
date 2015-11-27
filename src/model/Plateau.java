package model;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by bobol on 20/11/15.
 */
public class Plateau {
    private Cases[][] plateau;

    public Plateau(){
        plateau = new Cases[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plateau[i][j] = new Cases();
            }
        }
    }


    public List choixPossible(int i, int j) {
        List retour = new LinkedList<>();
        //Le cube déplacé est dans la bordure du haut
        if(i == 0 && (j != 0 || j != 4)){
            retour.add(new int[]{4,j});
            retour.add(new int[]{0,4});
            retour.add(new int[]{0,0});
        }
        //Le cube déplacé est dans la bordure du bas
        else if(i == 4 && (j != 4 || j != 0)){
            retour.add(new int[]{0,j});
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans la bordure de gauche
        else if((i != 0 || i != 4) && j == 0){
            retour.add(new int[]{i,4});
            retour.add(new int[]{4,0});
            retour.add(new int[]{0,0});
        }
        //Le cube déplacé est dans la bordure droite
        else if((i != 0 ||i != 4) && j == 4){
            retour.add(new int[]{i,0});
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans le corner haut gauche (0,0)
        else if(i == 0 && j == 0){
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans le corner haut gauche (0,0)
        else if(i == 0 && j == 4){
            retour.add(new int[]{0,0});
            retour.add(new int[]{4,4});
        }
        //Le cube déplacé est dans le corner haut gauche (0,0)
        else if(i == 4 && j == 0){
            retour.add(new int[]{0,0});
            retour.add(new int[]{0,4});
        }
        //Le cube déplacé est dans le corner haut gauche (0,0)
        else if(i == 4 && j == 4){
            retour.add(new int[]{0,4});
            retour.add(new int[]{4,0});
        }
        return retour;
    }
}

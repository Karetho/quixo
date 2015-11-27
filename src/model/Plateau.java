package model;


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
        //Le cube déplacé est dans la bordure du haut
        if(i == 0 && j != 0){

        }
        //Le cube déplacé est dans la bordure de gauche
        else if(i != 0 && j == 0){

        }
        //Le cube déplacé est
        else if(i != 4 && j == 4){

        }
        else if(i == 4 && j != 4){

        }
        return null;
    }
}

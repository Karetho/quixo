package model;

import java.io.Serializable;

/**
 * Created by nicolas on 20/11/2015.
 */
public class Cases  implements Serializable{

    /* ------------------------------------------------------
    *   Attributs de la classe Plateau                      *
    * ------------------------------------------------------*/

    private int figure;

    private final int NO_FIGURE = 0;
    private final int FIGURE_1 = 1;
    private final int FIGURE_2 = 2;
    private final int SUPPR_FIGURE = 3; //vide

    /* -----------------------------------------------------*
    *   Constructeur                                        *
    *------------------------------------------------------*/

    public Cases(){
        figure = NO_FIGURE;
    }

    /* -----------------------------------------------------*
    *   Méthodes get                                        *
    * ------------------------------------------------------*/

    public int getFigure() {
        return figure;
    }

    /* -----------------------------------------------------*
    *   Méthodes set                                         *
    * ------------------------------------------------------*/

    public void setFigure(int figure) {
        this.figure = figure;
    }
}

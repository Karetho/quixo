package model;

/**
 * Created by nicolas on 20/11/2015.
 */
public class Cases  {
    private int figure;

    private final int NO_FIGURE = 0;
    private final int FIGURE_1 = 1;
    private final int FIGURE_2 = 2;
    private final int SUPPR_FIGURE = 3; //vide

    public Cases(){
        figure = NO_FIGURE;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public int getFigure() {
        return figure;
    }
}

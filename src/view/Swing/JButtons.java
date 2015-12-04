package view.Swing;

import java.awt.*;

/**
 * Created by bobol on 27/11/15.
 */
public class JButtons extends javax.swing.JButton {

    private int posI;
    private int posY;

    public JButtons (int i, int j) {
        super();
        posI = i;
        posY = j;
        this.setPreferredSize(new Dimension(10,10));
    }

    public JButtons (int i){
        super();
        posI=i;
        this.setPreferredSize(new Dimension(80,80));
        this.setVisible(false);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }
}

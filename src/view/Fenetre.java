package view;
import model.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Roland on 13-Nov-15.
 */
public class Fenetre extends JFrame{
    public JButtons tab_button[][] = new JButtons[4][4];

    public Fenetre(){
        //this.plateau = plateau;
        creer_fenetre();
        pack();

        setSize(800,620);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void creer_fenetre(){
        JPanel grille = new JPanel();
        grille.setLayout(new GridLayout(5,5));
        for (int i=0; i<=4 ; i++){
            for (int j=0 ; j<=4 ; j++){
                tab_button[i][j]= new JButtons(i,j);
                grille.add(tab_button[i][j]);
            }
        }
        setContentPane(grille);
    }
}

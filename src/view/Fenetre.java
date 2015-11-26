package view;
import model.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Roland on 13-Nov-15.
 */
public class Fenetre extends JFrame{
   // public Plateau plateau;


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
                grille.add(new JButton());
            }
        }
        setContentPane(grille);
    }
}

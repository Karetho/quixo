package view;
import model.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Roland on 13-Nov-15.
 */
public class Fenetre extends JFrame{
    public JButtons tab_button_grille[][] = new JButtons[5][5];
    public JButtons tab_button_gauche[][] = new JButtons[5][1];
    public JButtons tab_button_droit[][] = new JButtons[5][1];
    public JButtons tab_button_haut[][] = new JButtons[1][7];
    public JButtons tab_button_bas[][] = new JButtons[1][7];

    public Fenetre(){
        //this.plateau = plateau;
        creer_fenetre();
        pack();

        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void creer_fenetre(){
        JPanel total = new JPanel();
        total.setLayout(new BorderLayout());

        //tableau de jeu au centre (bouton)
        JPanel grille = new JPanel();
        grille.setSize(new Dimension(200,200));
        grille.setLayout(new GridLayout(5,5));
        for (int i=0; i<=4 ; i++){
            for (int j=0 ; j<=4 ; j++){
                tab_button_grille[i][j]= new JButtons(i,j);
                grille.add(tab_button_grille[i][j]);
            }
        }

        //tableau de 5 bouton invisible a gauche du plateau
        JPanel panel_gauche = new JPanel();
        panel_gauche.setLayout(new GridLayout(5,1));
        for (int i=0; i<=4 ; i++) {
            tab_button_gauche[i][0]=new JButtons(i);
            panel_gauche.add(tab_button_gauche[i][0]);
            tab_button_gauche[i][0].setIcon(new ImageIcon("images/fleche_droit.jpg"));
        }

        //tableau de 5 bouton invisible a droite du plateau
        JPanel panel_droit = new JPanel();
        panel_droit.setLayout(new GridLayout(5,1));
        for (int i=0; i<=4 ; i++) {
            tab_button_droit[i][0]=new JButtons(i);
            panel_droit.add(tab_button_droit[i][0]);
            tab_button_droit[i][0].setIcon(new ImageIcon("images/fleche_gauche.jpg"));
        }

        //tableau de 5 bouton invisible en haut du plateau
        JPanel panel_haut = new JPanel();
        panel_haut.setLayout(new GridLayout(1,5));
        for (int i=0; i<=6 ; i++) {
            tab_button_haut[0][i]=new JButtons(i);
            panel_haut.add(tab_button_haut[0][i]);
            tab_button_haut[0][i].setIcon(new ImageIcon("images/fleche_bas.jpg"));
        }

        //tableau de 5 bouton invisible en bas du plateau
        JPanel panel_bas = new JPanel();
        panel_bas.setLayout(new GridLayout(1,7));
        for (int i=0; i<=6 ; i++) {
            tab_button_bas[0][i]=new JButtons(i);
            panel_bas.add(tab_button_bas[0][i]);
            tab_button_bas[0][i].setIcon(new ImageIcon("images/fleche_haut.jpg"));
        }


        total.add(grille, BorderLayout.CENTER);
        total.add(panel_gauche, BorderLayout.WEST);
        total.add(panel_droit, BorderLayout.EAST);
        total.add(panel_haut, BorderLayout.NORTH);
        total.add(panel_bas, BorderLayout.SOUTH);
        setContentPane(total);
    }
}

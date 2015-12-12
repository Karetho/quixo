package view;
import controller.ControlPlateau;
import model.Jeu;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.tiled.TiledMap;

public class Fenetre extends BasicGame {
    private ControlPlateau controlPlateau;
    private Jeu jeu;
    private Plateau plateau;
    private Image caseNeutre, caseRond, caseCroix, flecheDroite, flecheGauche, flecheHaut, flecheBas;
    private Image bouger;

    private float x = 0, y = 0;

    public Fenetre(ControlPlateau controlPlateau,Jeu jeu,Plateau plateau) throws SlickException {
        super("Quixo");
        this.controlPlateau = controlPlateau;
        this.jeu = jeu;
        this.plateau = plateau;
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        bouger = new Image("image/Troll.jpg");
        caseNeutre = new Image("image/caseNeutre.png");
        caseRond = new Image("image/caseRond.png");
        caseCroix = new Image("image/caseCroix.png");
        flecheDroite = new Image("image/FlecheDroite.png");
        flecheGauche = new Image("image/FlecheGauche.png");
        flecheHaut = new Image("image/FlecheHaut.png");
        flecheBas = new Image("image/FlecheBas.png");
        Input input = new Input(Input.MOUSE_LEFT_BUTTON);
        setInput(input);

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        for (int i = 0; i < 500;i = i + 100){
            for (int j = 0; j<500 ; j = j + 100){
                if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 0){
                    g.drawImage(caseNeutre,i+100,j+100);
                }
                else if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 1){
                    g.drawImage(caseRond,i+100,j+100);
                }
                else if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 2){
                    g.drawImage(caseCroix,i+100,j+100);
                }
                //caseNeutre.draw(i, j);
            }
        }
        caseNeutre.draw(x,y);
        controlPlateau.clickCases(container);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (x>=0&&y==0){
            x+=0.50;
        }
            if (x==600&& y>=0){
                y+=0.50;
            }
            if (x>=0&& y==600){
                x-=0.50;
            }
            if (x==0&& y<=600){
                y-=0.50;
            }

        //System.out.println("x = " + x);
    }


    public Image getCaseCroix() {
        return caseCroix;
    }
}
/*

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
*/

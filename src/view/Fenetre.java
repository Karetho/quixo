package view;
import controller.ControlPlateau;
import model.Jeu;
import model.Plateau;
import org.newdawn.slick.*;
import org.newdawn.slick.command.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Fenetre extends StateBasedGame {
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
    public void initStatesList(GameContainer gameContainer) throws SlickException {

        addState(new Menu_v(jeu));
        addState(new Jeu_v(controlPlateau,jeu,plateau));
    }
/*
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
        jeu.choixFigureJoueur(jeu.getJ1(),jeu.getJ2());
        System.out.println("figure du joueur1 = " + jeu.getJ1().getFigure());
        System.out.println("figure du joueur2 = " + jeu.getJ2().getFigure());
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
    }*/
}

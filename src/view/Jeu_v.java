package view;

import controller.ControlPlateau;
import model.Jeu;
import model.Plateau;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

/**
 * Created by Roland on 12-Dec-15.
 */
public class Jeu_v extends BasicGameState {
    // l'ID 1 correspond a la fenetre de jeu
    public static final int ID = 1;
    private StateBasedGame game;
    private ControlPlateau controlPlateau;
    private Jeu jeu;
    private Plateau plateau;
    private Image caseNeutre,ImageABouger, caseRond, caseCroix, flecheDroite, flecheGauche, flecheHaut, flecheBas, background;
    private Image bouger;
    float x = 0;
    float y = 0;

    public Jeu_v(ControlPlateau controlPlateau, Jeu jeu, Plateau plateau) throws SlickException {
        this.controlPlateau = controlPlateau;
        this.jeu = jeu;
        this.plateau = plateau;
    }
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        game = stateBasedGame;
        bouger = new Image("image/Troll.jpg");
        caseNeutre = new Image("image/caseNeutre.png");
        caseRond = new Image("image/caseRond.png");
        caseCroix = new Image("image/caseCroix.png");
        flecheDroite = new Image("image/FlecheDroite.png");
        flecheGauche = new Image("image/FlecheGauche.png");
        flecheHaut = new Image("image/FlecheHaut.png");
        background = new Image("image/Fond.jpg");
        flecheBas = new Image("image/FlecheBas.png");
        Input input = new Input(Input.MOUSE_LEFT_BUTTON);
        setInput(input);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        controlPlateau.clickCases(gameContainer,graphics, stateBasedGame);
        background.draw(0,0,gameContainer.getHeight(),gameContainer.getWidth());
        for (int i = 0; i < 500;i = i + 100){
            for (int j = 0; j<500 ; j = j + 100){
                if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 0){
                    graphics.drawImage(caseNeutre,i+100,j+100);
                }
                else if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 1){
                    graphics.drawImage(caseRond,i+100,j+100);
                }
                else if(plateau.getPlateauIJ(i/100,j/100).getFigure() == 2){
                    graphics.drawImage(caseCroix,i+100,j+100);
                }
            }
        }
        if(jeu.getJ1().getDejaJoue()){
            graphics.drawString(jeu.getJ2().getNomJoueur()+" de jouer",800,200);
        }else if(jeu.getJ2().getDejaJoue()){
            graphics.drawString(jeu.getJ1().getNomJoueur()+" de Jouer",800,200);
        }
        graphics.setColor(Color.white);
        graphics.drawString(jeu.getJ1().getNomJoueur(),725,250);
        graphics.drawString(jeu.getJ2().getNomJoueur(),925,250);
        if(jeu.getJ1().getFigure() == 1){
            graphics.drawImage(caseRond,725,300);
        }else if(jeu.getJ1().getFigure() == 2){
            graphics.drawImage(caseCroix,725,300);
        }
        if(jeu.getJ2().getFigure() == 1){
            graphics.drawImage(caseRond,925,300);
        }else if(jeu.getJ2().getFigure() == 2){
            graphics.drawImage(caseCroix,925,300);
        }
        caseNeutre.draw(x,y);
    }
    /*
        TODO : Faire l'animation de translation pour la méthode bougerPiece apres qu'il soit corrigé
     */
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


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
//           ImageABouger = new Image(Math.floorDiv(Mouse.getDX(),),);
//
//        public int Arrondir(float n){
//            n=n/100;
//
//            Math.round(n);
//            n=(int)n*100;
//            return n;
//        }


/*
        Faire une fonction qui : regarde par rapport au deuxieme click si le x ou le y est compris entre celui
        de base pour savoir si on translate a droite/gauche ou haut/bas.
        Je pense donc cree des fonctions qui arrondissent pour reinitialiser x et y pour eviter tout decalages
        Ensuite on prend la ligne dans le gamecontener (creation d'une image temporaire a priori) je sais pas ou la cree lol

        LA METHODE POUR ARRONDIR





    CREATION DE LA LIGNE A BOUGER
Il faut tout d'abord regarder ou est le premier click par rapport a x et a y et ensuite faire
une difference pour faire bouger

Donc comparer x mouse_pressed, y mouse_pressed donc utiliser Arrondir

        try {
            ImageABouger = new Image(Arrondir(x),Arrondir(y));
        } catch(SlickException e) {
            Log.error("creating local image or graphics context failed: " + e.getMessage());
        }
*/




        //System.out.println("x = " + x);
    }
}


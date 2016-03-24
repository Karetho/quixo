package controller;

import model.Jeu;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import view.*;

/**
 * Created by Roland on 03-Mar-16.
 */
public class ControlAccueil {

    private Input input;
    private float x,y;

    public ControlAccueil(){

    }

    public void choisirMenu(GameContainer gameContainer,StateBasedGame game) {
        input = gameContainer.getInput();
        x = input.getMouseX();
        y = input.getMouseY();
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            if(x >= 590 && x <=670 && y >= 250 && y <=285){
                game.enterState(Menu_v.ID);
            }else if(x >= 590 && x <=670 && y >= 295 && y <=320){
                game.enterState(Multi_v.ID);
            }
            else if(x >= 590 && x <=670 &&y >= 350 && y <=385){
                gameContainer.exit();
            }
        }
    }
}

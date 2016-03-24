package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import view.Accueil_v;

/**
 * Created by Roland on 24-Mar-16.
 */
public class ControlMulti {
    private Input input;
    private float x,y;

    public ControlMulti(){

    }

    public void choisirMenu(GameContainer gameContainer, StateBasedGame game) {
        input = gameContainer.getInput();
        x = input.getMouseX();
        y = input.getMouseY();
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            if(x >= 800 && x <=880 && y >= 290 && y <=340){
                // créer le serveur
            }else if(x >= 590 && x <=670 && y >= 290 && y <=340){
                // créer le client
            }
            else if(x >= 690 && x <=770 &&y >= 390 && y <=440){
                game.enterState(Accueil_v.ID);
            }
        }
    }
}

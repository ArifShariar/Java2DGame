package states;

import tileGame.Game;
import tileGame.Handler;

import java.awt.*;

public abstract class State {

    // CAN BE PUT IN A SEPARATE CLASS (not necessary)
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    // ABSTRACT METHODS
    public abstract void update();
    public abstract void render(Graphics g);
}

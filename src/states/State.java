package states;

import tileGame.Game;

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
    protected Game game;
    public State(Game game){
        this.game = game;
    }

    // ABSTRACT METHODS
    public abstract void update();
    public abstract void render(Graphics g);
}

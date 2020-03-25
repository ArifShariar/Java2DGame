package states;

import graphics.Assets;
import tileGame.Game;
import tileGame.Handler;

import javax.swing.text.ChangedCharSetException;
import java.awt.*;

public class MenuState extends State {
    public MenuState(Handler handler){
        super(handler);
    }
    @Override
    public void update() {
        if (handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {

    }
}

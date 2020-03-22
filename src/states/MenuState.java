package states;

import graphics.Assets;
import tileGame.Game;
import tileGame.Handler;

import java.awt.*;

public class MenuState extends State {
    public MenuState(Handler handler){
        super(handler);
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,100,100,null);
    }
}

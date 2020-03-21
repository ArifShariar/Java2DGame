package states;

import graphics.Assets;
import tileGame.Game;

import java.awt.*;

public class MenuState extends State {
    public MenuState(Game game){
        super(game);
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,100,100,null);
    }
}

package states;

import graphics.Assets;

import java.awt.*;

public class MenuState extends State {
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,100,100,null);
    }
}

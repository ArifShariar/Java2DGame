package states;

import graphics.Assets;

import java.awt.*;

public class GameState extends State{

    public GameState(){

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.grass,100,100,null);
    }
}

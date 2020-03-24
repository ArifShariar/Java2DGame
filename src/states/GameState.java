package states;

import tileGame.Handler;

import worlds.World;

import java.awt.*;

public class GameState extends State{

    private World world;


    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/world/world1.txt");
        handler.setWorld(world);


    }

    @Override
    public void update() {
        world.update();


    }

    @Override
    public void render(Graphics g) {
        world.render(g);


    }
}

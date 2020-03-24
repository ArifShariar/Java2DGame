package states;

import entity.Player;
import graphics.Assets;
import tileGame.Game;
import tileGame.Handler;
import tiles.Tile;
import worlds.World;

import java.awt.*;

public class GameState extends State{
    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/world/world1.txt");
        handler.setWorld(world);
        player = new Player(handler,584,584);
    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}

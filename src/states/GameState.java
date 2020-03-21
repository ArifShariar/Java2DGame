package states;

import entity.Player;
import graphics.Assets;
import tileGame.Game;
import tiles.Tile;

import java.awt.*;

public class GameState extends State{
    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {

        Tile.tileArray[0].render(g,10,10);
        Tile.tileArray[2].render(g,100,10);
        player.render(g);
    }
}

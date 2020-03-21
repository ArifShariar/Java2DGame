package states;

import entity.Player;
import graphics.Assets;
import tileGame.Game;

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
        player.render(g);
    }
}

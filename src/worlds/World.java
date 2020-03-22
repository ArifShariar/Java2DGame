package worlds;

import tileGame.Game;
import tiles.Tile;
import utilities.Utils;

import java.awt.*;

public class World {
    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Game game, String path){
        this.game = game;
        loadWorld(path);
    }
    public void update(){

    }
    public void render(Graphics g){
        int xStart = (int) Math.max(0,game.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width,(game.getGameCamera().getxOffset()+game.getWidth())/Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, game.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd = (int)Math.min(height,(game.getGameCamera().getyOffset()+game.getHeight())/Tile.TILE_HEIGHT+1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x,y).render(g,(int)(x*Tile.TILE_WIDTH-game.getGameCamera().getxOffset()),(int)(y*Tile.TILE_HEIGHT-game.getGameCamera().getyOffset()));
            }
        }
    }
    public Tile getTile(int x, int y){
        Tile tile = Tile.tileArray[tiles[x][y]];
        if(tile==null){
            return Tile.dirtTile;
        }
        return tile;
    }
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens =file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }


    }
}

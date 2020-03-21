package worlds;

import tiles.Tile;

import java.awt.*;

public class World {
    private int width, height;
    private int[][] tiles;

    public World(String path){
        loadWorld(path);
    }
    public void update(){

    }
    public void render(Graphics g){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x,y).render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
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

    }
}

package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    // static

    
    public static Tile[] tileArray = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile stoneTile = new StoneTile(2);


    // main class
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;


    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tileArray[id] = this;
    }
    public void update(){

    }
    public void render(Graphics g, int x,int y){
        g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT, null);
    }
    public boolean isSolid(){
        return false;// if false, then can walk on it
    }

    public int getId(){
        return id;
    }
}

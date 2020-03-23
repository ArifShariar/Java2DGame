package tiles;

import graphics.Assets;

public class BrickTile extends Tile {
    public BrickTile(int id) {
        super(Assets.brick,id);
    }
    @Override
    public boolean isSolid(){
        return true;// if true, then can't walk on it
    }
}

package tiles;

import graphics.Assets;

public class WaterTile extends Tile {
    public WaterTile(int id) {
        super(Assets.water, id);
    }
    @Override
    public boolean isSolid(){
        return true;// if true, then can't walk on it
    }

}

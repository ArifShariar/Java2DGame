package tiles;

import graphics.Assets;

public class StoneTile extends Tile {
    public StoneTile(int id) {
        super(Assets.stone, id);
    }
    @Override
    public boolean isSolid(){
        return true;// if true, then can't walk on it
    }

}

package tiles;

import graphics.Assets;

public class LavaTile extends Tile {
    public LavaTile(int id) {
        super(Assets.lava,id);
    }
    @Override
    public boolean isSolid(){
        return true;// if true, then can't walk on it
    }
}

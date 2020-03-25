package entity.staticEntities;

import graphics.Assets;
import tileGame.Handler;
import tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 300;
        bounds.y = (int) (height/1.5f);
        bounds.width = width -460;
        bounds.height = (int) (height - height/1.5f);


    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,(int)(x-handler.getGameCamera().getxOffset()),
                (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
      /*    g.setColor(Color.RED);
          g.fillRect((int)(x + bounds.x-handler.getGameCamera().getxOffset()),
              (int)(y + bounds.y-handler.getGameCamera().getyOffset()),
            bounds.width, bounds.height);*/
    }
}

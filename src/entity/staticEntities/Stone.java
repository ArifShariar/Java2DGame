package entity.staticEntities;

import graphics.Assets;
import tileGame.Handler;
import tiles.Tile;

import java.awt.*;

public class Stone extends StaticEntity{
    public Stone(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 50;
        bounds.y = (int) (height/1.5f);
        bounds.width = width-100;
        bounds.height = (int) (height - height/1.5f);


    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stone,(int)(x-handler.getGameCamera().getxOffset()),
                (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
       /*   g.setColor(Color.RED);
          g.fillRect((int)(x + bounds.x-handler.getGameCamera().getxOffset()),
              (int)(y + bounds.y-handler.getGameCamera().getyOffset()),
            bounds.width, bounds.height);*/
    }
}

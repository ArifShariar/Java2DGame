package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage dirt, grass, water, tree,player,stone,lava, brick;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet.png"));
         dirt = sheet.crop(0,0,width,height);
         grass = sheet.crop(width, 0, width, height);
         water = sheet.crop(2*width, 0, width, height);
         tree = sheet.crop(3*width,0, width, height);
         player = sheet.crop(0, height, width, height);
         stone =sheet.crop(width, height,width,height);
         lava = sheet.crop(2*width,height,width,height);
         brick = sheet.crop(3*width, height, width, height);

    }
}

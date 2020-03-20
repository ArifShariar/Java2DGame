package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage dirt, grass, water, tree;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sheet.png"));
         dirt = sheet.crop(0,0,width,height);
         grass = sheet.crop(width, 0, width, height);
         water = sheet.crop(2*width, 0, width, height);
         tree = sheet.crop(3*width,0, width, height);
    }
}

package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 584, height = 584;
    public static BufferedImage dirt, grass, water, tree,stone,lava, brick,player;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_left;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Animationtest.png"));

        player_right = new BufferedImage[6];
        player_right[0] = sheet2.crop(0,0,width, height);
        player_right[1] = sheet2.crop(width,0,width, height);
        player_right[2] = sheet2.crop(width*2,0,width, height);
        player_right[3] = sheet2.crop(width*3,0,width, height);
        player_right[4] = sheet2.crop(width*4,0,width, height);
        player_right[5] = sheet2.crop(width*5,0,width, height);

        player_left = new BufferedImage[6];
        player_left[0] = sheet2.crop(0, height,width,height);
        player_left[1] = sheet2.crop(width, height,width,height);
        player_left[2] = sheet2.crop(width*2, height,width,height);
        player_left[3] = sheet2.crop(width*3, height,width,height);
        player_left[4] = sheet2.crop(width*4, height,width,height);
        player_left[5] = sheet2.crop(width*5, height,width,height);

        player_up = new BufferedImage[6];
        player_up[0] = sheet2.crop(0, height*2, width, height);
        player_up[1] = sheet2.crop(width, height*2, width, height);
        player_up[2] = sheet2.crop(width*2, height*2, width, height);
        player_up[3] = sheet2.crop(width*3, height*2, width, height);
        player_up[4] = sheet2.crop(width*4, height*2, width, height);
        player_up[5] = sheet2.crop(width*5, height*2, width, height);

        player_down = new BufferedImage[6];
        player_down[0] =sheet2.crop(0,3*height,width,height);
        player_down[1] =sheet2.crop(width,3*height,width,height);
        player_down[2] =sheet2.crop(width*2,3*height,width,height);
        player_down[3] =sheet2.crop(width*3,3*height,width,height);
        player_down[4] =sheet2.crop(width*4,3*height,width,height);
        player_down[5] =sheet2.crop(width*5,3*height,width,height);



        dirt = sheet.crop(0,0,width,height);
        grass = sheet.crop(width, 0, width, height);
        water = sheet.crop(2*width, 0, width, height);
        tree = sheet.crop(3*width,0, width, height);
        stone =sheet.crop(width, height,width,height);
        lava = sheet.crop(2*width,height,width,height);
        brick = sheet.crop(3*width, height, width, height);



    }
}

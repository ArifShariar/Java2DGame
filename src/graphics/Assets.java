package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 584, height = 584;
    public static BufferedImage dirt, grass, water, tree,stone,lava, brick;

    public static BufferedImage[] player_up;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_left;

    public static BufferedImage[] player_idle;

    public static BufferedImage[] attack1Right;
    public static BufferedImage[] attack1Left;

    public static BufferedImage[] button_start;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/FinalTest.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/WalkAnimation.png"));
        SpriteSheet idle = new SpriteSheet(ImageLoader.loadImage("/textures/IdleAnimation.png"));
        SpriteSheet attackSheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/Attack1Right.png"));
        SpriteSheet attackSheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Attack1Left.png"));

        player_right = new BufferedImage[6];
        player_right[0] = sheet2.crop(width,height,width, height);
        player_right[1] = sheet2.crop(width*2,height,width, height);
        player_right[2] = sheet2.crop(width*3,height,width, height);
        player_right[3] = sheet2.crop(width*4,height,width, height);
        player_right[4] = sheet2.crop(width*5,height,width, height);
        player_right[5] = sheet2.crop(width*6,height,width, height);

        player_left = new BufferedImage[6];
        player_left[0] = sheet2.crop(width, height*2,width,height);
        player_left[1] = sheet2.crop(width*2, height*2,width,height);
        player_left[2] = sheet2.crop(width*3, height*2,width,height);
        player_left[3] = sheet2.crop(width*4, height*2,width,height);
        player_left[4] = sheet2.crop(width*5, height*2,width,height);
        player_left[5] = sheet2.crop(width*6, height*2,width,height);

        player_up = new BufferedImage[6];
        player_up[0] = sheet2.crop(width, height*3, width, height);
        player_up[1] = sheet2.crop(width*2, height*3, width, height);
        player_up[2] = sheet2.crop(width*3, height*3, width, height);
        player_up[3] = sheet2.crop(width*4, height*3, width, height);
        player_up[4] = sheet2.crop(width*5, height*3, width, height);
        player_up[5] = sheet2.crop(width*6, height*3, width, height);

        player_down = new BufferedImage[6];
        player_down[0] =sheet2.crop(width,height*4,width,height);
        player_down[1] =sheet2.crop(width*2,height*4,width,height);
        player_down[2] =sheet2.crop(width*3,height*4,width,height);
        player_down[3] =sheet2.crop(width*4,height*4,width,height);
        player_down[4] =sheet2.crop(width*5,height*4,width,height);
        player_down[5] =sheet2.crop(width*6,height*4,width,height);



        player_idle = new BufferedImage[4];
        player_idle[0]=idle.crop(width, height, width, height);
        player_idle[1]=idle.crop(width*2, height, width, height);
        player_idle[2]=idle.crop(width*3, height, width, height);
        player_idle[3]=idle.crop(width*4, height, width, height);

        attack1Right = new BufferedImage[11];
        attack1Right[0] = attackSheet1.crop(width, height, width, height);
        attack1Right[1] = attackSheet1.crop(width*2, height, width, height);
        attack1Right[2] = attackSheet1.crop(width*3, height, width, height);
        attack1Right[3] = attackSheet1.crop(width*4, height, width, height);
        attack1Right[4] = attackSheet1.crop(width*5, height, width, height);
        attack1Right[5] = attackSheet1.crop(width*6, height, width, height);
        attack1Right[6] = attackSheet1.crop(width*7, height, width, height);
        attack1Right[7] = attackSheet1.crop(width*8, height, width, height);
        attack1Right[8] = attackSheet1.crop(width*9, height, width, height);
        attack1Right[9] = attackSheet1.crop(width*10, height, width, height);
        attack1Right[10] = attackSheet1.crop(width*11, height, width, height);

        attack1Left = new BufferedImage[11];
        attack1Left[0] = attackSheet2.crop(width, height, width, height);
        attack1Left[1] = attackSheet2.crop(width*2, height, width, height);
        attack1Left[2] = attackSheet2.crop(width*3, height, width, height);
        attack1Left[3] = attackSheet2.crop(width*4, height, width, height);
        attack1Left[4] = attackSheet2.crop(width*5, height, width, height);
        attack1Left[5] = attackSheet2.crop(width*6, height, width, height);
        attack1Left[6] = attackSheet2.crop(width*7, height, width, height);
        attack1Left[7] = attackSheet2.crop(width*8, height, width, height);
        attack1Left[8] = attackSheet2.crop(width*9, height, width, height);
        attack1Left[9] = attackSheet2.crop(width*10, height, width, height);
        attack1Left[10] = attackSheet2.crop(width*11, height, width, height);



        dirt = sheet.crop(0,0,width,height);
        grass = sheet.crop(width, 0, width, height);
        water = sheet.crop(2*width, 0, width, height);
        tree = sheet.crop(3*width,0, width, height);
        stone =sheet.crop(width, height,width,height);
        lava = sheet.crop(2*width,height,width,height);
        brick = sheet.crop(3*width, height, width, height);

        button_start = new BufferedImage[2];
        button_start[0] = sheet.crop(0, 2*height, width,height);
        button_start[1] = sheet.crop(width, 2*height, width, height);



    }
}

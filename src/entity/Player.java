package entity;

import graphics.Animation;
import graphics.Assets;
import tileGame.Game;
import tileGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{
    // Animation
    private Animation animationDown;
    private Animation animationUp;
    private Animation animationLeft;
    private Animation animationRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 14;
        bounds.y = 32;
        bounds.width = 30;
        bounds.height = 12; // change according to player size

        animationDown = new Animation(166,Assets.player_down);
        animationUp = new Animation(166,Assets.player_up);
        animationLeft = new Animation(166,Assets.player_left);
        animationRight = new Animation(166,Assets.player_right);
    }

    @Override
    public void update() {
        animationDown.update();
        animationUp.update();
        animationRight.update();
        animationLeft.update();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up){
            yMove = -speed;
        }
        if (handler.getKeyManager().down){
            yMove = +speed;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
        }
        if (handler.getKeyManager().right){
            xMove = +speed;
        }
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGameCamera().getxOffset()),
                (int)(y-handler.getGameCamera().getyOffset()),
                width,height,null);
       // g.setColor(Color.RED);
        //g.fillRect((int)(x + bounds.x-handler.getGameCamera().getxOffset()),
          //      (int)(y + bounds.y-handler.getGameCamera().getyOffset()),
            //    bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove<0){
            return animationLeft.getCurrentFrame();
        }
        else if (xMove>0){
            return animationRight.getCurrentFrame();
        }
        else if(yMove<0){
            return animationUp.getCurrentFrame();
        }
        else {
            return animationDown.getCurrentFrame();
        }

    }
}

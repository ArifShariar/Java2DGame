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
    private Animation animationIdle;
    private Animation animationAttack1;

    // ATTACK TIMER
    private long lastAttackTimer, attackCoolDown = 800, attackTimer = attackCoolDown;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 130;
        bounds.y = 150;
        bounds.width = 40;
        bounds.height = 40; // change according to player size

        animationDown = new Animation(166,Assets.player_down);
        animationUp = new Animation(166,Assets.player_up);
        animationLeft = new Animation(166,Assets.player_left);
        animationRight = new Animation(166,Assets.player_right);
        animationIdle = new Animation(166, Assets.player_idle);
        animationAttack1 = new Animation(200, Assets.attack1);
    }

    @Override
    public void update() {
        animationDown.update();
        animationUp.update();
        animationRight.update();
        animationLeft.update();
        animationIdle.update();
        animationAttack1.update();


        // MOVEMENT
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        // ATTACK
        checkAttack();
    }

    private void checkAttack(){
        attackTimer +=System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer<attackCoolDown)
            return;
        Rectangle collisionBounds = getCollisionBound(0,0);
        Rectangle attackRectangle = new Rectangle();
        int arSize = 20;
        attackRectangle.width = arSize;
        attackRectangle.height = arSize;

        if (handler.getKeyManager().aUp){
            attackRectangle.x = collisionBounds.x + collisionBounds.width/2 - arSize/2;
            attackRectangle.y = collisionBounds.y - arSize;
        }
        else if(handler.getKeyManager().aDown){
            attackRectangle.x = collisionBounds.x + collisionBounds.width/2 - arSize/2;
            attackRectangle.y = collisionBounds.y + collisionBounds.height;

        }
        else if(handler.getKeyManager().aLeft){
            attackRectangle.x = collisionBounds.x - arSize;
            attackRectangle.y = collisionBounds.y + collisionBounds.height/2 - arSize/2;

        }
        else if(handler.getKeyManager().aRight){
            attackRectangle.x = collisionBounds.x + collisionBounds.width;
            attackRectangle.y = collisionBounds.y + collisionBounds.height/2 - arSize/2;
        }
        else{
            return;
        }
        attackTimer = 0;
        for (Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBound(0,0).intersects(attackRectangle)){
                e.hurt(1);
                return;
            }
        }

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
      // g.fillRect((int)(x + bounds.x-handler.getGameCamera().getxOffset()),
         //      (int)(y + bounds.y-handler.getGameCamera().getyOffset()),
          //     bounds.width, bounds.height);
   }

    public void die(){
        System.out.println("YOu dEAD");
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
        else if(yMove>0) {
            return animationDown.getCurrentFrame();
        }
        else{
            if (handler.getKeyManager().aUp || handler.getKeyManager().aRight || handler.getKeyManager().aLeft || handler.getKeyManager().aDown){
                return  animationAttack1.getCurrentFrame();
            }
            return animationIdle.getCurrentFrame();
        }

    }
}

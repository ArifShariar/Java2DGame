package tileGame;

import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;
    Random rand = new Random();
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;


    private boolean running = false;
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();
    }
    int x = 0;
    private void update(){
        x = x+ 1;
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,width, height);

        g.drawImage(Assets.dirt,x,25,null);



        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        int fps  = 60;
        double timePerUpdate = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int tick = 0;

        while (running){
            now = System.nanoTime();
            delta = delta+(now-lastTime)/timePerUpdate;
            timer += now-lastTime;
            lastTime = now;

            if (delta>=1) {
                update();
                render();
                tick++;
                delta--;
            }
            /* fps counter
            if (timer>=1000000000){
                System.out.println("tick::: "+tick);
                tick = 0;
                timer = 0;
            }
             */
        }
        stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

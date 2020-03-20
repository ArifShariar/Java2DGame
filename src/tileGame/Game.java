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

    private void update(){

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,width, height);

        g.drawImage(Assets.dirt,25,25,null);



        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        while (running){
            update();
            render();
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

package tileGame;

import graphics.ImageLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage test1;
    private SpriteSheet sheet;

    private boolean running = false;
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
        test1 = ImageLoader.loadImage("/textures/Sheet.png");
        sheet = new SpriteSheet(test1);
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

        g.drawImage(sheet.crop(0,0,140,140),5,5,null);
        g.drawImage(sheet.crop(140,0,140,140),300,300,null);

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

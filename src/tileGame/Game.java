package tileGame;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;

    private Thread thread;

    private boolean running = false;
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
    }

    private void update(){

    }
    private void render(){

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

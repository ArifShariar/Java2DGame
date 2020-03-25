package ui;

import tileGame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UiManager {
    private Handler handler;
    public ArrayList<UiObject> objects;
    public UiManager(Handler handler){
        this.handler = handler;
        objects = new ArrayList<UiObject>();
    }
    public void update(){
        for (UiObject o:objects) {
            o.update();
        }

    }
    public void render(Graphics g){
        for (UiObject o:objects) {
            o.render(g);
        }

    }
    public void onMouseMove(MouseEvent e){
        for (UiObject o:objects) {
            o.onMouseMove(e);
        }

    }
    public void onMouseRelease(MouseEvent e){
        for (UiObject o:objects) {
            o.onMouseRelease(e);
        }

    }
    public void addObject(UiObject object){
        objects.add(object);
    }
    public void removeObject(UiObject object){
        objects.remove(object);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UiObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UiObject> objects) {
        this.objects = objects;
    }
}

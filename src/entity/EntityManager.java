package entity;

import tileGame.Handler;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Player player;

    private ArrayList<Entity> entities;

    private Comparator<Entity>renderSort = new Comparator<Entity>() {
        @Override
        public int compare(Entity e1, Entity e2) {
            if(e1.getY()+e1.getHeight()< e2.getY() + e2.getHeight()){
                return  -1;
            }else {
                return 1;
            }
        }
    };
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);

    }
    public void update(){
        Iterator<Entity> ent = entities.iterator();
        while (ent.hasNext()){
            Entity e = ent.next();
            e.update();
            if (!e.isActive()){
                ent.remove();
            }
        }
        entities.sort(renderSort);

    }
    public void render(Graphics g){
        for (Entity e:entities) {
            e.render(g);
        }

    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    // GETTER AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}

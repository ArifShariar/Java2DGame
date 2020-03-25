package states;

import graphics.Assets;
import tileGame.Handler;
import ui.ClickListener;
import ui.UiImageButton;
import ui.UiManager;

import java.awt.*;

public class MenuState extends State {
    private UiManager uiManager;
    public MenuState(Handler handler){
        super(handler);
        // PLAY BUTTON
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UiImageButton(200, 200, 400, 400, Assets.button_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }
    @Override
    public void update() {
        uiManager.update();

    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

    }
}

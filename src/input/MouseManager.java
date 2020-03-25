package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;


    public MouseManager(){

    }
    // GETTER
    public boolean isLeftPressed(){
        return leftPressed;
    }
    public  boolean isRightPressed(){
        return rightPressed;
    }
    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }
        else if (mouseEvent.getButton() == MouseEvent.BUTTON2){
            rightPressed = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            leftPressed = false;
        }
        else if (mouseEvent.getButton() == MouseEvent.BUTTON2){
            rightPressed = false;
        }

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

    }
}

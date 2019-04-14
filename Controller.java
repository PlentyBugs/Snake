package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Window window;

    public Controller(Window window){
        this.window = window;
        window.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            moveToLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            moveToRight();
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            moveToTop();
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            moveToBot();
        }
        window.drawWindow();
    }

    private void moveToTop() {
        if(window.getMap().getSnake().getDirection() != 3)
            window.getMap().getSnake().setDirection(1);
    }

    private void moveToBot() {
        if(window.getMap().getSnake().getDirection() != 1)
            window.getMap().getSnake().setDirection(3);
    }

    private void moveToRight() {
        if(window.getMap().getSnake().getDirection() != 4)
            window.getMap().getSnake().setDirection(2);
    }

    private void moveToLeft() {
        if(window.getMap().getSnake().getDirection() != 2)
            window.getMap().getSnake().setDirection(4);
    }
}

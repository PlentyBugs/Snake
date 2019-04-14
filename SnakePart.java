package Snake;

import java.awt.*;

public class SnakePart extends Cell{
    private SnakePart previousPart;
    private SnakePart nextPart;
    protected int direction;
    protected int lastX;
    protected int lastY;

    public SnakePart(){
        color = Color.green;
        setBackground(color);
    }

    public SnakePart(SnakePart previousPart){
        this();
        this.previousPart = previousPart;
        previousPart.setNextPart(this);
    }

    public void setNextPart(SnakePart nextPart) {
        this.nextPart = nextPart;
    }

    public SnakePart getNextPart() {
        return nextPart;
    }

    public SnakePart setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        return this;
    }

    public SnakePart setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
        return this;
    }

    public SnakePart moveSnake(SnakePart snakePart){
        snakePart.setLastX(snakePart.getXCoordinate());
        snakePart.setLastY(snakePart.getYCoordinate());

        Map.move(snakePart, Map.getMap()[snakePart.getPreviousPart().getLastY()][snakePart.getPreviousPart().getLastX()]);

        if(snakePart.getNextPart() == null)
            return snakePart;
        else {
            return moveSnake(snakePart.getNextPart());
        }
    }

    public SnakePart setDirection(int direction) {
        this.direction = direction;
        return this;
    }

    public int getDirection() {
        return direction;
    }

    public SnakePart getPreviousPart() {
        return previousPart;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }
}

package Snake;

import java.awt.*;

public class SnakeHead extends SnakePart{
    private SnakePart nextPart;
    /*
    1 == up
    2 == right
    3 == down
    4 == left
    */

    public SnakeHead(){
        color = new Color(0, 159,0);
        setBackground(color);
        direction = 1;
    }

    public void setNextPart(SnakePart nextPart) {
        this.nextPart = nextPart;
    }

    public SnakePart getNextPart() {
        return nextPart;
    }

    public SnakeHead setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        return this;
    }

    public SnakeHead setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
        return this;
    }

    public SnakePart getTail(SnakePart snakePart){
        if(snakePart.getNextPart() == null)
            return snakePart;
        else
            return getTail(snakePart.getNextPart());
    }
}

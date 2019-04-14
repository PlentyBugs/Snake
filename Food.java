package Snake;

import java.awt.*;

public class Food extends Cell{

    public Food(){
        color = Color.red;
        setBackground(color);
    }

    public Food setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        return this;
    }

    public Food setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
        return this;
    }
}

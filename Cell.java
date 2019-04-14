package Snake;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    protected Color color;
    protected String name;
    protected int xCoordinate;
    protected int yCoordinate;

    public Cell(){
        setEnabled(false);
        cellSize(512/Game.SIZE,512/Game.SIZE);
    }

    public void cellSize(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }

    public Color getColor() {
        return color;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Cell setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
        return this;
    }

    public Cell setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
        return this;
    }
}

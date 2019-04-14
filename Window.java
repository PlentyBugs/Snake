package Snake;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Map map;

    public Window(Map map){
        super("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.map = map;
        map.setWindow(this);

        drawWindow();
    }

    public void drawWindow(){
        getContentPane().removeAll();

        JPanel gamePanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(1, 1, 1, 1);

        Cell[][] cells = map.getMap();
        for(int i = 0; i < Game.SIZE; i++) {
            for (int j = 0; j < Game.SIZE; j++) {
                constraints.gridy = i;
                constraints.gridx = j;
                gamePanel.add(cells[i][j], constraints);
            }
        }

        getContentPane().add(gamePanel);
        pack();
        setVisible(true);
    }

    public Map getMap() {
        return map;
    }
}

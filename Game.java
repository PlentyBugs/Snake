package Snake;

public class Game {

    public static final int SIZE = 30;
    public static final int DELAY = 200; // Milliseconds

    public static void main(String[] args){
        new Controller(new Window(new Map()));
    }
}

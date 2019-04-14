package Snake;

public class Map extends Thread{

    private static Cell[][] map;
    private SnakeHead snake;
    private Window window;

    public Map(){
        map = new Cell[Game.SIZE][Game.SIZE];
        for(int i = 0; i < Game.SIZE; i++) {
            for (int j = 0; j < Game.SIZE; j++) {
                map[i][j] =
                        new Cell()
                        .setXCoordinate(j)
                        .setYCoordinate(i);
            }
        }

        int x = (int)(Math.random()*(Game.SIZE-1));
        int y = (int)(Math.random()*(Game.SIZE-1));
        snake = new SnakeHead()
                        .setXCoordinate(x)
                        .setYCoordinate(y);

        int dX = 0;
        int dY = 0;
        if(snake.getDirection() == 1)
            dY = 1;
        if(snake.getDirection() == 2)
            dX = -1;
        if(snake.getDirection() == 3)
            dY = -1;
        if(snake.getDirection() == 4)
            dX = 1;

        SnakePart snakePart = new SnakePart(snake).setYCoordinate(snake.getYCoordinate()+dY).setXCoordinate(snake.getXCoordinate()+dX);
        snake.setNextPart(snakePart);

        map[snake.getYCoordinate()+dY][snake.getXCoordinate()+dX] = snakePart;
        map[y][x] = snake;

        spawnFood();

        start();
    }

    public static Cell[][] getMap() {
        return map;
    }

    public void spawnFood(){
        boolean foodOnMap = false;
        while (!foodOnMap){
            int x = (int)(Math.random()*Game.SIZE);
            int y = (int)(Math.random()*Game.SIZE);
            if(!(map[y][x] instanceof SnakePart)){
                foodOnMap = true;
                map[y][x] =
                        new Food()
                        .setXCoordinate(x)
                        .setYCoordinate(y);
            }
        }
    }

    public void run(){
        while (true){
            moveSnake();
            if(window != null)
                window.drawWindow();
            try {
                sleep(Game.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveSnake(){
        int dX = 0;
        int dY = 0;
        if(snake.getDirection() == 1)
            dY = -1;
        if(snake.getDirection() == 2)
            dX = 1;
        if(snake.getDirection() == 3)
            dY = 1;
        if(snake.getDirection() == 4)
            dX = -1;

        int newX = snake.getXCoordinate()+dX;
        int newY = snake.getYCoordinate()+dY;

        if(snake.getYCoordinate()+dY < 0)
            newY = Game.SIZE-1;
        if(snake.getYCoordinate()+dY >= Game.SIZE)
            newY = 0;
        if(snake.getXCoordinate()+dX < 0)
            newX = Game.SIZE-1;
        if(snake.getXCoordinate()+dX >= Game.SIZE)
            newX = 0;

        if(map[newY][newX] instanceof Food){
            map[newY][newX] = new Cell()
                    .setXCoordinate(newX)
                    .setYCoordinate(newY);

            SnakePart snakeTail = snake.getTail(snake);
            int dXT = 0;
            int dYT = 0;
            if(snakeTail.getDirection() == 1)
                dYT = -1;
            if(snakeTail.getDirection() == 2)
                dXT = 1;
            if(snakeTail.getDirection() == 3)
                dYT = 1;
            if(snakeTail.getDirection() == 4)
                dXT = -1;

            int newXT = snakeTail.getXCoordinate()+dX;
            int newYT = snakeTail.getYCoordinate()+dY;

            if(snakeTail.getYCoordinate()+dY < 0)
                newYT = Game.SIZE-1;
            if(snakeTail.getYCoordinate()+dY >= Game.SIZE)
                newYT = 0;
            if(snakeTail.getXCoordinate()+dX < 0)
                newXT = Game.SIZE-1;
            if(snakeTail.getXCoordinate()+dX >= Game.SIZE)
                newXT = 0;

            new SnakePart(snakeTail).setYCoordinate(newYT).setXCoordinate(newXT);


            spawnFood();
        }
        snake.setLastX(snake.getXCoordinate());
        snake.setLastY(snake.getYCoordinate());
        move(snake, map[newY][newX]);
        snake.moveSnake(snake.getNextPart());
    }

    public static void move(Cell cellOne, Cell cellTwo){

        if(cellOne instanceof SnakePart && cellTwo instanceof SnakePart){
            new LoseWindow();
        }

        map[cellOne.getYCoordinate()][cellOne.getXCoordinate()] = cellTwo;
        map[cellTwo.getYCoordinate()][cellTwo.getXCoordinate()] = cellOne;
        int secY = cellTwo.getYCoordinate();
        int secX = cellTwo.getXCoordinate();
        cellTwo.setYCoordinate(cellOne.getYCoordinate()).setXCoordinate(cellOne.getXCoordinate());
        cellOne.setYCoordinate(secY).setXCoordinate(secX);
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public SnakeHead getSnake() {
        return snake;
    }
}
